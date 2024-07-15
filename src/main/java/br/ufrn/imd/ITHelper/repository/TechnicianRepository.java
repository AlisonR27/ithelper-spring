package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    // Add custom methods if needed
}

