package br.ufrn.imd.ITHelper.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Endereco", schema = "public")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idendereco")
    private Long idEndereco;

    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private User usuario;

    @Column(name = "logradouro", length = 40)
    private String logradouro;

    @Column(name = "bairro", length = 40)
    private String bairro;

    @Column(name = "municipio", length = 40)
    private String municipio;

    @Column(name = "uf", length = 2)
    private String uf;

    // Construtores, getters e setters

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
