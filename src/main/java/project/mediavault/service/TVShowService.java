package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import project.mediavault.MediaVaultApplication;
import project.mediavault.filemodel.EpisodeFile;
import project.mediavault.filemodel.TVShowFile;
import project.mediavault.model.Episode;
import project.mediavault.model.TVShow;

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
import java.util.*;
import java.util.stream.Stream;

/**
 * CRUD Bean for TV Show.
 *
 * @author Carl Li
 */
@SuppressWarnings("Duplicates")
@Service
public class TVShowService {

    private static final String DIR_FILES = MediaVaultApplication.BASE_DIR + "/file/tvshow";

    private DocumentBuilder documentBuilder;
    private Transformer transformer;
    private Set<TVShowFile> tvShowFiles = new HashSet<>();
    private Set<EpisodeFile> episodeFiles = new HashSet<>();

    @Autowired
    public TVShowService(DocumentBuilder documentBuilder, TransformerFactory transformerFactory) throws IOException, SAXException, TransformerConfigurationException {
        this.documentBuilder = documentBuilder;
        this.transformer = transformerFactory.newTransformer();

        // https://stackoverflow.com/questions/1844688/read-all-files-in-a-folder
        try (Stream<Path> pathStream = Files.walk(Paths.get(DIR_FILES))) {
            pathStream
                    .filter(path -> path.getFileName().toString().endsWith(".nfo"))
                    .forEach(path -> {
                        try {
                            tvShowFiles.add(new TVShowFile(documentBuilder.parse(path.toFile())));
                        } catch (SAXException | IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public List<TVShow> getAllList() {
        List<TVShow> tvShowList = new ArrayList<>();
        tvShowFiles.forEach(
                tvShowFile -> tvShowList.add(tvShowFile.getTVShow())
        );
        return tvShowList;
    }

    public boolean delete(int id) {
        TVShowFile tvShowFile = null;
        for (TVShowFile file: tvShowFiles) {
            if (file.getId() == id) {
                tvShowFile = file;
            }
        }
        if (tvShowFile == null) {
            return false;
        }

        try {
            tvShowFiles.remove(tvShowFile);
            Files.delete(Paths.get(DIR_FILES + tvShowFile.getId() + "/" + ".nfo"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modify(TVShow tvShow) {
        TVShowFile tvShowFile = new TVShowFile(tvShow);
        try {
            Document document = tvShowFile.getDocument();
            DOMSource domSource = new DOMSource(document);
            File file = new File(DIR_FILES + "/" + tvShowFile.getId() + ".nfo");
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean add(TVShow tvShow) {
        int id = 0;
        Optional<Integer> nextId = tvShowFiles.stream()
                .map(TVShowFile::getId)
                .max(Comparator.comparingInt(value -> value));
        if (nextId.isPresent()) {
            id = nextId.get() + 1;
        }

        tvShow.setId(id);
        TVShowFile tvShowFile = new TVShowFile(tvShow);
        try {
            Document document = tvShowFile.getDocument();
            DOMSource domSource = new DOMSource(document);
            File file = new File(DIR_FILES + "/" + tvShowFile.getId() + ".nfo");
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

            tvShowFiles.add(tvShowFile);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Episode> getEpisodes(int id) {
        TVShowFile tvShowFile = null;
        for (TVShowFile file: tvShowFiles) {
            if (file.getId() == id) {
                tvShowFile = file;
            }
        }
        if (tvShowFile == null) {
            return false;
        }

        List<Episode> episodeList = new ArrayList<>();
        return episodeList;
    }

    public boolean deleteEpisode(int id, int season, int episode) {
        return true;
    }

    public boolean addEpisode(int id, Episode entity) {
        return true;
    }

}
