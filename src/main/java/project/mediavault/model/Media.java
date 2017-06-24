package project.mediavault.model;

import lombok.Data;


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

}
