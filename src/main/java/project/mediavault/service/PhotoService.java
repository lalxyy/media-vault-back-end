package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.mediavault.model.Photo;

import java.util.*;

@SuppressWarnings("Duplicates")
@Service
public class PhotoService {

    @Autowired
    public PhotoService() {
        //
    }

    public List<Photo> getAllList() {
        return null;
    }

    public boolean saveNewPhoto(Photo photo) {
        return false;
    }

    public boolean modifyExistedPhoto(Photo photo) {
        return false;
    }

    public boolean deletePhoto(int photoId) {
        return false;
    }

    public Photo getPhotoById(int id) {
        return null;
    }

}
