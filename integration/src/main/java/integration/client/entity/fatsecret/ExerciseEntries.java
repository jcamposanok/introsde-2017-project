
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
 *         &lt;element name="exercise_entry" type="{http://platform.fatsecret.com/api/1.0/}exercise_entry" maxOccurs="unbounded"/>
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
    "exerciseEntry"
})
@XmlRootElement(name = "exercise_entries", namespace = "http://platform.fatsecret.com/api/1.0/")
public class ExerciseEntries {

    @XmlElement(name = "exercise_entry", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected List<ExerciseEntry> exerciseEntry;

    /**
     * Gets the value of the exerciseEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exerciseEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExerciseEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExerciseEntry }
     * 
     * 
     */
    public List<ExerciseEntry> getExerciseEntry() {
        if (exerciseEntry == null) {
            exerciseEntry = new ArrayList<ExerciseEntry>();
        }
        return this.exerciseEntry;
    }

}
