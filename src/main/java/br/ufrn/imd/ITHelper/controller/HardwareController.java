package br.ufrn.imd.ITHelper.controller;

import br.ufrn.imd.ITHelper.model.Hardware;
import br.ufrn.imd.ITHelper.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipamento")
public class HardwareController {

    @Autowired
    private HardwareService hardwareService;

    @PostMapping
    public ResponseEntity<Hardware> createHardware(@RequestBody Hardware hardware) {
        Hardware newHardware = hardwareService.saveHardware(hardware);
        return ResponseEntity.ok(newHardware);
    }

    // Add other controller methods if needed
}

