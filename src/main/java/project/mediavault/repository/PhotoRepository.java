package project.mediavault.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import project.mediavault.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer>, JpaSpecificationExecutor<Photo> {
    //
}
