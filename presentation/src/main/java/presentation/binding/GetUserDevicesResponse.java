
package presentation.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getUserDevicesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getUserDevicesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="devices" type="{http://soap.server.integration/}userDevicesResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUserDevicesResponse", propOrder = {
    "devices"
})
public class GetUserDevicesResponse {

    protected UserDevicesResponse devices;

    /**
     * Gets the value of the devices property.
     * 
     * @return
     *     possible object is
     *     {@link UserDevicesResponse }
     *     
     */
    public UserDevicesResponse getDevices() {
        return devices;
    }

    /**
     * Sets the value of the devices property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserDevicesResponse }
     *     
     */
    public void setDevices(UserDevicesResponse value) {
        this.devices = value;
    }

}
