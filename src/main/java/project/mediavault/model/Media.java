package project.mediavault.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.w3c.dom.Document;


@Data
public abstract class Media {

    private int id;
    private String title;
    private String type;
    private String year;
    private String thumbnailURL;
    private String fileURL;

    // Measurement Unit = Byte
    private Long size; // For TV Shows, the value of (total) size can be null

    @JsonIgnore
    private Document metaFile;
}
