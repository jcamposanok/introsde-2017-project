package integration.client.entity.misfit;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class MisfitActivityGoalList {

    @JsonProperty("goals")
    @XmlElement(name = "goal", type = MisfitActivityGoal.class)
    public List<MisfitActivityGoal> goals;

    // empty constructor needed for deserialization by JAXB
    public MisfitActivityGoalList() {
    }
}
