package project.mediavault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.mediavault.service.MediaService;

@RestController
@RequestMapping("/api/entire-library")
public class EntireLibraryController {

    private MediaService mediaService;

    @Autowired
    public EntireLibraryController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public ModelMap getEntireLibrary() {
        return new ModelMap("data", mediaService.getAllList());
    }

}
