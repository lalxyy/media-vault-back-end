package project.mediavault.model;

import lombok.Data;


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
