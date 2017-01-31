
package presentation.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getUserCaloriesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getUserCaloriesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="calories" type="{http://soap.server.integration/}userCaloriesResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUserCaloriesResponse", propOrder = {
    "calories"
})
public class GetUserCaloriesResponse {

    protected UserCaloriesResponse calories;

    /**
     * Gets the value of the calories property.
     * 
     * @return
     *     possible object is
     *     {@link UserCaloriesResponse }
     *     
     */
    public UserCaloriesResponse getCalories() {
        return calories;
    }

    /**
     * Sets the value of the calories property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserCaloriesResponse }
     *     
     */
    public void setCalories(UserCaloriesResponse value) {
        this.calories = value;
    }

}
