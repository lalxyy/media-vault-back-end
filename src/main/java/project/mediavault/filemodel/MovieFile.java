package project.mediavault.filemodel;

import org.w3c.dom.Document;
import project.mediavault.model.Movie;

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
        movie.setTitle(title);
        updateDocumentFromMovie();
    }

    public

    private void updateDocumentFromMovie() {
        //
    }

    private void updateMovieFromDocument() {
        //
    }

}
