package br.ufrn.imd.ITHelper.service;

import br.ufrn.imd.ITHelper.model.Hardware;
import br.ufrn.imd.ITHelper.repository.HardwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardwareService {

    @Autowired
    private HardwareRepository hardwareRepository;

    public Hardware saveHardware(Hardware hardware) {
        // Add business logic if needed
        return hardwareRepository.save(hardware);
    }

    // Add other service methods if needed
}

