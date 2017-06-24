package project.mediavault.model;

import lombok.Data;

@Data
public class Episode {

    private int id;
    private int season;
    private int episode;
    private String fileURL;

    // Measurement Unit = Byte
    private Long size; // The size of each episode cannot be null
}
