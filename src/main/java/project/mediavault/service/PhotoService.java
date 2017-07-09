package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.mediavault.model.Photo;
import project.mediavault.repository.PhotoRepository;

import java.util.*;

/**
 * Music Service.
 */
@SuppressWarnings("Duplicates")
@Service
public class PhotoService {

    private PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public List<Photo> getAllList() {
        return photoRepository.findAll();
    }

    public boolean saveNewPhoto(Photo photo) {
        try {
            photoRepository.save(photo);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean modifyExistedPhoto(Photo photo) {
        // TODO Temporary
        return saveNewPhoto(photo);
    }

    public boolean deletePhoto(int photoId) {
        try {
            photoRepository.delete(photoId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Photo getPhotoById(int id) {
        return photoRepository.findOne(id);
    }

}
