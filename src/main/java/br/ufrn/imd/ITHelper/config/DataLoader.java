package br.ufrn.imd.ITHelper.config;

import br.ufrn.imd.ITHelper.model.Privilege;
import br.ufrn.imd.ITHelper.model.Role;
import br.ufrn.imd.ITHelper.model.User;
import br.ufrn.imd.ITHelper.repository.PrivilegeRepository;
import br.ufrn.imd.ITHelper.repository.RoleRepository;
import br.ufrn.imd.ITHelper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");


        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        User user = userRepository.findByNomeUsuario("asouza");
        if (user == null) {
            User user1 = new User();
            user1.setNomeCompleto("Alison Souza");
            user1.setNomeUsuario("asouza");
            user1.setPass(passwordEncoder.encode("1234"));
            LocalDate dt =  LocalDate.of(2002,03,27);
            Timestamp dt_nasc = Timestamp.valueOf(dt.atStartOfDay());
            user1.setDataNascimento(dt_nasc);
            user1.setEmail("admin@ithelper.com");
            user1.setRoles(Arrays.asList(adminRole));
            userRepository.save(user1);
        }


        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
            String name, List<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

}
