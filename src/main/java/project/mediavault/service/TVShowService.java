package project.mediavault.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import project.mediavault.model.Actor;
import project.mediavault.model.Episode;
import project.mediavault.model.TVShow;
import project.mediavault.repository.ActorRepository;
import project.mediavault.repository.EpisodeRepository;
import project.mediavault.repository.TVShowRepository;

import java.util.*;

/**
 * CRUD Bean for TV Show.
 */
@SuppressWarnings("Duplicates")
@Service
public class TVShowService {

    private TVShowRepository tvShowRepository;
    private EpisodeRepository episodeRepository;
    private ActorRepository actorRepository;

    @Autowired
    public TVShowService(TVShowRepository tvShowRepository, EpisodeRepository episodeRepository, ActorRepository actorRepository) {
        this.tvShowRepository = tvShowRepository;
        this.episodeRepository = episodeRepository;
        this.actorRepository = actorRepository;
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
            actorRepository.save(tvShow.getActors());
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
            TVShow tvShow = tvShowRepository.findOne(id);
            tvShow.getEpisodes().removeIf(
                    episodeItem -> episodeItem.getSeason() == season && episodeItem.getEpisode() == episode
            );
            episodeRepository.deleteBySeasonAndEpisode(season, episode);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addEpisode(int tvShowId, Episode episode) {
        try {
            TVShow tvShow = tvShowRepository.findOne(tvShowId);
            episodeRepository.save(episode);
            tvShow.getEpisodes().add(episode);
            tvShowRepository.save(tvShow);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
