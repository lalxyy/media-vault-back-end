package project.mediavault.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.w3c.dom.Document;

import java.util.List;


@Data
public abstract class Media {
    // Basic Media Information
    private int id;
    private String title;
    private double rating;

//    // Information of the Media
//    private List<String> genre;
//
//    // Information of the
//    private String year;

    // Information of storing
    private String thumbnailURL;
    private String fileURL;

    // Measurement Unit = Byte
    private Long size; // For TV Shows, the value of (total) size can be null

}
