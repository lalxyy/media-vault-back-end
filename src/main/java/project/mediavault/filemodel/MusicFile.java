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

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
        updateDocumentFromMusic();
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
        updateMusicFromDocument();
    }

    public int getId() {
        return music.getId();
    }

    public void setId(int id) {
        music.setId(id);
        updateDocumentFromMusic();
    }

    private void updateMusicFromDocument() {
        //
    }

    private void updateDocumentFromMusic() {
        //
    }

}
