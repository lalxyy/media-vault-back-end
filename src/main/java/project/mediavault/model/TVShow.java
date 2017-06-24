package project.mediavault.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Actor of a TV Show
 */
class Actor {
    private String name;
    private String role;
    private String thumbURL;
}

@EqualsAndHashCode(callSuper = true)
@Data
public class TVShow extends Media {
    // Basic Information of TV Show
    private int runtime;
    private String premiered;
    private String studio;
    private String mpaa;

    // The information of the content of the TV Show
    private List<String> genres;
    private String plot;

    // The episodes of a TV Show
    private List<Episode> episodes;

    // The actors of a TV Show
    private List<Actor> actors;
}
