package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import project.mediavault.MediaVaultApplication;
import project.mediavault.filemodel.MusicFile;
import project.mediavault.model.Music;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
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
 * Music Service.
 *
 * @author Carl Li
 */
@SuppressWarnings("Duplicates")
@Service
public class MusicService {

    private static final String DIR_FILES = MediaVaultApplication.BASE_DIR + "/file/music";

    private DocumentBuilder documentBuilder;
    private Transformer transformer;
    private Set<MusicFile> musicFiles;

    @Autowired
    public MusicService(DocumentBuilder documentBuilder, TransformerFactory transformerFactory) throws IOException, SAXException, TransformerConfigurationException {
        this.documentBuilder = documentBuilder;
        this.transformer = transformerFactory.newTransformer();

        try (Stream<Path> pathStream = Files.walk(Paths.get(DIR_FILES))) {
            pathStream
                    .filter(path -> path.getFileName().endsWith(".nfo"))
                    .forEach(path -> {
                        try {
                            musicFiles.add(new MusicFile(documentBuilder.parse(path.toFile())));
                        } catch (SAXException | IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public List<Music> getAllList() {
        List<Music> movieList = new ArrayList<>();
        musicFiles.forEach(movieFile -> movieList.add(movieFile.getMusic()));
        return movieList;
    }

    public boolean saveNewMusic(MusicFile musicFile) {
        try {
            Document document = musicFile.getDocument();
            DOMSource domSource = new DOMSource(document);
            File file = new File(DIR_FILES + musicFile.getId() + ".nfo");
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

            musicFiles.add(musicFile);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyExistedMusic(MusicFile musicFile) {
        try {
            Document document = musicFile.getDocument();
            DOMSource domSource = new DOMSource(document);
            File file = new File(DIR_FILES + musicFile.getId() + ".nfo");
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMusic(int id) {
        MusicFile musicFile = null;
        for (MusicFile file: musicFiles) {
            if (file.getId() == id) {
                musicFile = file;
            }
        }
        if (musicFile == null) {
            return false;
        }

        try {
            Files.delete(Paths.get(DIR_FILES + musicFile.getId() + ".nfo"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Music getMusicById(int id) {
        for (MusicFile musicFile: musicFiles) {
            if (musicFile.getId() == id) {
                return musicFile.getMusic();
            }
        }

        return null;
    }

}
