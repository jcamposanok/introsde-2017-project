
package presentation.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userCaloriesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userCaloriesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="caloriesBalance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="caloriesConsumed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="caloriesGained" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="month" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userCaloriesResponse", propOrder = {
    "caloriesBalance",
    "caloriesConsumed",
    "caloriesGained",
    "month",
    "year"
})
public class UserCaloriesResponse {

    public int caloriesBalance;
    public int caloriesConsumed;
    public int caloriesGained;
    public String month;
    public int year;

    /**
     * Gets the value of the caloriesBalance property.
     * 
     */
    public int getCaloriesBalance() {
        return caloriesBalance;
    }

    /**
     * Sets the value of the caloriesBalance property.
     * 
     */
    public void setCaloriesBalance(int value) {
        this.caloriesBalance = value;
    }

    /**
     * Gets the value of the caloriesConsumed property.
     * 
     */
    public int getCaloriesConsumed() {
        return caloriesConsumed;
    }

    /**
     * Sets the value of the caloriesConsumed property.
     * 
     */
    public void setCaloriesConsumed(int value) {
        this.caloriesConsumed = value;
    }

    /**
     * Gets the value of the caloriesGained property.
     * 
     */
    public int getCaloriesGained() {
        return caloriesGained;
    }

    /**
     * Sets the value of the caloriesGained property.
     * 
     */
    public void setCaloriesGained(int value) {
        this.caloriesGained = value;
    }

    /**
     * Gets the value of the month property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonth(String value) {
        this.month = value;
    }

    /**
     * Gets the value of the year property.
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

}
