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
    private static final String DIR_EPISODES = MediaVaultApplication.BASE_DIR + "/file/episode";

    private DocumentBuilder documentBuilder;
    private Transformer transformer;
    private Set<TVShowFile> tvShowFiles = new HashSet<>();
    private Set<EpisodeFile> episodeFiles = new HashSet<>();

    @Autowired
    public TVShowService(DocumentBuilder documentBuilder, TransformerFactory transformerFactory) throws IOException, SAXException, TransformerConfigurationException {
        this.documentBuilder = documentBuilder;
        this.transformer = transformerFactory.newTransformer();

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

        try (Stream<Path> pathStream = Files.walk(Paths.get(DIR_EPISODES))) {
            pathStream
                    .filter(path -> path.getFileName().toString().endsWith(".nfo"))
                    .forEach(path -> {
                        try {
                            episodeFiles.add(new EpisodeFile(documentBuilder.parse(path.toFile())));
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
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        try {
            for (EpisodeFile episodeFile: episodeFiles) {
                if (tvShowFile.getEpisodeIds().contains(episodeFile.getId())) {
                    return deleteEpisode(tvShowFile.getId(), episodeFile.getSeason(), episodeFile.getEpisode());
                }
            }
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
            return new ArrayList<>();
        }

        List<Integer> episodeItemIds = tvShowFile.getEpisodeIds();
        List<Episode> episodeList = new ArrayList<>();
        for (EpisodeFile episodeFile: episodeFiles) {
            if (episodeItemIds.contains(episodeFile.getId())) {
                episodeList.add(episodeFile.getEpisodeItem());
            }
        }
        return episodeList;
    }

    public boolean deleteEpisode(int id, int season, int episode) {
        TVShowFile tvShowFile = null;
        for (TVShowFile file: tvShowFiles) {
            if (file.getId() == id) {
                tvShowFile = file;
            }
        }
        if (tvShowFile == null) {
            return false;
        }

        for (EpisodeFile episodeFile: episodeFiles) {
            if (tvShowFile.getEpisodeIds().contains(episodeFile.getId()) && episodeFile.getSeason() == season && episodeFile.getEpisode() == episode) {
                try {
                    episodeFiles.remove(episodeFile);
                    Files.delete(Paths.get(DIR_EPISODES + episodeFile.getId() + "/" + ".nfo"));
                    tvShowFile.getEpisodeIds().remove(episodeFile.getId());
                    return modify(tvShowFile.getTVShow());
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    public boolean addEpisode(int tvShowId, Episode episode) {
        int id = 0;
        Optional<Integer> nextId = episodeFiles.stream()
                .map(EpisodeFile::getId)
                .max(Comparator.comparingInt(value -> value));
        if (nextId.isPresent()) {
            id = nextId.get() + 1;
        }

        episode.setId(id);
        EpisodeFile episodeFile = new EpisodeFile(episode);
        try {
            Document document = episodeFile.getDocument();
            DOMSource domSource = new DOMSource(document);
            File file = new File(DIR_FILES + "/" + episode.getId() + ".nfo");
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

            episodeFiles.add(episodeFile);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        TVShowFile tvShowFile = null;
        for (TVShowFile file: tvShowFiles) {
            if (file.getId() == tvShowId) {
                tvShowFile = file;
            }
        }
        if (tvShowFile == null) {
            return false;
        }
        tvShowFile.getEpisodeIds().add(episode.getId());
        return modify(tvShowFile.getTVShow());
    }

}
