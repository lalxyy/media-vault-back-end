package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.mediavault.model.Movie;
import project.mediavault.repository.MovieRepository;

import java.util.*;

/**
 * Movie Service.
 */
@SuppressWarnings("Duplicates")
@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllList() {
        return movieRepository.findAll();
    }

    public boolean saveNewMovie(Movie movie) {
        try {
            movieRepository.save(movie);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean modifyExistedMovie(Movie movie) {
        // TODO Temporary
        return saveNewMovie(movie);
    }

    public boolean deleteMovie(int id) {
        try {
            movieRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Movie getMovieById(int id) {
        return movieRepository.findOne(id);
    }

}
