package project.mediavault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.mediavault.service.TVShowService;

/**
 * TV Show Controller.
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

}
