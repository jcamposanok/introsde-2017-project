
package external.entity.fatsecret;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for serving complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serving">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serving_id" type="{http://platform.fatsecret.com/api/1.0/}serving_id"/>
 *         &lt;element name="serving_description" type="{http://platform.fatsecret.com/api/1.0/}serving_description"/>
 *         &lt;element name="serving_url" type="{http://platform.fatsecret.com/api/1.0/}serving_url"/>
 *         &lt;element name="metric_serving_amount" type="{http://platform.fatsecret.com/api/1.0/}metric_serving_amount" minOccurs="0"/>
 *         &lt;element name="metric_serving_unit" type="{http://platform.fatsecret.com/api/1.0/}metric_serving_unit" minOccurs="0"/>
 *         &lt;element name="number_of_units" type="{http://platform.fatsecret.com/api/1.0/}number_of_units"/>
 *         &lt;element name="measurement_description" type="{http://platform.fatsecret.com/api/1.0/}measurement_description"/>
 *         &lt;element name="calories" type="{http://platform.fatsecret.com/api/1.0/}calories"/>
 *         &lt;element name="carbohydrate" type="{http://platform.fatsecret.com/api/1.0/}carbohydrate"/>
 *         &lt;element name="protein" type="{http://platform.fatsecret.com/api/1.0/}protein"/>
 *         &lt;element name="fat" type="{http://platform.fatsecret.com/api/1.0/}fat"/>
 *         &lt;element name="saturated_fat" type="{http://platform.fatsecret.com/api/1.0/}saturated_fat" minOccurs="0"/>
 *         &lt;element name="polyunsaturated_fat" type="{http://platform.fatsecret.com/api/1.0/}polyunsaturated_fat" minOccurs="0"/>
 *         &lt;element name="monounsaturated_fat" type="{http://platform.fatsecret.com/api/1.0/}monounsaturated_fat" minOccurs="0"/>
 *         &lt;element name="trans_fat" type="{http://platform.fatsecret.com/api/1.0/}trans_fat" minOccurs="0"/>
 *         &lt;element name="cholesterol" type="{http://platform.fatsecret.com/api/1.0/}cholesterol" minOccurs="0"/>
 *         &lt;element name="sodium" type="{http://platform.fatsecret.com/api/1.0/}sodium" minOccurs="0"/>
 *         &lt;element name="potassium" type="{http://platform.fatsecret.com/api/1.0/}potassium" minOccurs="0"/>
 *         &lt;element name="fiber" type="{http://platform.fatsecret.com/api/1.0/}fiber" minOccurs="0"/>
 *         &lt;element name="sugar" type="{http://platform.fatsecret.com/api/1.0/}sugar" minOccurs="0"/>
 *         &lt;element name="vitamin_a" type="{http://platform.fatsecret.com/api/1.0/}vitamin_a" minOccurs="0"/>
 *         &lt;element name="vitamin_c" type="{http://platform.fatsecret.com/api/1.0/}vitamin_c" minOccurs="0"/>
 *         &lt;element name="calcium" type="{http://platform.fatsecret.com/api/1.0/}calcium" minOccurs="0"/>
 *         &lt;element name="iron" type="{http://platform.fatsecret.com/api/1.0/}iron" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serving", namespace = "http://platform.fatsecret.com/api/1.0/", propOrder = {
    "servingId",
    "servingDescription",
    "servingUrl",
    "metricServingAmount",
    "metricServingUnit",
    "numberOfUnits",
    "measurementDescription",
    "calories",
    "carbohydrate",
    "protein",
    "fat",
    "saturatedFat",
    "polyunsaturatedFat",
    "monounsaturatedFat",
    "transFat",
    "cholesterol",
    "sodium",
    "potassium",
    "fiber",
    "sugar",
    "vitaminA",
    "vitaminC",
    "calcium",
    "iron"
})
public class Serving {

