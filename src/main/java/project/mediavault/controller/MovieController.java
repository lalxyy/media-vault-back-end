package project.mediavault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.mediavault.model.Movie;
import project.mediavault.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<ModelMap> getAllList() {
        List<Movie> movieList = movieService.getAllList();
        ModelMap result = new ModelMap("isSuccessful", true)
                .addAttribute("data", movieList);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ModelMap> addNewMovie(@RequestBody Movie movie) {
        boolean result = movieService.saveNewMovie(movie);

        if (result) {

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModelMap> deleteMovie(@PathVariable("id") int id) {
//        boolean result =
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelMap> getMovieDetail(@PathVariable("id") int id) {
        Movie movie = movieService.getMovieById(id);
        ModelMap result = new ModelMap("isSuccessful", true)
                .addAttribute("data", movie);
        return ResponseEntity.ok(result);
    }

}
