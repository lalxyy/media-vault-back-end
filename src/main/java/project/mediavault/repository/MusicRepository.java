package project.mediavault.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import project.mediavault.model.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer>, JpaSpecificationExecutor<Music> {
    //
}
