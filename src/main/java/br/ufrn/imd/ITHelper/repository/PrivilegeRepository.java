package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, String> {
    public Privilege findByName(String name);
}
