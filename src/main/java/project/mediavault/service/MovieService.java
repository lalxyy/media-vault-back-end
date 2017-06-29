package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.mediavault.model.Movie;

import java.util.*;

/**
 * Movie Service.
 *
 * @author Carl Li
 */
@SuppressWarnings("Duplicates")
@Service
public class MovieService {

    @Autowired
    public MovieService() {
        //
    }

    public List<Movie> getAllList() {
        return null;
    }

    public boolean saveNewMovie(Movie movie) {
        return false;
    }

    public boolean modifyExistedMovie(Movie movie) {
        return false;
    }

    public boolean deleteMovie(int id) {
        return false;
    }

    public Movie getMovieById(int id) {
        return null;
    }

}
