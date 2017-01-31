package integration.client.entity.misfit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class MisfitDevice {

    @XmlElement
    public String id;

    @XmlElement
    public String deviceType;

    @XmlElement
    public String serialNumber;

    @XmlElement
    public String firmwareVersion;

    @XmlElement
    public Integer batteryLevel;

    @XmlElement
    public Long lastSyncTime;

    // empty constructor needed for deserialization by JAXB
    public MisfitDevice() {
    }
}
