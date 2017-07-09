package project.mediavault.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Movie model.
 */
@Entity
@DiscriminatorValue("movie")
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie extends Media {
    // Basic Media Information of Movie
    private int duration; // second

    // The information of the content of the Movie

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> genres = new ArrayList<>();

    private String plot;

}
