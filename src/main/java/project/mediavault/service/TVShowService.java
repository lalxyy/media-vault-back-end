package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.mediavault.model.Episode;
import project.mediavault.model.TVShow;
import project.mediavault.repository.EpisodeRepository;
import project.mediavault.repository.TVShowRepository;

import java.util.*;

/**
 * CRUD Bean for TV Show.
 *
 * @author Carl Li
 */
@SuppressWarnings("Duplicates")
@Service
public class TVShowService {

    private TVShowRepository tvShowRepository;
    private EpisodeRepository episodeRepository;

    @Autowired
    public TVShowService(TVShowRepository tvShowRepository, EpisodeRepository episodeRepository) {
        this.tvShowRepository = tvShowRepository;
        this.episodeRepository = episodeRepository;
    }

    public TVShow getTVShowWithAllEpisode(int id) {
        return tvShowRepository.findOne(id);
    }

    public List<TVShow> getAllList() {
        return tvShowRepository.findAll();
    }

    public boolean delete(int id) {
        try {
            tvShowRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean modify(TVShow tvShow) {
        // TODO Temporary
        return add(tvShow);
    }

    public boolean add(TVShow tvShow) {
        try {
            tvShowRepository.save(tvShow);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Episode> getEpisodes(int id) {
        return tvShowRepository.findOne(id).getEpisodes();
    }

    public boolean deleteEpisode(int id, int season, int episode) {
        try {
            tvShowRepository.findOne(id).getEpisodes().removeIf(
                    episodeItem -> episodeItem.getSeason() == season && episodeItem.getEpisode() == episode
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addEpisode(int tvShowId, Episode episode) {
        return false;
    }

}
