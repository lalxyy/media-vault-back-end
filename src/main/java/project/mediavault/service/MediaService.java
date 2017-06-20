package project.mediavault.service;

import org.springframework.stereotype.Service;
import project.mediavault.model.Media;

import java.util.ArrayList;
import java.util.List;

@Service
public class MediaService {

    public List<Media> getAllList() {
        List<Media> mediaList = new ArrayList<>();
        return mediaList;
    }

    public boolean deleteMedia(int id) {
        return true;
    }

}
