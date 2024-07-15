package br.ufrn.imd.ITHelper.controller;

import br.ufrn.imd.ITHelper.model.Address;
import br.ufrn.imd.ITHelper.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> criarAddress(@RequestBody Address Address) {
        Address novoAddress = addressService.salvarEndereco(Address);
        return ResponseEntity.ok(novoAddress);
    }

    // Adicione outros métodos de controle conforme necessário
}

