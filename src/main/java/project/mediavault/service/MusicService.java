package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.mediavault.model.Music;

import java.util.*;

/**
 * Music Service.
 *
 * @author Carl Li
 */
@Service
public class MusicService {

    @Autowired
    public MusicService() {
        //
    }

    public List<Music> getAllList() {
        return null;
    }

    public boolean saveNewMusic(Music music) {
        return false;
    }

    public boolean modifyExistedMusic(Music music) {
        return false;
    }

    public boolean deleteMusic(int id) {
        return false;
    }

    public Music getMusicById(int id) {
        return null;
    }

}
