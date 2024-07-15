package br.ufrn.imd.ITHelper.controller;

import br.ufrn.imd.ITHelper.model.Department;
import br.ufrn.imd.ITHelper.model.Ticket;
import br.ufrn.imd.ITHelper.repository.TicketAttributionRepository;
import br.ufrn.imd.ITHelper.service.TicketAttributionService;
import br.ufrn.imd.ITHelper.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PlottingController {
    private final TicketAttributionRepository ticketAttributionRepository;

    public PlottingController(TicketService ticketService, TicketAttributionRepository ticketAttributionRepository) {
        this.ticketAttributionRepository = ticketAttributionRepository;
    }

    @GetMapping("/plots/{type}")
    public ResponseEntity<List<Object>> plots(@PathVariable String type) {
        List<Object> results = ticketAttributionRepository.countTicketsByDepartment();
        return ResponseEntity.ok(results);
    }
}
