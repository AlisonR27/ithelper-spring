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
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privileges", fetch=FetchType.EAGER)
    private Collection<Role> roles;

    public Privilege(String name) {
        this.name = name;
    }
    public Privilege() {

    }

    public Collection<Role> getRoles() {
        return roles;
    }



    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

}
