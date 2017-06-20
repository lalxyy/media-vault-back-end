package project.mediavault.service;

import org.springframework.stereotype.Service;
import project.mediavault.model.Episode;
import project.mediavault.model.TVShow;

import java.util.ArrayList;
import java.util.List;

/**
 * CRUD Bean for TV Show.
 *
 * @author Carl Li
 */
@Service
public class TVShowService {

    public TVShowService() {
        //
    }

    public List<TVShow> getAllList() {
        List<TVShow> tvShowList = new ArrayList<>();
        return tvShowList;
    }

    public boolean delete(int id) {
        return true;
    }

    public List<Episode> getEpisodes(int id) {
        List<Episode> episodeList = new ArrayList<>();
        return episodeList;
    }

    public boolean deleteEpisode(int id, int season, int episode) {
        return true;
    }

}
