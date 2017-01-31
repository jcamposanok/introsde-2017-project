
package integration.client.entity.fatsecret;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;


/**
 * <p>Java class for food_entry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="food_entry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="food_entry_id" type="{http://platform.fatsecret.com/api/1.0/}food_entry_id"/>
 *         &lt;element name="food_entry_description" type="{http://platform.fatsecret.com/api/1.0/}food_entry_description"/>
 *         &lt;element name="date_int" type="{http://platform.fatsecret.com/api/1.0/}date_int"/>
 *         &lt;element name="meal" type="{http://platform.fatsecret.com/api/1.0/}meal"/>
 *         &lt;element name="food_id" type="{http://platform.fatsecret.com/api/1.0/}food_id"/>
 *         &lt;element name="serving_id" type="{http://platform.fatsecret.com/api/1.0/}serving_id"/>
 *         &lt;element name="number_of_units" type="{http://platform.fatsecret.com/api/1.0/}number_of_units"/>
 *         &lt;element name="food_entry_name" type="{http://platform.fatsecret.com/api/1.0/}food_entry_name"/>
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
@XmlType(name = "food_entry", namespace = "http://platform.fatsecret.com/api/1.0/", propOrder = {
    "foodEntryId",
    "foodEntryDescription",
    "dateInt",
    "meal",
    "foodId",
    "servingId",
    "numberOfUnits",
    "foodEntryName",
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
public class FoodEntry {

    @XmlElement(name = "food_entry_id", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected long foodEntryId;
    @XmlElement(name = "food_entry_description", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected String foodEntryDescription;
    @XmlElement(name = "date_int", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected int dateInt;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    @XmlSchemaType(name = "string")
    protected Meal meal;
    @XmlElement(name = "food_id", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected long foodId;
    @XmlElement(name = "serving_id", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected long servingId;
    @XmlElement(name = "number_of_units", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected BigDecimal numberOfUnits;
    @XmlElement(name = "food_entry_name", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected String foodEntryName;
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
     * Gets the value of the foodEntryId property.
     * 
     */
    public long getFoodEntryId() {
        return foodEntryId;
    }

    /**
     * Sets the value of the foodEntryId property.
     * 
     */
    public void setFoodEntryId(long value) {
        this.foodEntryId = value;
    }

    /**
     * Gets the value of the foodEntryDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoodEntryDescription() {
        return foodEntryDescription;
    }

    /**
     * Sets the value of the foodEntryDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoodEntryDescription(String value) {
        this.foodEntryDescription = value;
    }

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
     * Gets the value of the meal property.
     * 
     * @return
     *     possible object is
     *     {@link Meal }
     *     
     */
    public Meal getMeal() {
        return meal;
    }

    /**
     * Sets the value of the meal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Meal }
     *     
     */
    public void setMeal(Meal value) {
        this.meal = value;
    }

    /**
     * Gets the value of the foodId property.
     * 
     */
    public long getFoodId() {
        return foodId;
    }

    /**
     * Sets the value of the foodId property.
     * 
     */
    public void setFoodId(long value) {
        this.foodId = value;
    }

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
     * Gets the value of the foodEntryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoodEntryName() {
        return foodEntryName;
    }

    /**
     * Sets the value of the foodEntryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoodEntryName(String value) {
        this.foodEntryName = value;
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
