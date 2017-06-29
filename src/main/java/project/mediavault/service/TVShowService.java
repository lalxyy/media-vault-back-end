package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.mediavault.model.Episode;
import project.mediavault.model.TVShow;

import java.util.*;

/**
 * CRUD Bean for TV Show.
 *
 * @author Carl Li
 */
@SuppressWarnings("Duplicates")
@Service
public class TVShowService {

    @Autowired
    public TVShowService() {
        //
    }

    public Map<String, Object> getTVShowWithAllEpisode(int id) {
        return null;
    }

    public List<TVShow> getAllList() {
        return null;
    }

    public boolean delete(int id) {
        return false;
    }

    public boolean modify(TVShow tvShow) {
        return false;
    }

    public boolean add(TVShow tvShow) {
        return false;
    }

    public List<Episode> getEpisodes(int id) {
        return null;
    }

    public boolean deleteEpisode(int id, int season, int episode) {
        return false;
    }

    public boolean addEpisode(int tvShowId, Episode episode) {
        return false;
    }

}
