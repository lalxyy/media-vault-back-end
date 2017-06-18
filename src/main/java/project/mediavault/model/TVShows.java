package project.mediavault.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class TVShows extends Media {

    private List<Episode> episodes;
    private 
}
