package br.ufrn.imd.ITHelper.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tecnico")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTecnico")
    private Long idTecnico;

    @ManyToOne
    @JoinColumn(name = "idfuncionario", nullable = false)
    private Employee funcionario;


    // Getters and Setters

    public Long getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Long idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Employee getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Employee funcionario) {
        this.funcionario = funcionario;
    }
}
