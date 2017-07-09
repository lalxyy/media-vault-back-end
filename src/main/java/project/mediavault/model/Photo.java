package project.mediavault.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Photo model.
 */
@Entity
@DiscriminatorValue("photo")
@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo extends Media {
    // No extra field temporarily
}
