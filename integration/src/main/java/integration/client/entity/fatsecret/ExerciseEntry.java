
package integration.client.entity.fatsecret;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for exercise_entry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exercise_entry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="is_template_value" type="{http://platform.fatsecret.com/api/1.0/}is_template_value"/>
 *         &lt;element name="exercise_id" type="{http://platform.fatsecret.com/api/1.0/}exercise_id"/>
 *         &lt;element name="exercise_name" type="{http://platform.fatsecret.com/api/1.0/}exercise_name"/>
 *         &lt;element name="minutes" type="{http://platform.fatsecret.com/api/1.0/}minutes"/>
 *         &lt;element name="calories" type="{http://platform.fatsecret.com/api/1.0/}calories"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exercise_entry", namespace = "http://platform.fatsecret.com/api/1.0/", propOrder = {
    "isTemplateValue",
    "exerciseId",
    "exerciseName",
    "minutes",
    "calories"
})
public class ExerciseEntry {

    @XmlElement(name = "is_template_value", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected boolean isTemplateValue;
    @XmlElement(name = "exercise_id", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected long exerciseId;
    @XmlElement(name = "exercise_name", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected String exerciseName;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected int minutes;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected BigDecimal calories;

    /**
     * Gets the value of the isTemplateValue property.
     * 
     */
    public boolean isIsTemplateValue() {
        return isTemplateValue;
    }

    /**
     * Sets the value of the isTemplateValue property.
     * 
     */
    public void setIsTemplateValue(boolean value) {
        this.isTemplateValue = value;
    }

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

    /**
     * Gets the value of the minutes property.
     * 
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Sets the value of the minutes property.
     * 
     */
    public void setMinutes(int value) {
        this.minutes = value;
    }

    /**
     * Gets the value of the calories property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCalories() {
        return calories;
    }

    /**
     * Sets the value of the calories property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCalories(BigDecimal value) {
        this.calories = value;
    }

}
