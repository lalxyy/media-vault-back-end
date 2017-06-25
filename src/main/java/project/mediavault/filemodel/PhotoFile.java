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

    // TODO Media File
    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
        updateDocumentFromPhoto();
    }

    // TODO Document
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
        updatePhotoFromDocument();
    }

    // TODO Basic Fields
    public int getId() {
        return photo.getId();
    }

    public void setId(int id) {
        photo.setId(id);
        updateDocumentFromPhoto();
    }

    public String getTitle() {
        return photo.getTitle();
    }

    public void setTitle(String title) {
        photo.setTitle(title);
        updateDocumentFromPhoto();
    }

    public double getRating() {
        return photo.getRating();
    }

    public void setRating(double rating) {
        photo.setRating(rating);
        updateDocumentFromPhoto();
    }

    public String getThumbnailURL() {
        return photo.getThumbnailURL();
    }

    public void setThumbnailURL(String thumbnailURL) {
        photo.setThumbnailURL(thumbnailURL);
        updateDocumentFromPhoto();
    }

    public String getFileURL() {
        return photo.getFileURL();
    }

    public void setFileURL(String fileURL) {
        photo.setFileURL(fileURL);
        updateDocumentFromPhoto();
    }

    public Long getSize() {
        return photo.getSize();
    }

    public void setSize(Long size) {
        photo.setSize(size);
        updateDocumentFromPhoto();
    }

    // TODO Extra Fields



    // TODO Update Document
    private void updateDocumentFromPhoto() {
        //
    }

    private void updatePhotoFromDocument() {
        //
    }

}
