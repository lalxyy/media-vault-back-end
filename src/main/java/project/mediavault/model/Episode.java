package project.mediavault.model;

import lombok.Data;

/**
 * Episodes of a TV Show
 */
@Data
public class Episode {
    // Basic (media) information
    private int id;
    private String title;
    private int season;
    private int episode;
    private String duration;
    private String aired;

    // Basic file information
    private String fileURL;
    private String thumbnailURL;

    // Measurement Unit = Byte
    private long size; // The size of each episode cannot be null

    // Information of the content of the episode
    private String director;
    private String plot;
    private String credits;

}
