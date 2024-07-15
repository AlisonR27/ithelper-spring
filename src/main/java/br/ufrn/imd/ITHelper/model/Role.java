package br.ufrn.imd.ITHelper.model;

import br.ufrn.imd.ITHelper.config.Views;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
public class Role {

    @Id
    @Column(name="id", unique = true )
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name", unique = true)
    private String name;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "id", nullable = true),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id"))
    private Collection<Privilege> privileges;

    public Role() {

    }
    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }
}
