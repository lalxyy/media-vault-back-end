package project.mediavault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;

/**
 * Music Service.
 *
 * @author Carl Li
 */
@Service
public class MusicService {

    private static final String FILE_PATH = "";
    private Document document;

    @Autowired
    public MusicService(DocumentBuilder documentBuilder) throws IOException, SAXException {
        File file = new File(FILE_PATH);
        document = documentBuilder.parse(file);
    }

}
