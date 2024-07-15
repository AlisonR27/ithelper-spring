package br.ufrn.imd.ITHelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ufrn.imd.ITHelper.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByNomeUsuario(String nomeUsuario);

    User findById(Integer id);

    void deleteById(Integer id);

}
