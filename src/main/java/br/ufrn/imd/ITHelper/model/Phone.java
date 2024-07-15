package br.ufrn.imd.ITHelper.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Telefone", schema = "public")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtelefone")
    private Long idTelefone;

    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private User usuario;

    @Column(name = "tipotelefone")
    private String tipoTelefone;

    @Column(name = "numerotelefone")
    private String numeroTelefone;

    // Getters and Setters

    public Long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
}
