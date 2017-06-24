package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import project.mediavault.MediaVaultApplication;
import project.mediavault.filemodel.MovieFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class FileService<T> {

    private static final String DIR_FILES = MediaVaultApplication.BASE_DIR + "/file";

    private DocumentBuilder documentBuilder;
    private Transformer transformer;
    private Set<MovieFile> movieFiles;
    private Path directoryPath;

    private static String getTypePrefix() {
        return "";
    }

    @Autowired
    public FileService(DocumentBuilder documentBuilder, TransformerFactory transformerFactory) throws IOException, SAXException, TransformerConfigurationException {
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

}
