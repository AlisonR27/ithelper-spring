package br.ufrn.imd.ITHelper.service;

import br.ufrn.imd.ITHelper.model.Address;
import br.ufrn.imd.ITHelper.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address salvarEndereco(Address endereco) {
        // Adicione lógica de negócios, se necessário
        return addressRepository.save(endereco);
    }

    // Adicione outros métodos de serviço conforme necessário
}

