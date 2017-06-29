package project.mediavault.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Music model.
 *
 * @author Carl Li
 */
@Entity
@DiscriminatorValue("music")
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Music extends Media {
    // Basic Media Information of Music
    private int duration; // second

}
