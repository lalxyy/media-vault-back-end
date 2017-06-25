package project.mediavault.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Music model.
 *
 * @author Carl Li
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Music extends Media {
    // Basic Media Information of Music
    private String duration; // "Length of movie in minutes", but what if duration = mm:ss ? [Using String]

}
