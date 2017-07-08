package project.mediavault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.mediavault.model.Movie;
import project.mediavault.service.MovieService;

import java.util.List;

/**
 * Movies Controller / APIs
 */
@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private MovieService movieService;

    /**
     * The parameter is Autowired by Spring Framework
     *
     * @param movieService will be autowired by Spring Framework
     */
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Get the movie list and return a ResponseEntity of ModelMap for GET request
     *
     * @return a ResponseEntity of ModelMap
     */
    @GetMapping
    public ResponseEntity<ModelMap> getAllList() {
        List<Movie> movieList = movieService.getAllList();
        ModelMap resultMap = new ModelMap("isSuccessful", true)
                .addAttribute("data", movieList);
        return ResponseEntity.ok(resultMap);
    }


    /**
     * Add a new movie
     *
     * @param movie movie entity (@RequestBody)
     * @return a ResponseEntity of ModelMap
     */
    @PostMapping
    public ResponseEntity<ModelMap> addNewMovie(@RequestBody Movie movie) {
        // TODO [ newly modified ]
        boolean result = movieService.saveNewMovie(movie);
        if (result) {
            return ResponseEntity.ok(new ModelMap("isSuccessful", true));
        } else {
            return ResponseEntity.ok(new ModelMap("isSuccessful", false));
        }
    }

    /**
     * Delete a movie
     *
     * @param id of the movie (@PathVariable)
     * @return a ResponseEntity of ModelMap of the deletion result
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ModelMap> deleteMovie(@PathVariable("id") int id) {
        boolean result = movieService.deleteMovie(id);
        return ResponseEntity.ok(new ModelMap("isSuccessful", result));
    }

    /**
     * Delete the items at one time
     *
     * @param idList a list of items
     * @return a ResponseEntity of ModelMap of the deletion result
     */
    @DeleteMapping
    public ResponseEntity<ModelMap> deleteMultiple(@RequestParam("id[]") List<Integer> idList) {
        for (int id: idList) {
            if (!movieService.deleteMovie(id)) {
                ModelMap result = new ModelMap("isSuccessful", false);
                return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        ModelMap result = new ModelMap("isSuccessful", true);
        return ResponseEntity.ok(result);
    }

    /**
     * Get the detail of the movie
     *
     * @param id of the movie (@PathVariable)
     * @return a ResponseEntity of ModelMap containing the details
     */
    @GetMapping("/{id}")
    public ResponseEntity<ModelMap> getMovieDetail(@PathVariable("id") int id) {
        Movie movie = movieService.getMovieById(id);
        ModelMap resultMap = new ModelMap("isSuccessful", true)
                .addAttribute("data", movie);
        return ResponseEntity.ok(resultMap);
    }

}
