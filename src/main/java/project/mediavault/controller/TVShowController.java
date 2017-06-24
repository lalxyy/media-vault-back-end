package project.mediavault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.mediavault.model.Episode;
import project.mediavault.model.TVShow;
import project.mediavault.service.TVShowService;

import java.util.List;

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
    public ResponseEntity<ModelMap> getAll() {
        // TODO 【这里是也是改成要返回带isSuccessful的么？】
//        return new ModelMap("data", tvShowService.getAllList());
        List<TVShow> tvShowList = tvShowService.getAllList();
        ModelMap result = new ModelMap("isSuccessful", true)
                .addAttribute("data", tvShowList);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ModelMap> addTVShow(@RequestBody TVShow tvShow) {
        // TODO [ newly modified ]
        boolean result = tvShowService.add(tvShow);
        return ResponseEntity.ok(new ModelMap("isSuccessful", result));
//        if (result) {
//            return ResponseEntity.ok(new ModelMap("isSuccessful", true));
//        } else {
//            return ResponseEntity.ok(new ModelMap("isSuccessful", false));
//        }

//        return new ModelMap("success", true);
    }

    /**
     * (TODO need to modify)
     *
     * @param id      Episode ID
     * @param episode Episode entity
     * @return ResponseEntity of ModelMap
     */
    public ResponseEntity<ModelMap> addEpisode(@RequestBody int id, @RequestBody Episode episode) {
        boolean result = tvShowService.addEpisode(id, episode);
        return ResponseEntity.ok(new ModelMap("isSuccessful", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModelMap> delete(@PathVariable("id") int id,
                                           @RequestParam("season") int season,
                                           @RequestParam("episode") int episode) {
        if (tvShowService.deleteEpisode(id, season, episode)) {
            return ResponseEntity.ok(new ModelMap("isSuccessful", true));
        } else { // TODO "Internal Server Error"
            return new ResponseEntity<>(new ModelMap(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        return ResponseEntity.ok(new ModelMap("success", true));
    }

    @GetMapping("/{id}/episode")
    public ResponseEntity<ModelMap> getEpisodes(@PathVariable("id") int id) {
        return ResponseEntity.ok(new ModelMap("data", tvShowService.getEpisodes(id)));
    }

}
