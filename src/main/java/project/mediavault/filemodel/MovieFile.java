package project.mediavault.filemodel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import project.mediavault.model.Movie;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

public class MovieFile {

    private Movie movie;
    private Document document;

    public MovieFile(Movie movie) {
        this.movie = movie;
        updateDocumentFromMovie();
    }

    public MovieFile(Document document) {
        this.document = document;
        updateMovieFromDocument();
    }

    // TODO Media File
    public Movie getMovie() {
        return this.movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
        updateDocumentFromMovie();
    }

    // TODO Document
    public Document getDocument() {
        return this.document;
    }

    public void setDocument(Document document) {
        this.document = document;
        updateMovieFromDocument();
    }

    // TODO Basic Fields
    public int getId() {
        return movie.getId();
    }

    public void setId(int id) {
        movie.setId(id);
        updateDocumentFromMovie();
    }

    public String getTitle() {
        return movie.getTitle();
    }

    public void setTitle(String title) {
        movie.setTitle(title);
        updateDocumentFromMovie();
    }

    public double getRating() {
        return movie.getRating();
    }

    public void setRating(double rating) {
        movie.setRating(rating);
        updateDocumentFromMovie();
    }

    public String getThumbnailURL() {
        return movie.getThumbnailURL();
    }

    public void setThumbnailURL(String thumbnailURL) {
        movie.setThumbnailURL(thumbnailURL);
        updateDocumentFromMovie();
    }

    public String getFileURL() {
        return movie.getFileURL();
    }

    public void setFileURL(String fileURL) {
        movie.setFileURL(fileURL);
        updateDocumentFromMovie();
    }

    public Long getSize() {
        return movie.getSize();
    }

    public void setSize(Long size) {
        movie.setSize(size);
        updateDocumentFromMovie();
    }

//    public String getYear() {
//        return movie.getYear();
//    }
//
//    public void setYear(String year) {
//        movie.setYear(year);
//        updateDocumentFromMovie();
//    }

    // ====

    // TODO Extra Fields
    public String getDuration() {
        return movie.getDuration();
    }

    public void setDuration(String duration) {
        movie.setDuration(duration);
        updateDocumentFromMovie();
    }

    public String getPlot() {
        return movie.getPlot();
    }

    public void setPlot(String plot) {
        movie.setPlot(plot);
        updateDocumentFromMovie();
    }

    public List<String> getGenres() {
        return movie.getGenres();
    }

    public void setGenres(List<String> genres) {
        movie.setGenres(genres);
        updateDocumentFromMovie();
    }

    // TODO Update Document
    private void updateDocumentFromMovie() {
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document d = document;
        Node rootElement = d.createElement("movie");

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
        Node plotElement = d.createElement("plot");
        plotElement.appendChild(d.createTextNode(getPlot()));

        rootElement.appendChild(durationElement);
        rootElement.appendChild(plotElement);
        getGenres().forEach(genre -> {
            Element element = d.createElement("genre");
            element.appendChild(d.createTextNode(genre));
            rootElement.appendChild(element);
        });


        document.appendChild(rootElement);
    }

    private void updateMovieFromDocument() {
        Document d = document;
        movie = new Movie();
        movie.setId(Integer.parseInt(d.getElementsByTagName("id").item(0).getTextContent()));
        movie.setTitle(d.getElementsByTagName("title").item(0).getTextContent());
        movie.setSize(Long.parseLong(d.getElementsByTagName("size").item(0).getTextContent()));
        movie.setFileURL(d.getElementsByTagName("fileURL").item(0).getTextContent());
        movie.setThumbnailURL(d.getElementsByTagName("thumbnailURL").item(0).getTextContent());
        movie.setRating(Double.parseDouble(d.getElementsByTagName("rating").item(0).getTextContent()));

        NodeList genreNodeList = d.getElementsByTagName("genre");
        for (int i = 0; i < genreNodeList.getLength(); ++i) {
            movie.getGenres().add(genreNodeList.item(i).getTextContent());
        }
        movie.setPlot(d.getElementsByTagName("plot").item(0).getTextContent());
        movie.setDuration(d.getElementsByTagName("duration").item(0).getTextContent());
    }

}
