package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    // Adicione métodos personalizados, se necessário
}

