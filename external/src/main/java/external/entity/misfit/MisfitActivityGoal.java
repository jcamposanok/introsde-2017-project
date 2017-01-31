package external.entity.misfit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class MisfitActivityGoal {

    @XmlElement
    public String id;

    @XmlElement
    public String date;

    @XmlElement
    public Double points;

    @XmlElement
    public Integer timeZoneOffset;

    @XmlElement
    public Long targetPoints;

    // empty constructor needed for deserialization by JAXB
    public MisfitActivityGoal() {
    }
}
