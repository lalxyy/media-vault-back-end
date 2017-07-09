package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.mediavault.model.Music;
import project.mediavault.repository.MusicRepository;

import java.util.*;

/**
 * Music Service.
 */
@Service
public class MusicService {

    private MusicRepository musicRepository;

    @Autowired
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<Music> getAllList() {
        return musicRepository.findAll();
    }

    public boolean saveNewMusic(Music music) {
        try {
            musicRepository.save(music);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean modifyExistedMusic(Music music) {
        // TODO Temporary
        return saveNewMusic(music);
    }

    public boolean deleteMusic(int id) {
        try {
            musicRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Music getMusicById(int id) {
        return musicRepository.findOne(id);
    }

}
