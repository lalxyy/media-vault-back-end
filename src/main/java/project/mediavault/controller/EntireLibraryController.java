package project.mediavault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.mediavault.model.Media;
import project.mediavault.service.MediaService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entire-library")
public class EntireLibraryController {

    private MediaService mediaService;

    @Autowired
    public EntireLibraryController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public ResponseEntity<ModelMap> getEntireLibrary() {
        List<Map<String, Object>> mediaList = mediaService.getAllList();
        ModelMap result = new ModelMap("isSuccessful", true)
                .addAttribute("data", mediaList);
        return ResponseEntity.ok(result);
    }

}
