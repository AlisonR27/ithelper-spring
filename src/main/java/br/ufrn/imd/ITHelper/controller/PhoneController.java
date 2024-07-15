package br.ufrn.imd.ITHelper.controller;

import br.ufrn.imd.ITHelper.model.Phone;
import br.ufrn.imd.ITHelper.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telefone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @PostMapping
    public ResponseEntity<Phone> criarPhone(@RequestBody Phone telefone) {
        Phone novoPhone = phoneService.salvarTelefone(telefone);
        return ResponseEntity.ok(novoPhone);
    }

    // Adicione outros métodos de controle conforme necessário
}

