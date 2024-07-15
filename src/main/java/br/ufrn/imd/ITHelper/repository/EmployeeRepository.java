package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query("SELECT f FROM Funcionario f WHERE f.departamento.id = ?1")
//    List<Employee> findByDepartamentoId(Long departamentoId);

    List<Employee> findByDepartamento_IdDepartamento(Long departamentoId);

}

