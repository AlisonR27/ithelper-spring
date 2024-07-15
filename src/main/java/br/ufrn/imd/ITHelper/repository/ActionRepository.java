package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Long> {
    // Add custom methods if needed
}

