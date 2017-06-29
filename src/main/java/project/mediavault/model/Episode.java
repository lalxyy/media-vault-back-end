package project.mediavault.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Episodes of a TV Show
 */
@Entity
@Data
public class Episode {
    // Basic (media) information
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int season;
    private int episode;
    private int duration;
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
