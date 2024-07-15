package br.ufrn.imd.ITHelper.repository;

import br.ufrn.imd.ITHelper.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository  extends JpaRepository<Image, Long> {

}
