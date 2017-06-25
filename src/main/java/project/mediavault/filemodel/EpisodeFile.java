package project.mediavault.filemodel;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import project.mediavault.model.Episode;
import project.mediavault.model.TVShow;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class EpisodeFile {

    private Episode episode;
    private Document document;

    public EpisodeFile(Episode episode) {
        this.episode = episode;
        updateDocumentFromEpisode();
    }

    public EpisodeFile(Document document) {
        this.document = document;
        updateEpisodeFromDocument();
    }

    public Episode getEpisodeItem() {
        return episode;
    }

    public void setEpisodeItem(Episode episode) {
        this.episode = episode;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public int getId() {
        return episode.getId();
    }

    public int getSeason() {
        return episode.getSeason();
    }

    public String getTitle() {
        return episode.getTitle();
    }

    public void setEpisode(int episode) {
        this.episode.setEpisode(episode);
        updateDocumentFromEpisode();
    }

    public void setDuration(String duration) {
        episode.setDuration(duration);
        updateDocumentFromEpisode();
    }

    public void setThumbnailURL(String thumbnailURL) {
        episode.setThumbnailURL(thumbnailURL);
        updateDocumentFromEpisode();
    }

    public int getEpisode() {
        return episode.getEpisode();
    }

    public String getCredits() {
        return episode.getCredits();
    }

    public void setDirector(String director) {
        episode.setDirector(director);
    }

    public String getDuration() {
        return episode.getDuration();
    }

    public void setCredits(String credits) {
        episode.setCredits(credits);
        updateDocumentFromEpisode();
    }

    public String getAired() {
        return episode.getAired();
    }

    public String getFileURL() {
        return episode.getFileURL();
    }

    public void setAired(String aired) {
        episode.setAired(aired);
        updateDocumentFromEpisode();
    }

    public void setFileURL(String fileURL) {
        episode.setFileURL(fileURL);
        updateDocumentFromEpisode();
    }

    public String getThumbnailURL() {
        return episode.getThumbnailURL();
    }

    public long getSize() {
        return episode.getSize();
    }

    public String getDirector() {
        return episode.getDirector();
    }

    public String getPlot() {
        return episode.getPlot();
    }

    public void setSize(long size) {
        episode.setSize(size);
        updateDocumentFromEpisode();
    }

    public void setPlot(String plot) {
        episode.setPlot(plot);
        updateDocumentFromEpisode();
    }

    public void setSeason(int season) {
        episode.setSeason(season);
        updateDocumentFromEpisode();
    }

    public void setId(int id) {
        episode.setId(id);
        updateDocumentFromEpisode();
    }

    public void setTitle(String title) {
        episode.setTitle(title);
        updateDocumentFromEpisode();
    }

    private void updateEpisodeFromDocument() {
        Document d = document;
        episode = new Episode();
        episode.setId(Integer.parseInt(d.getElementsByTagName("id").item(0).getTextContent()));
        episode.setTitle(d.getElementsByTagName("title").item(0).getTextContent());
        episode.setSize(Long.parseLong(d.getElementsByTagName("size").item(0).getTextContent()));
        episode.setFileURL(d.getElementsByTagName("fileURL").item(0).getTextContent());
        episode.setThumbnailURL(d.getElementsByTagName("thumbnailURL").item(0).getTextContent());

        episode.setSeason(Integer.parseInt(d.getElementsByTagName("season").item(0).getTextContent()));
        episode.setEpisode(Integer.parseInt(d.getElementsByTagName("episode").item(0).getTextContent()));
        episode.setPlot(d.getElementsByTagName("plot").item(0).getTextContent());
        episode.setDuration(d.getElementsByTagName("duration").item(0).getTextContent());
        episode.setAired(d.getElementsByTagName("aired").item(0).getTextContent());
        episode.setDirector(d.getElementsByTagName("director").item(0).getTextContent());
        episode.setCredits(d.getElementsByTagName("credits").item(0).getTextContent());
    }

    private void updateDocumentFromEpisode() {
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document d = document;
        Node rootElement = d.createElement("episode");

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

        Node seasonElement = d.createElement("season");
        seasonElement.appendChild(d.createTextNode("" + getSeason()));
        Node episodeElement = d.createElement("episode");
        episodeElement.appendChild(d.createTextNode("" + getEpisode()));
        Node durationElement = d.createElement("duration");
        durationElement.appendChild(d.createTextNode(getDuration()));
        Node airedElement = d.createElement("aired");
        airedElement.appendChild(d.createTextNode(getAired()));
        Node plotElement = d.createElement("plot");
        plotElement.appendChild(d.createTextNode(getPlot()));
        Node directorElement = d.createElement("director");
        directorElement.appendChild(d.createTextNode(getDirector()));
        Node creditsElement = d.createElement("credits");
        creditsElement.appendChild(d.createTextNode(getCredits()));
    }

}
