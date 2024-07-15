package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HardwareRepository extends JpaRepository<Hardware, Long> {
    // Add custom methods if needed
}

