
package integration.client.entity.fatsecret;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for exercise complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exercise">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exercise_id" type="{http://platform.fatsecret.com/api/1.0/}exercise_id"/>
 *         &lt;element name="exercise_name" type="{http://platform.fatsecret.com/api/1.0/}exercise_name"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exercise", namespace = "http://platform.fatsecret.com/api/1.0/", propOrder = {
    "exerciseId",
    "exerciseName"
})
public class Exercise {

    @XmlElement(name = "exercise_id", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected long exerciseId;
    @XmlElement(name = "exercise_name", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected String exerciseName;

    /**
     * Gets the value of the exerciseId property.
     * 
     */
    public long getExerciseId() {
        return exerciseId;
    }

    /**
     * Sets the value of the exerciseId property.
     * 
     */
    public void setExerciseId(long value) {
        this.exerciseId = value;
    }

    /**
     * Gets the value of the exerciseName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExerciseName() {
        return exerciseName;
    }

    /**
     * Sets the value of the exerciseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExerciseName(String value) {
        this.exerciseName = value;
    }

}
