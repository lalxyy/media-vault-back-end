package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import project.mediavault.MediaVaultApplication;
import project.mediavault.filemodel.MovieFile;
import project.mediavault.model.Movie;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Movie Service.
 *
 * @author Carl Li
 */
@SuppressWarnings("Duplicates")
@Service
public class MovieService {

    private static final String DIR_FILES = MediaVaultApplication.BASE_DIR + "/file/movie";

    private DocumentBuilder documentBuilder;
    private Transformer transformer;
    private Set<MovieFile> movieFiles;

    @Autowired
    public MovieService(DocumentBuilder documentBuilder, TransformerFactory transformerFactory) throws IOException, SAXException, TransformerConfigurationException {
        this.documentBuilder = documentBuilder;
        this.transformer = transformerFactory.newTransformer();

        // https://stackoverflow.com/questions/1844688/read-all-files-in-a-folder
        try (Stream<Path> pathStream = Files.walk(Paths.get(DIR_FILES))) {
            pathStream
                    .filter(path -> path.getFileName().endsWith(".nfo"))
                    .forEach(path -> {
                        try {
                            movieFiles.add(new MovieFile(documentBuilder.parse(path.toFile())));
                        } catch (SAXException | IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public List<Movie> getAllList() {
        List<Movie> movieList = new ArrayList<>();
        movieFiles.forEach(movieFile -> movieList.add(movieFile.getMovie()));
        return movieList;
    }

    public boolean saveNewMovie(Movie movie) {
        MovieFile movieFile = new MovieFile(movie);
        try {
            Document document = movieFile.getDocument();
            DOMSource domSource = new DOMSource(document);
            File file = new File(DIR_FILES + movieFile.getId() + ".nfo");
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

            movieFiles.add(movieFile);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyExistedMovie(MovieFile movieFile) {
        try {
            Document document = movieFile.getDocument();
            DOMSource domSource = new DOMSource(document);
            File file = new File(DIR_FILES + movieFile.getId() + ".nfo");
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMovie(MovieFile movieFile) {
        try {
            Files.delete(Paths.get(DIR_FILES + movieFile.getId() + ".nfo"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Movie getMovieById(int id) {
        for (MovieFile movieFile: movieFiles) {
            if (movieFile.getId() == id) {
                return movieFile.getMovie();
            }
        }

        return null;
    }

}
