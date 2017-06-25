package project.mediavault.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Actor of a TV Show
 */


@EqualsAndHashCode(callSuper = true)
@Data
public class TVShow extends Media {
    // Basic Information of TV Show
    private int runtime;
    private String premiered;
    private String studio;
    private String mpaa;

    // The information of the content of the TV Show
    private List<String> genres = new ArrayList<>();
    private String plot;

    // The episodes of a TV Show
    private List<Integer> episodeIds = new ArrayList<>();

    // The actors of a TV Show
    private List<Actor> actors = new ArrayList<>();

    public static class Actor {
        private String name;
        private String role;
        private String thumbURL;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getThumbURL() {
            return thumbURL;
        }

        public void setThumbURL(String thumbURL) {
            this.thumbURL = thumbURL;
        }
    }
}
