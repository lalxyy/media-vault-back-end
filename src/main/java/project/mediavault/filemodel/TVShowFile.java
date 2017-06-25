package project.mediavault.filemodel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import project.mediavault.model.TVShow.Actor;
import project.mediavault.model.TVShow;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.util.List;

public class TVShowFile {

    private TVShow tvShow;
    private Document document;

    private static XPath xPath = XPathFactory.newInstance().newXPath();

    public TVShowFile(TVShow tvShow) {
        this.tvShow = tvShow;
        updateDocumentFromTVShow();
    }

    public TVShowFile(Document document) {
        this.document = document;
        updateTVShowFromDocument();
    }

    public TVShow getTVShow() {
        return tvShow;
    }

    public void setTVShow(TVShow tvShow) {
        this.tvShow = tvShow;
        updateDocumentFromTVShow();
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
        updateTVShowFromDocument();
    }

    public int getRuntime() {
        return tvShow.getRuntime();
    }

    public List<String> getGenres() {
        return tvShow.getGenres();
    }

    public String getPremiered() {
        return tvShow.getPremiered();
    }

    public void setEpisodeIds(List<Integer> episodeIds) {
        tvShow.setEpisodeIds(episodeIds);
        updateDocumentFromTVShow();
    }

    public String getThumbnailURL() {
        return tvShow.getThumbnailURL();
    }

    public void setFileURL(String fileURL) {
        tvShow.setFileURL(fileURL);
        updateDocumentFromTVShow();
    }

    public String getStudio() {
        return tvShow.getStudio();
    }

    public void setId(int id) {
        tvShow.setId(id);
        updateDocumentFromTVShow();
    }

    public String getMpaa() {
        return tvShow.getMpaa();
    }

    public String getPlot() {
        return tvShow.getPlot();
    }

    public String getFileURL() {
        return tvShow.getFileURL();
    }

    public void setActors(List<Actor> actors) {
        tvShow.setActors(actors);
        updateDocumentFromTVShow();
    }

    public double getRating() {
        return tvShow.getRating();
    }

    public List<Integer> getEpisodeIds() {
        return tvShow.getEpisodeIds();
    }

    public List<Actor> getActors() {
        return tvShow.getActors();
    }

    public void setMpaa(String mpaa) {
        tvShow.setMpaa(mpaa);
        updateDocumentFromTVShow();
    }

    public void setTitle(String title) {
        tvShow.setTitle(title);
        updateDocumentFromTVShow();
    }

    public void setPlot(String plot) {
        tvShow.setPlot(plot);
        updateDocumentFromTVShow();
    }

    public String getTitle() {
        return tvShow.getTitle();
    }

    public void setRuntime(int runtime) {
        tvShow.setRuntime(runtime);
        updateDocumentFromTVShow();
    }

    public void setPremiered(String premiered) {
        tvShow.setPremiered(premiered);
        updateDocumentFromTVShow();
    }

    public void setThumbnailURL(String thumbnailURL) {
        updateDocumentFromTVShow();
        tvShow.setThumbnailURL(thumbnailURL);
    }

    public void setSize(Long size) {
        tvShow.setSize(size);
        updateDocumentFromTVShow();
    }

    public void setStudio(String studio) {
        tvShow.setStudio(studio);
        updateDocumentFromTVShow();
    }

    public void setRating(double rating) {
        tvShow.setRating(rating);
        updateDocumentFromTVShow();
    }

    public void setGenres(List<String> genres) {
        tvShow.setGenres(genres);
        updateDocumentFromTVShow();
    }

    public int getId() {
        return tvShow.getId();
    }

    public Long getSize() {
        return tvShow.getSize();
    }

