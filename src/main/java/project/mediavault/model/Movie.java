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
    private String duration;
    private String plot;
    private List<String> genres;
    private int rating;
}
