
package integration.client.entity.fatsecret;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="from_date_int" type="{http://platform.fatsecret.com/api/1.0/}from_date_int"/>
 *         &lt;element name="to_date_int" type="{http://platform.fatsecret.com/api/1.0/}to_date_int"/>
 *         &lt;element name="day" type="{http://platform.fatsecret.com/api/1.0/}day" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fromDateInt",
    "toDateInt",
    "day"
})
@XmlRootElement(name = "month", namespace = "http://platform.fatsecret.com/api/1.0/")
public class Month {

    @XmlElement(name = "from_date_int", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected int fromDateInt;
    @XmlElement(name = "to_date_int", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected int toDateInt;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected List<Day> day;

    /**
     * Gets the value of the fromDateInt property.
     * 
     */
    public int getFromDateInt() {
        return fromDateInt;
    }

    /**
     * Sets the value of the fromDateInt property.
     * 
     */
    public void setFromDateInt(int value) {
        this.fromDateInt = value;
    }

    /**
     * Gets the value of the toDateInt property.
     * 
     */
    public int getToDateInt() {
        return toDateInt;
    }

    /**
     * Sets the value of the toDateInt property.
     * 
     */
    public void setToDateInt(int value) {
        this.toDateInt = value;
    }

    /**
     * Gets the value of the day property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the day property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDay().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Day }
     * 
     * 
     */
    public List<Day> getDay() {
        if (day == null) {
            day = new ArrayList<Day>();
        }
        return this.day;
    }

}
