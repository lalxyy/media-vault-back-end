package project.mediavault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.mediavault.service.PhotoService;

/**
 * Photos Controller / APIs
 */
@RestController
@RequestMapping("/api/photo")
public class PhotoController {
    private PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }
}
