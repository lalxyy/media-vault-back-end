package project.mediavault.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Movie model.
 *
 * @author Carl Li
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Movie extends Media {
    // Basic Media Information of Movie
    private String duration; // "Length of movie in minutes", but what if duration = mm:ss ? [Using String]

    // The information of the content of the Movie
    private List<String> genres;
    private String plot;

    // Basic file information of Movie
    private String thumbURL;

}
