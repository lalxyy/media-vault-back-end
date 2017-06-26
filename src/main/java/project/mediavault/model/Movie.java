package project.mediavault.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Movie model.
 *
 * @author Carl Li
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie extends Media {
    // Basic Media Information of Movie
    private String duration; // "Length of movie in minutes", but what if duration = mm:ss ? [Using String]

    // The informationx of the content of the Movie
    private List<String> genres = new ArrayList<>();
    private String plot;

}
