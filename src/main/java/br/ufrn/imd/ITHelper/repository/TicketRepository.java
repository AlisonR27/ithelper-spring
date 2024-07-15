package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.Ticket;
import br.ufrn.imd.ITHelper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByStatusChamado(char statusChamado);
    // Adicione métodos personalizados de acesso a dados, se necessário

    List<Ticket> findByFuncionario_usuario_nomeUsuario(String nomeUsuario);

    //List<Ticket> countTicketByD
}

