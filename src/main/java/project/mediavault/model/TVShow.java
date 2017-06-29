package project.mediavault.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Actor of a TV Show
 */
@Entity
@DiscriminatorValue("tv-show")
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TVShow extends Media {
    // Basic Information of TV Show
    private int runtime;
    private String premiered;
    private String studio;
    private String mpaa;

    // The information of the content of the TV Show
    @ElementCollection
    private List<String> genres = new ArrayList<>();

    private String plot;

    // The episodes of a TV Show
    @OneToMany(targetEntity = Episode.class, fetch = FetchType.EAGER)
    @JoinTable(name = "tvshow_episode",
            joinColumns = @JoinColumn(name = "tvshow_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "episode_id", referencedColumnName = "id")
    )
    private List<Episode> episodes = new ArrayList<>();

    // The actors of a TV Show
    @OneToMany(targetEntity = Actor.class, fetch = FetchType.EAGER)
    @JoinTable(name = "tvshow_actor",
            joinColumns = @JoinColumn(name = "tvshow_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id")
    )
    private List<Actor> actors = new ArrayList<>();

    @Entity
    @Data
    public static class Actor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;
        private String role;
        private String thumbURL;

    }
}
