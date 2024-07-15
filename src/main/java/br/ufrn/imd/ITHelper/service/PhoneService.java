package br.ufrn.imd.ITHelper.service;

import br.ufrn.imd.ITHelper.model.Phone;
import br.ufrn.imd.ITHelper.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    public Phone salvarTelefone(Phone telefone) {
        // Adicione lógica de negócios, se necessário
        return phoneRepository.save(telefone);
    }

    // Adicione outros métodos de serviço conforme necessário
}

