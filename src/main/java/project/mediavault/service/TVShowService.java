package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import project.mediavault.model.Episode;
import project.mediavault.model.TVShow;

import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD Bean for TV Show.
 *
 * @author Carl Li
 */
@Service
public class TVShowService {

    private static final String FILE_PATH = "";
    private Document document;

    @Autowired
    public TVShowService(DocumentBuilder documentBuilder) throws IOException, SAXException {
//        File file = new File(FILE_PATH);
//        document = documentBuilder.parse(file);
    }

    public List<TVShow> getAllList() {
        List<TVShow> tvShowList = new ArrayList<>();
        return tvShowList;
    }

    public boolean delete(int id) {
        return true;
    }

    public boolean modify(int id, TVShow entity) {
        return true;
    }

    public boolean add(TVShow entity) {
        return true;
    }

    public List<Episode> getEpisodes(int id) {
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
