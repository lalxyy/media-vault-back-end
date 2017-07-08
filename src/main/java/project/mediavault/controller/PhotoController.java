package project.mediavault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.mediavault.model.Music;
import project.mediavault.model.Photo;
import project.mediavault.service.PhotoService;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<ModelMap> getAllList() {
        List<Photo> photoList = photoService.getAllList();
        ModelMap result = new ModelMap("isSuccessful", true)
                .addAttribute("data", photoList);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ModelMap> add(@RequestBody Photo photo) {
        boolean isSuccessful = photoService.saveNewPhoto(photo);
        ModelMap result = new ModelMap("isSuccessful", isSuccessful);
        if (isSuccessful) {
            return ResponseEntity.ok(result);
        } else {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModelMap> delete(@PathVariable("id") int id) {
        boolean isSuccessful = photoService.deletePhoto(id);
        ModelMap result = new ModelMap("isSuccessful", isSuccessful);
        if (isSuccessful) {
            return ResponseEntity.ok(result);
        } else {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<ModelMap> deleteMultiple(@RequestParam("id[]") List<Integer> idList) {
        for (int id: idList) {
            if (!photoService.deletePhoto(id)) {
                ModelMap result = new ModelMap("isSuccessful", false);
                return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        ModelMap result = new ModelMap("isSuccessful", true);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelMap> getDetails(@PathVariable("id") int id) {
        Photo photo = photoService.getPhotoById(id);
        ModelMap result = new ModelMap("isSuccessful", true)
                .addAttribute("data", photo);
        return ResponseEntity.ok(result);
    }
}
