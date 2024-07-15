package br.ufrn.imd.ITHelper.model;

import br.ufrn.imd.ITHelper.config.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="Usuario", schema = "public")
@JsonPropertyOrder({"id", "nomeCompleto", "email", "dataNascimento", "nomeUsuario", "tipoUsuario"})
public class User implements UserDetails {
    @Id
    @Column(name="idusuario", unique = true )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40, name = "nomecompleto")
    private String nomeCompleto;

    @Column(length = 30, name = "email")
    private String email;

    @Column(name = "datanascimento")
    private Timestamp dataNascimento;

    @Column(length = 30, unique = true, name = "nomeusuario")
    private String nomeUsuario;

    @Column(length = 1, name = "tipousuario")
    private String tipoUsuario;

    @Column(length = 73, name = "senhausuario")
    private String password;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "image_id", referencedColumnName = "id", nullable = true)
    private Image profilePicture;

    @JsonIgnore
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "idusuario"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id", nullable = true))
    private Collection<Role> roles;

    public User() {

    }


    @JsonView({Views.Public.class})
    public Image getProfilePicture() { return profilePicture; }
    public void setProfilePicture(Image profilePicture) { this.profilePicture = profilePicture; }

    @JsonView({Views.Public.class})
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonView({Views.Public.class})
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public String getPass() {
        return password;
    }

    public void setPass(String encryptedPassword) {
        this.password = encryptedPassword;
    }

    @JsonView({Views.Public.class})
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    @JsonView({Views.Public.class})
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonView({Views.Public.class})
    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @JsonView({Views.Public.class})
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public Collection <? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role: roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.addAll(role.getPrivileges()
                    .stream()
                    .map(p -> new SimpleGrantedAuthority(p.getName()))
                    .collect(Collectors.toList()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nomeUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }


}
