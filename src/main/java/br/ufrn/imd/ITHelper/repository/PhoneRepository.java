package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    // Adicione métodos personalizados, se necessário
}

