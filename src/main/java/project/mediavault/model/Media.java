package project.mediavault.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Data
public abstract class Media {
    // Basic Media Information

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