    @XmlElement(name = "serving_id", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected long servingId;
    @XmlElement(name = "serving_description", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected String servingDescription;
    @XmlElement(name = "serving_url", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected String servingUrl;
    @XmlElement(name = "metric_serving_amount", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal metricServingAmount;
    @XmlElement(name = "metric_serving_unit", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected String metricServingUnit;
    @XmlElement(name = "number_of_units", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected BigDecimal numberOfUnits;
    @XmlElement(name = "measurement_description", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected String measurementDescription;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected BigDecimal calories;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected BigDecimal carbohydrate;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected BigDecimal protein;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected BigDecimal fat;
    @XmlElement(name = "saturated_fat", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal saturatedFat;
    @XmlElement(name = "polyunsaturated_fat", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal polyunsaturatedFat;
    @XmlElement(name = "monounsaturated_fat", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal monounsaturatedFat;
    @XmlElement(name = "trans_fat", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal transFat;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal cholesterol;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal sodium;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal potassium;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal fiber;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal sugar;
    @XmlElement(name = "vitamin_a", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal vitaminA;
    @XmlElement(name = "vitamin_c", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal vitaminC;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal calcium;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal iron;

    /**
     * Gets the value of the servingId property.
     * 
     */
    public long getServingId() {
        return servingId;
    }

    /**
     * Sets the value of the servingId property.
     * 
     */
    public void setServingId(long value) {
        this.servingId = value;
    }

    /**
     * Gets the value of the servingDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServingDescription() {
        return servingDescription;
    }

    /**
     * Sets the value of the servingDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServingDescription(String value) {
        this.servingDescription = value;
    }

    /**
     * Gets the value of the servingUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServingUrl() {
        return servingUrl;
    }

    /**
     * Sets the value of the servingUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServingUrl(String value) {
        this.servingUrl = value;
    }

    /**
     * Gets the value of the metricServingAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMetricServingAmount() {
        return metricServingAmount;
    }

    /**
     * Sets the value of the metricServingAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMetricServingAmount(BigDecimal value) {
        this.metricServingAmount = value;
    }

    /**
     * Gets the value of the metricServingUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetricServingUnit() {
        return metricServingUnit;
    }

    /**
     * Sets the value of the metricServingUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetricServingUnit(String value) {
        this.metricServingUnit = value;
    }

    /**
     * Gets the value of the numberOfUnits property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNumberOfUnits() {
        return numberOfUnits;
    }

    /**
     * Sets the value of the numberOfUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNumberOfUnits(BigDecimal value) {
        this.numberOfUnits = value;
    }

    /**
     * Gets the value of the measurementDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasurementDescription() {
        return measurementDescription;
    }

    /**
     * Sets the value of the measurementDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasurementDescription(String value) {
        this.measurementDescription = value;
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
     * Gets the value of the saturatedFat property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSaturatedFat() {
        return saturatedFat;
    }

    /**
     * Sets the value of the saturatedFat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSaturatedFat(BigDecimal value) {
        this.saturatedFat = value;
    }

    /**
     * Gets the value of the polyunsaturatedFat property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPolyunsaturatedFat() {
        return polyunsaturatedFat;
    }

    /**
     * Sets the value of the polyunsaturatedFat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPolyunsaturatedFat(BigDecimal value) {
        this.polyunsaturatedFat = value;
    }

    /**
     * Gets the value of the monounsaturatedFat property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMonounsaturatedFat() {
        return monounsaturatedFat;
    }

    /**
     * Sets the value of the monounsaturatedFat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMonounsaturatedFat(BigDecimal value) {
        this.monounsaturatedFat = value;
    }

    /**
     * Gets the value of the transFat property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTransFat() {
        return transFat;
    }

    /**
     * Sets the value of the transFat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTransFat(BigDecimal value) {
        this.transFat = value;
    }

    /**
     * Gets the value of the cholesterol property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCholesterol() {
        return cholesterol;
    }

    /**
     * Sets the value of the cholesterol property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCholesterol(BigDecimal value) {
        this.cholesterol = value;
    }

    /**
     * Gets the value of the sodium property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSodium() {
        return sodium;
    }

    /**
     * Sets the value of the sodium property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSodium(BigDecimal value) {
        this.sodium = value;
    }

    /**
     * Gets the value of the potassium property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPotassium() {
        return potassium;
    }

    /**
     * Sets the value of the potassium property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPotassium(BigDecimal value) {
        this.potassium = value;
    }

    /**
     * Gets the value of the fiber property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFiber() {
        return fiber;
    }

    /**
     * Sets the value of the fiber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFiber(BigDecimal value) {
        this.fiber = value;
    }

    /**
     * Gets the value of the sugar property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSugar() {
        return sugar;
    }

    /**
     * Sets the value of the sugar property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSugar(BigDecimal value) {
        this.sugar = value;
    }

    /**
     * Gets the value of the vitaminA property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVitaminA() {
        return vitaminA;
    }

    /**
     * Sets the value of the vitaminA property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVitaminA(BigDecimal value) {
        this.vitaminA = value;
    }

    /**
     * Gets the value of the vitaminC property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVitaminC() {
        return vitaminC;
    }

    /**
     * Sets the value of the vitaminC property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVitaminC(BigDecimal value) {
        this.vitaminC = value;
    }

    /**
     * Gets the value of the calcium property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCalcium() {
        return calcium;
    }

    /**
     * Sets the value of the calcium property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCalcium(BigDecimal value) {
        this.calcium = value;
    }

    /**
     * Gets the value of the iron property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIron() {
        return iron;
    }

    /**
     * Sets the value of the iron property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIron(BigDecimal value) {
        this.iron = value;
    }

}
