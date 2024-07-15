package br.ufrn.imd.ITHelper.controller;

import br.ufrn.imd.ITHelper.config.Views;
import br.ufrn.imd.ITHelper.dto.TicketDTO;
import br.ufrn.imd.ITHelper.model.Employee;
import br.ufrn.imd.ITHelper.model.Ticket;
import br.ufrn.imd.ITHelper.repository.EmployeeRepository;
import br.ufrn.imd.ITHelper.repository.TicketRepository;
import br.ufrn.imd.ITHelper.service.TicketService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/chamados")
public class TicketContoller {

    private final TicketService ticketService;
    private final EmployeeRepository employeeRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketContoller(TicketService ticketService, EmployeeRepository employeeRepository, TicketRepository ticketRepository) {
        this.ticketService = ticketService;
        this.employeeRepository = employeeRepository;
        this.ticketRepository = ticketRepository;
    }

    @PostMapping("/criarChamado")
    public ResponseEntity<Object> criarTicket(@RequestBody Ticket chamado) {
        try {
            Long employeeId = chamado.getFuncionario().getIdFuncionario();

            // Encontrar o Funcionario pelo ID
            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new RuntimeException("Funcionario not found with ID: " + employeeId));

            // Verifica se o funcionario existe
            if (employee != null) {
                chamado.setFuncionario(employee);

                // Atribuir valores padrão se não estiverem definidos
                if (chamado.getPrioridade() == 0) {
                    chamado.setPrioridade('N');
                }

                if (chamado.getStatusChamado() == 0) {
                    chamado.setStatusChamado('P');
                }

                if (chamado.getDataHoraAbertura() == null) {
                    chamado.setDataHoraAbertura(new Timestamp(System.currentTimeMillis()));
                }



                Ticket novoTicket = ticketService.criarTicket(chamado);
                return ResponseEntity.status(HttpStatus.CREATED).body("SUCESSO");
            }

            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("chamado/{id}")
    public ResponseEntity<Object> updateTicket(@RequestBody Ticket chamado, @PathVariable Long id) {
        try {
            Ticket c = ticketRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Ticket not found with ID: " + id));
            c.setPrioridade(chamado.getPrioridade());
            c.setStatusChamado(chamado.getStatusChamado());
            c.setDescricaoChamado(chamado.getDescricaoChamado());
            c.setTituloChamado(chamado.getTituloChamado());
            ticketRepository.save(c);
            return ResponseEntity.status(HttpStatus.CREATED).body("SUCESS");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(Views.Public.class)
    public ResponseEntity<Ticket> obterTicketPorId(@PathVariable Long id) {
        Ticket chamado = ticketService.obterTicketPorId(id);
        if (chamado != null) {
            return ResponseEntity.ok(chamado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/abertos")
    @JsonView(Views.Public.class)
    public ResponseEntity<List<TicketDTO>> obterTicketsAbertos() {
        try {
            List<TicketDTO> ticketsAbertos = ticketService.obterTicketsAbertos();
            if (!ticketsAbertos.isEmpty()) {
                return ResponseEntity.ok(ticketsAbertos);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/vinculados/{nomeusuario}")
    @JsonView(Views.Public.class)
    public ResponseEntity<List<TicketDTO>> obterTicketsVinculados(@PathVariable String nomeusuario) {
        List<TicketDTO> ticketsVinculados = ticketService.obterTicketsVinculados(nomeusuario);
        if (!ticketsVinculados.isEmpty()) {
            return ResponseEntity.ok(ticketsVinculados);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @JsonView(Views.Public.class)
    public List<TicketDTO> listarTickets() {
        return ticketService.listarTickets();
    }

    // Adicione outros métodos conforme necessário, como atualizar e excluir chamados
}


