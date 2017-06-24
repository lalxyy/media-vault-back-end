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
