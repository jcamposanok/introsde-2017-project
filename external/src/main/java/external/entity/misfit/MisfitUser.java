package external.entity.misfit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class MisfitUser {

    @XmlElement
    public String userId;

    @XmlElement
    public Double weight;

    @XmlElement
    public Double height;

    @XmlElement
    public String weightUnit;

    @XmlElement
    public String heightUnit;

    @XmlElement
    public String name;

    @XmlElement
    public String birthday;

    @XmlElement
    public String gender;

    @XmlElement
    public String avatar;

    @XmlElement
    public String email;

    // empty constructor needed for deserialization by JAXB
    public MisfitUser() {
    }
}
