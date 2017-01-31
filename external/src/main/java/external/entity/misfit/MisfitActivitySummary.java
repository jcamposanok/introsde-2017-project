package external.entity.misfit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class MisfitActivitySummary {

    @XmlElement
    public Double points;

    @XmlElement
    public Long steps;

    @XmlElement
    public Double calories;

    @XmlElement
    public Double activityCalories;

    @XmlElement
    public Double distance;

    // empty constructor needed for deserialization by JAXB
    public MisfitActivitySummary() {
    }
}
