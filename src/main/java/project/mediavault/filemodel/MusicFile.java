package project.mediavault.filemodel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import project.mediavault.model.Music;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
    private void updateDocumentFromMusic() {
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document d = document;
        Node rootElement = d.createElement("music");

        Node idElement = d.createElement("id");
        idElement.appendChild(d.createTextNode("" + getId()));
        Node titleElement = d.createElement("title");
        titleElement.appendChild(d.createTextNode(getTitle()));
        Node thumbnailURLElement = d.createElement("thumbnailURL");
        thumbnailURLElement.appendChild(d.createTextNode(getThumbnailURL()));
        Node fileURLElement = d.createElement("fileURL");
        fileURLElement.appendChild(d.createTextNode(getFileURL()));
        Node sizeElement = d.createElement("size");
        sizeElement.appendChild(d.createTextNode("" + getSize()));
        Node ratingElement = d.createElement("rating");
        ratingElement.appendChild(d.createTextNode("" + getRating()));

        rootElement.appendChild(idElement);
        rootElement.appendChild(titleElement);
        rootElement.appendChild(thumbnailURLElement);
        rootElement.appendChild(fileURLElement);
        rootElement.appendChild(sizeElement);
        rootElement.appendChild(ratingElement);

        Node durationElement = d.createElement("duration");
        durationElement.appendChild(d.createTextNode(getDuration()));
        rootElement.appendChild(durationElement);

        document.appendChild(rootElement);
    }

    private void updateMusicFromDocument() {
        Document d = document;
        music = new Music();
        music.setId(Integer.parseInt(d.getElementsByTagName("id").item(0).getTextContent()));
        music.setTitle(d.getElementsByTagName("title").item(0).getTextContent());
        music.setSize(Long.parseLong(d.getElementsByTagName("size").item(0).getTextContent()));
        music.setFileURL(d.getElementsByTagName("fileURL").item(0).getTextContent());
        music.setThumbnailURL(d.getElementsByTagName("thumbnailURL").item(0).getTextContent());
        music.setRating(Double.parseDouble(d.getElementsByTagName("rating").item(0).getTextContent()));
        
        music.setDuration(d.getElementsByTagName("duration").item(0).getTextContent());
    }

}
