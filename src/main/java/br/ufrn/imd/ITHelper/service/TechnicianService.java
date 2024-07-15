package br.ufrn.imd.ITHelper.service;

import br.ufrn.imd.ITHelper.model.Technician;
import br.ufrn.imd.ITHelper.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;

    public Technician saveTechnician(Technician technician) {
        // Add business logic if needed
        return technicianRepository.save(technician);
    }

    // Add other service methods if needed
}

