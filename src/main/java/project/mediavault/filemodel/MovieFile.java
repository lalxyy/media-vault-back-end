package project.mediavault.filemodel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import project.mediavault.model.Movie;

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

    public Movie getMovie() {
        return this.movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
        updateDocumentFromMovie();
    }

    public Document getDocument() {
        return this.document;
    }

    public void setDocument(Document document) {
        this.document = document;
        updateMovieFromDocument();
    }

    public int getId() {
        return movie.getId();
    }

    public void setId(int id) {
        movie.setId(id);
        updateDocumentFromMovie();
    }

    public String getTitle(String title) {
        return movie.getTitle();
    }

    public void setTitle(String title) {
        movie.setTitle(title);
        updateDocumentFromMovie();
    }

    public String getYear() {
        return movie.getYear();
    }

    public void setYear(String year) {
        movie.setYear(year);
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

    public long getSize() {
        return movie.getSize();
    }

    public void setSize(long size) {
        movie.setSize(size);
        updateDocumentFromMovie();
    }

    // ====

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

    public int getRating() {
        return movie.getRating();
    }

    public void setRating(int rating) {
        movie.setRating(rating);
        updateDocumentFromMovie();
    }

    private void updateDocumentFromMovie() {
        Element rootElement = document.createElement("movie");
        document.appendChild(rootElement);

        Element
    }

    private void updateMovieFromDocument() {
        //
    }

}
