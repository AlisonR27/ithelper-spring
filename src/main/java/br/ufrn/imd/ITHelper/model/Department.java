package br.ufrn.imd.ITHelper.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Departamento", schema = "public")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddepartamento")
    private Long idDepartamento;

    @Column(name = "nomedepartamento")
    private String nomeDepartamento;

    // Outros atributos e métodos da classe

    @OneToMany(mappedBy = "departamento")
    private List<Employee> funcionarios;

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public List<Employee> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Employee> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
