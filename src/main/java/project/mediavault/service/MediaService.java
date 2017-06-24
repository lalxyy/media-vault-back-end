package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.mediavault.model.Media;

import java.util.ArrayList;
import java.util.List;

@Service
public class MediaService {

    private MovieService movieService;
    private TVShowService tvShowService;
    private PhotoService photoService;
    private MusicService musicService;

    @Autowired
    public MediaService(MovieService movieService, TVShowService tvShowService, PhotoService photoService, MusicService musicService) {
        this.movieService = movieService;
        this.tvShowService = tvShowService;
        this.photoService = photoService;
        this.musicService = musicService;
    }

    public List<Media> getAllList() {
        List<Media> mediaList = new ArrayList<>();
        mediaList.addAll(movieService.getAllList());
        mediaList.addAll(tvShowService.getAllList());
        mediaList.addAll(photoService.getAllList());
        mediaList.addAll(musicService.getAllList());
        return mediaList;
    }

}
