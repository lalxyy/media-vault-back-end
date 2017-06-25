package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import project.mediavault.MediaVaultApplication;
import project.mediavault.filemodel.MovieFile;
import project.mediavault.filemodel.PhotoFile;
import project.mediavault.model.Movie;
import project.mediavault.model.Photo;

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

@SuppressWarnings("Duplicates")
@Service
public class PhotoService {

    private static final String DIR_FILES = MediaVaultApplication.BASE_DIR + "/file/photo";

    private DocumentBuilder documentBuilder;
    private Transformer transformer;
    private Set<PhotoFile> photoFiles = new HashSet<>();

    @Autowired
    public PhotoService(DocumentBuilder documentBuilder, TransformerFactory transformerFactory) throws IOException, SAXException, TransformerConfigurationException {
        this.documentBuilder = documentBuilder;
        this.transformer = transformerFactory.newTransformer();

        try (Stream<Path> pathStream = Files.walk(Paths.get(DIR_FILES))) {
            pathStream
                    .filter(path -> path.getFileName().toString().endsWith(".nfo"))
                    .forEach(path -> {
                        try {
                            photoFiles.add(new PhotoFile(documentBuilder.parse(path.toFile())));
                        } catch (SAXException | IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    public List<Photo> getAllList() {
        List<Photo> photoList = new ArrayList<>();
        photoFiles.forEach(movieFile -> photoList.add(movieFile.getPhoto()));
        return photoList;
    }

    public boolean saveNewPhoto(Photo photo) {
        int id = 0;
        Optional<Integer> nextId = photoFiles.stream()
                .map(PhotoFile::getId)
                .max(Comparator.comparingInt(value -> value));
        if (nextId.isPresent()) {
            id = nextId.get() + 1;
        }

        photo.setId(id);
        PhotoFile photoFile = new PhotoFile(photo);
        try {
            Document document = photoFile.getDocument();
            DOMSource domSource = new DOMSource(document);
            File file = new File(DIR_FILES + "/" + photoFile.getId() + ".nfo");
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

            photoFiles.add(photoFile);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyExistedPhoto(Photo photo) {
        PhotoFile photoFile = new PhotoFile(photo);
        try {
            Document document = photoFile.getDocument();
            DOMSource domSource = new DOMSource(document);
            File file = new File(DIR_FILES + "/" + photoFile.getId() + ".nfo");
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePhoto(int photoId) {
        PhotoFile photoFile = null;
        for (PhotoFile file: photoFiles) {
            if (file.getId() == photoId) {
                photoFile = file;
            }
        }
        if (photoFile == null) {
            return false;
        }

        try {
            photoFiles.remove(photoFile);
            Files.delete(Paths.get(DIR_FILES + "/" + photoFile.getId() + ".nfo"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Photo getPhotoById(int id) {
        for (PhotoFile photoFile: photoFiles) {
            if (photoFile.getId() == id) {
                return photoFile.getPhoto();
            }
        }

        return null;
    }

}