    private void updateTVShowFromDocument() {
        Document d = document;
        tvShow = new TVShow();

        tvShow.setId(Integer.parseInt(d.getElementsByTagName("id").item(0).getTextContent()));
        tvShow.setTitle(d.getElementsByTagName("title").item(0).getTextContent());
        tvShow.setSize(Long.parseLong(d.getElementsByTagName("size").item(0).getTextContent()));
        tvShow.setFileURL(d.getElementsByTagName("fileURL").item(0).getTextContent());
        tvShow.setThumbnailURL(d.getElementsByTagName("thumbnailURL").item(0).getTextContent());
        tvShow.setRating(Double.parseDouble(d.getElementsByTagName("rating").item(0).getTextContent()));

        NodeList genreNodeList = d.getElementsByTagName("genre");
        for (int i = 0; i < genreNodeList.getLength(); ++i) {
            tvShow.getGenres().add(genreNodeList.item(i).getTextContent());
        }
        tvShow.setPlot(d.getElementsByTagName("plot").item(0).getTextContent());
        tvShow.setRuntime(Integer.parseInt(d.getElementsByTagName("runtime").item(0).getTextContent()));
        tvShow.setPremiered(d.getElementsByTagName("premiered").item(0).getTextContent());
        tvShow.setStudio(d.getElementsByTagName("studio").item(0).getTextContent());
        tvShow.setMpaa(d.getElementsByTagName("mpaa").item(0).getTextContent());
        NodeList episodeIdNodeList = d.getElementsByTagName("episodeId");
        for (int i = 0; i < episodeIdNodeList.getLength(); ++i) {
            tvShow.getEpisodeIds().add(Integer.parseInt(episodeIdNodeList.item(i).getTextContent()));
        }

        try {
            NodeList actorNameNodes = (NodeList) xPath.compile("/tv-show/actor/name").evaluate(document, XPathConstants.NODESET);
            NodeList actorRoleNodes = (NodeList) xPath.compile("/tv-show/actor/name").evaluate(document, XPathConstants.NODESET);
            NodeList actorThumbURLNodes = (NodeList) xPath.compile("/tv-show/actor/thumbURL").evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i < actorNameNodes.getLength(); ++i) {
                Actor actor = new Actor();
                actor.setName(actorNameNodes.item(i).getTextContent());
                actor.setRole(actorRoleNodes.item(i).getTextContent());
                actor.setThumbURL(actorThumbURLNodes.item(i).getTextContent());
                tvShow.getActors().add(actor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateDocumentFromTVShow() {
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document d = document;
        Element rootElement = d.createElement("tv-show");

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

        Node plotElement = d.createElement("plot");
        plotElement.appendChild(d.createTextNode(getPlot()));
        Node runtimeElement = d.createElement("runtime");
        runtimeElement.appendChild(d.createTextNode("" + getRuntime()));
        Node premieredElement = d.createElement("premiered");
        premieredElement.appendChild(d.createTextNode(getPremiered()));
        Node studioElement = d.createElement("studio");
        studioElement.appendChild(d.createTextNode(getStudio()));
        Node mpaaElement = d.createElement("mpaa");
        mpaaElement.appendChild(d.createTextNode(getMpaa()));

        rootElement.appendChild(idElement);
        rootElement.appendChild(titleElement);
        rootElement.appendChild(thumbnailURLElement);
        rootElement.appendChild(fileURLElement);
        rootElement.appendChild(sizeElement);
        rootElement.appendChild(ratingElement);
        rootElement.appendChild(plotElement);
        rootElement.appendChild(runtimeElement);
        rootElement.appendChild(premieredElement);
        rootElement.appendChild(studioElement);
        rootElement.appendChild(mpaaElement);

        getGenres().forEach(genre -> {
            Element element = d.createElement("genre");
            element.appendChild(d.createTextNode(genre));
            rootElement.appendChild(element);
        });
        getEpisodeIds().forEach(id -> {
            Element element = d.createElement("episodeId");
            element.appendChild(d.createTextNode("" + id));
            rootElement.appendChild(element);
        });

        getActors().forEach(actor -> {
            Element element = d.createElement("actor");
            Element nameElement = d.createElement("name");
            nameElement.appendChild(d.createTextNode(actor.getName()));
            Element roleElement = d.createElement("role");
            roleElement.appendChild(d.createTextNode(actor.getRole()));
            Element thumbURLElement = d.createElement("thumbURL");
            thumbURLElement.appendChild(d.createTextNode(actor.getThumbURL()));

            element.appendChild(nameElement);
            element.appendChild(roleElement);
            element.appendChild(thumbURLElement);
            rootElement.appendChild(element);
        });

        document.appendChild(rootElement);
    }

}
