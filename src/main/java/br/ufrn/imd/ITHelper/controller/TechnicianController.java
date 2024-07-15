package br.ufrn.imd.ITHelper.controller;

import br.ufrn.imd.ITHelper.model.Technician;
import br.ufrn.imd.ITHelper.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tecnico")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;

    @PostMapping
    public ResponseEntity<Technician> createTechnician(@RequestBody Technician tecnico) {


        Technician novoTecnico = technicianService.saveTechnician(tecnico);
        return ResponseEntity.ok(novoTecnico);
    }

    // Add other controller methods if needed
}

