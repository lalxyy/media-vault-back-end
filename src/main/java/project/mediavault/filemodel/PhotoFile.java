package project.mediavault.filemodel;

import org.w3c.dom.Document;
import project.mediavault.model.Photo;

public class PhotoFile {

    private Photo photo;
    private Document document;

    public PhotoFile(Photo photo) {
        this.photo = photo;
        updateDocumentFromPhoto();
    }

    public PhotoFile(Document document) {
        this.document = document;
        updatePhotoFromDocument();
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
        updateDocumentFromPhoto();
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
        updatePhotoFromDocument();
    }

    public int getId() {
        return photo.getId();
    }

    public void setId(int id) {
        photo.setId(id);
        updateDocumentFromPhoto();
    }

    private void updateDocumentFromPhoto() {
        //
    }

    private void updatePhotoFromDocument() {
        //
    }

}
