package project.mediavault.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.mediavault.model.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MediaService {

    private ObjectMapper objectMapper;

    private MovieService movieService;
    private TVShowService tvShowService;
    private PhotoService photoService;
    private MusicService musicService;

    @Autowired
    public MediaService(MovieService movieService, TVShowService tvShowService, PhotoService photoService, MusicService musicService, ObjectMapper objectMapper) {
        this.movieService = movieService;
        this.tvShowService = tvShowService;
        this.photoService = photoService;
        this.musicService = musicService;

        this.objectMapper = objectMapper;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAllList() {
        List<Map<String, Object>> mediaList = new ArrayList<>();
        movieService.getAllList().forEach(movie -> {
            Map map = objectMapper.convertValue(movie, Map.class);
            map.put("type", "Movies");
            mediaList.add(map);
        });
        tvShowService.getAllList().forEach(tvShow -> {
            Map map = objectMapper.convertValue(tvShow, Map.class);
            map.put("type", "TVShows");
            mediaList.add(map);
        });
        photoService.getAllList().forEach(photo -> {
            Map map = objectMapper.convertValue(photo, Map.class);
            map.put("type", "Photos");
            mediaList.add(map);
        });
        musicService.getAllList().forEach(music -> {
            Map map = objectMapper.convertValue(music, Map.class);
            map.put("type", "Music");
            mediaList.add(map);
        });
        return mediaList;
    }

}
