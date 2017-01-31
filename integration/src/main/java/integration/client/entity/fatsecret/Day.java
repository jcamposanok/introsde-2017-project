
package integration.client.entity.fatsecret;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for day complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="day">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date_int" type="{http://platform.fatsecret.com/api/1.0/}date_int"/>
 *         &lt;element name="calories" type="{http://platform.fatsecret.com/api/1.0/}calories" minOccurs="0"/>
 *         &lt;element name="carbohydrate" type="{http://platform.fatsecret.com/api/1.0/}carbohydrate" minOccurs="0"/>
 *         &lt;element name="protein" type="{http://platform.fatsecret.com/api/1.0/}protein" minOccurs="0"/>
 *         &lt;element name="fat" type="{http://platform.fatsecret.com/api/1.0/}fat" minOccurs="0"/>
 *         &lt;element name="weight_kg" type="{http://platform.fatsecret.com/api/1.0/}weight_kg" minOccurs="0"/>
 *         &lt;element name="weight_comment" type="{http://platform.fatsecret.com/api/1.0/}weight_comment" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "day", namespace = "http://platform.fatsecret.com/api/1.0/", propOrder = {
    "dateInt",
    "calories",
    "carbohydrate",
    "protein",
    "fat",
    "weightKg",
    "weightComment"
})
public class Day {

    @XmlElement(name = "date_int", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected int dateInt;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal calories;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal carbohydrate;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal protein;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal fat;
    @XmlElement(name = "weight_kg", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal weightKg;
    @XmlElement(name = "weight_comment", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected String weightComment;

    /**
     * Gets the value of the dateInt property.
     * 
     */
    public int getDateInt() {
        return dateInt;
    }

    /**
     * Sets the value of the dateInt property.
     * 
     */
    public void setDateInt(int value) {
        this.dateInt = value;
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

    /**
     * Gets the value of the carbohydrate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCarbohydrate() {
        return carbohydrate;
    }

    /**
     * Sets the value of the carbohydrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCarbohydrate(BigDecimal value) {
        this.carbohydrate = value;
    }

    /**
     * Gets the value of the protein property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProtein() {
        return protein;
    }

    /**
     * Sets the value of the protein property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProtein(BigDecimal value) {
        this.protein = value;
    }

    /**
     * Gets the value of the fat property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFat() {
        return fat;
    }

    /**
     * Sets the value of the fat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFat(BigDecimal value) {
        this.fat = value;
    }

    /**
     * Gets the value of the weightKg property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWeightKg() {
        return weightKg;
    }

    /**
     * Sets the value of the weightKg property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWeightKg(BigDecimal value) {
        this.weightKg = value;
    }

    /**
     * Gets the value of the weightComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeightComment() {
        return weightComment;
    }

    /**
     * Sets the value of the weightComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeightComment(String value) {
        this.weightComment = value;
    }

}
