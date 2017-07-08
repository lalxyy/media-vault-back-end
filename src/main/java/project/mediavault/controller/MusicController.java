package project.mediavault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.mediavault.model.Music;
import project.mediavault.service.MusicService;

import java.util.List;

/**
 * Music Controller / APIs
 */
@RestController
@RequestMapping("/api/music")
public class MusicController {

    private MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping
    public ResponseEntity<ModelMap> getAllList() {
        List<Music> musicList = musicService.getAllList();
        ModelMap result = new ModelMap("isSuccessful", true)
                .addAttribute("data", musicList);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ModelMap> add(@RequestBody Music music) {
        boolean isSuccessful = musicService.saveNewMusic(music);
        ModelMap result = new ModelMap("isSuccessful", isSuccessful);
        if (isSuccessful) {
            return ResponseEntity.ok(result);
        } else {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModelMap> delete(@PathVariable("id") int id) {
        boolean isSuccessful = musicService.deleteMusic(id);
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
            if (!musicService.deleteMusic(id)) {
                ModelMap result = new ModelMap("isSuccessful", false);
                return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        ModelMap result = new ModelMap("isSuccessful", true);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelMap> getDetails(@PathVariable("id") int id) {
        Music music = musicService.getMusicById(id);
        ModelMap result = new ModelMap("isSuccessful", true)
                .addAttribute("data", music);
        return ResponseEntity.ok(result);
    }

}
