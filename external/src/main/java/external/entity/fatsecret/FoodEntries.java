
package external.entity.fatsecret;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="food_entry" type="{http://platform.fatsecret.com/api/1.0/}food_entry" maxOccurs="unbounded" minOccurs="0"/>
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
    "foodEntry"
})
@XmlRootElement(name = "food_entries", namespace = "http://platform.fatsecret.com/api/1.0/")
public class FoodEntries {

    @XmlElement(name = "food_entry", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected List<FoodEntry> foodEntry;

    /**
     * Gets the value of the foodEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the foodEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFoodEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FoodEntry }
     * 
     * 
     */
    public List<FoodEntry> getFoodEntry() {
        if (foodEntry == null) {
            foodEntry = new ArrayList<FoodEntry>();
        }
        return this.foodEntry;
    }

}
