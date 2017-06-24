package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import project.mediavault.filemodel.MovieFile;

import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * Movie Service.
 *
 * @author Carl Li
 */
@Service
public class MovieService {

    private static final String FILE_PATH = "";
    private Set<MovieFile> movieFiles;

    @Autowired
    public MovieService(DocumentBuilder documentBuilder) throws IOException, SAXException {
        File file = new File(FILE_PATH);
        document = documentBuilder.parse(file);
    }

}
