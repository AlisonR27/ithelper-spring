package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.Department;
import br.ufrn.imd.ITHelper.model.Ticket;
import br.ufrn.imd.ITHelper.model.TicketAttribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TicketAttributionRepository extends JpaRepository<TicketAttribution, Long> {
    // Add custom methods if needed
    @Query(
            value = "SELECT t.chamado.funcionario.departamento.nomeDepartamento, COUNT(t.chamado) FROM TicketAttribution t GROUP BY t.chamado, t.chamado.funcionario.departamento"
    )
    List<Object> countTicketsByDepartment();
}
