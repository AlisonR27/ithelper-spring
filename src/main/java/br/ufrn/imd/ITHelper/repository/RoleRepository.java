package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    public Role findByName(String name);
}
