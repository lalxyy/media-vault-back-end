package project.mediavault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.mediavault.service.TVShowService;

/**
 * TV Show & Episode Controller.
 *
 * @author Carl Li
 */
@RestController
@RequestMapping("/api/tv-show")
public class TVShowController {

    private TVShowService tvShowService;

    @Autowired
    public TVShowController(TVShowService tvShowService) {
        this.tvShowService = tvShowService;
    }

    @GetMapping
    public ModelMap getAll() {
        return new ModelMap("data", tvShowService.getAllList());
    }

    @PostMapping
    public ModelMap add() {
        return new ModelMap("success", true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModelMap> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(new ModelMap("success", true));
    }

    @GetMapping("/{id}/episode")
    public ResponseEntity<ModelMap> getEpisodes(@PathVariable("id") int id) {
        return ResponseEntity.ok(new ModelMap("data", tvShowService.getEpisodes(id)));
    }

}
