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
 * TV Show & Episode Controller / APIs
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

    /**
     * Get a list of TV Show from GET request
     *
     * @return a ResponseEntity of ModelMap
     */
    @GetMapping
    public ResponseEntity<ModelMap> getAll() {
        // TODO 【这里是也是改成要返回带isSuccessful的么？】
//        return new ModelMap("data", tvShowService.getAllList());
        List<TVShow> tvShowList = tvShowService.getAllList();
        ModelMap resultMap = new ModelMap("isSuccessful", true)
                .addAttribute("data", tvShowList);
        return ResponseEntity.ok(resultMap);
    }

    /**
     * Add new TV Show From POST request
     *
     * @param tvShow @RequestBody
     * @return a ResponseEntity of ModelMap
     */
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
     * Add new episode of the TV Show
     *
     * @param id      The ID of TV Show (@PathVariable) which episode will be add to
     * @param episode Episode entity (@RequestBody)
     * @return a ResponseEntity of ModelMap
     */
    @PostMapping("/{id}") // TODO 还是用的POST，然后
    public ResponseEntity<ModelMap> addEpisode(@PathVariable("id") int id,
                                               @RequestBody Episode episode) {
        boolean result = tvShowService.addEpisode(id, episode);
        return ResponseEntity.ok(new ModelMap("isSuccessful", result)); // TODO 直接返回的result
    }

    /**
     * Delete the Episode
     *
     * @param id      TV Show ID (@PathVariable)
     * @param season  season number (RequestParam)
     * @param episode episode ID (@RequestParam)
     * @return a ResponseEntity of ModelMap
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ModelMap> deleteEpisode(@PathVariable("id") int id,
                                                  @RequestParam("season") int season,
                                                  @RequestParam("episode") int episode) {
        if (tvShowService.deleteEpisode(id, season, episode)) {
            return ResponseEntity.ok(new ModelMap("isSuccessful", true));
        } else { // TODO "Internal Server Error"
            return new ResponseEntity<>(new ModelMap(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        return ResponseEntity.ok(new ModelMap("success", true));
    }

    /**
     * Delete the whole TV Show
     *
     * @return result
     */
    public ResponseEntity<?> deleteTVShow(@RequestParam("id") int id) {
        // TODO 删除整个TVShow
        return null;
    }

    @GetMapping("/{id}/episode")
    public ResponseEntity<ModelMap> getEpisodes(@PathVariable("id") int id) {
        return ResponseEntity.ok(new ModelMap("data", tvShowService.getEpisodes(id)));
    }

}
