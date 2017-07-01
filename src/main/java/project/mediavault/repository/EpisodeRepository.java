package project.mediavault.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import project.mediavault.model.Episode;

import javax.transaction.Transactional;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer>, JpaSpecificationExecutor<Episode> {

    @Transactional
    void deleteBySeasonAndEpisode(int season, int episode);

}
