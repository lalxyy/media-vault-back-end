package project.mediavault.filemodel;

import org.w3c.dom.Document;
import project.mediavault.model.Music;

/**
 * Music file model.
 */
public class MusicFile {

    private Music music;
    private Document document;

    public MusicFile(Music music) {
        this.music = music;
        updateDocumentFromMusic();
    }

    public MusicFile(Document document) {
        this.document = document;
        updateMusicFromDocument();
    }

    // TODO Media
    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
        updateDocumentFromMusic();
    }

    // TODO Document
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
        updateMusicFromDocument();
    }

    // TODO Basic Fields
    public int getId() {
        return music.getId();
    }

    public void setId(int id) {
        music.setId(id);
        updateDocumentFromMusic();
    }

    public String getTitle() {
        return music.getTitle();
    }

    public void setTitle(String title) {
        music.setTitle(title);
        updateDocumentFromMusic();
    }

    public double getRating() {
        return music.getRating();
    }

    public void setRating(double rating) {
        music.setRating(rating);
        updateDocumentFromMusic();
    }

    public String getThumbnailURL() {
        return music.getThumbnailURL();
    }

    public void setThumbnailURL(String thumbnailURL) {
        music.setThumbnailURL(thumbnailURL);
        updateDocumentFromMusic();
    }

    public String getFileURL() {
        return music.getFileURL();
    }

    public void setFileURL(String fileURL) {
        music.setFileURL(fileURL);
        updateDocumentFromMusic();
    }

    public Long getSize() {
        return music.getSize();
    }

    public void setSize(Long size) {
        music.setSize(size);
        updateDocumentFromMusic();
    }

    // TODO Extra Fields
    public String getDuration() {
        return music.getDuration();
    }

    public void setDuration(String duration) {
        music.setDuration(duration);
        updateDocumentFromMusic();
    }


    // TODO Update Document
    private void updateMusicFromDocument() {
        //
    }

    private void updateDocumentFromMusic() {
        //
    }

}
