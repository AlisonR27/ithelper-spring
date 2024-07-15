package br.ufrn.imd.ITHelper.controller;

import br.ufrn.imd.ITHelper.model.TicketAttribution;
import br.ufrn.imd.ITHelper.service.TicketAttributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/atribuicao-chamado")
public class TicketAttributionController {

    @Autowired
    private TicketAttributionService atribuicaoChamadoService;

    @PostMapping
    public ResponseEntity<Object> createTicketAttribution(@RequestBody TicketAttribution atribuicaoChamado) {
        try {
            // Adicionar dataHoraAtribuicao padrão se não estiver definido
            if (atribuicaoChamado.getDataHoraAtribuicao() == null) {
                atribuicaoChamado.setDataHoraAtribuicao(new Timestamp(new Date().getTime()));
            }

            TicketAttribution novaAtribuicaoChamado = atribuicaoChamadoService.criarAtribuicaoChamado(atribuicaoChamado);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaAtribuicaoChamado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Add other controller methods if needed
}

