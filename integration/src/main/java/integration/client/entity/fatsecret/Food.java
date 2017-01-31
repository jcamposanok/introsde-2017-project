
package integration.client.entity.fatsecret;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for food complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="food">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="food_id" type="{http://platform.fatsecret.com/api/1.0/}food_id"/>
 *         &lt;element name="food_name" type="{http://platform.fatsecret.com/api/1.0/}food_name"/>
 *         &lt;element name="brand_name" type="{http://platform.fatsecret.com/api/1.0/}brand_name" minOccurs="0"/>
 *         &lt;element name="food_type" type="{http://platform.fatsecret.com/api/1.0/}food_type"/>
 *         &lt;element name="food_url" type="{http://platform.fatsecret.com/api/1.0/}food_url"/>
 *         &lt;element name="food_description" type="{http://platform.fatsecret.com/api/1.0/}food_description"/>
 *         &lt;element name="servings" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="serving" type="{http://platform.fatsecret.com/api/1.0/}serving" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "food", namespace = "http://platform.fatsecret.com/api/1.0/", propOrder = {
    "foodId",
    "foodName",
    "brandName",
    "foodType",
    "foodUrl",
    "foodDescription",
    "servings"
})
public class Food {

    @XmlElement(name = "food_id", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected long foodId;
    @XmlElement(name = "food_name", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected String foodName;
    @XmlElement(name = "brand_name", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected String brandName;
    @XmlElement(name = "food_type", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    @XmlSchemaType(name = "string")
    protected FoodType foodType;
    @XmlElement(name = "food_url", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected String foodUrl;
    @XmlElement(name = "food_description", namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
    protected String foodDescription;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected Food.Servings servings;

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
     * Gets the value of the foodName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * Sets the value of the foodName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFoodName(String value) {
        this.foodName = value;
    }

    /**
     * Gets the value of the brandName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Sets the value of the brandName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBrandName(String value) {
        this.brandName = value;
    }

    /**
     * Gets the value of the foodType property.
     *
     * @return
     *     possible object is
     *     {@link FoodType }
     *
     */
    public FoodType getFoodType() {
        return foodType;
    }

    /**
     * Sets the value of the foodType property.
     *
     * @param value
     *     allowed object is
     *     {@link FoodType }
     *
     */
    public void setFoodType(FoodType value) {
        this.foodType = value;
    }

    /**
     * Gets the value of the foodUrl property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFoodUrl() {
        return foodUrl;
    }

    /**
     * Sets the value of the foodUrl property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFoodUrl(String value) {
        this.foodUrl = value;
    }

    /**
     * Gets the value of the foodDescription property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFoodDescription() {
        return foodDescription;
    }

    /**
     * Sets the value of the foodDescription property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFoodDescription(String value) {
        this.foodDescription = value;
    }

    /**
     * Gets the value of the servings property.
     *
     * @return
     *     possible object is
     *     {@link Food.Servings }
     *
     */
    public Food.Servings getServings() {
        return servings;
    }

    /**
     * Sets the value of the servings property.
     *
     * @param value
     *     allowed object is
     *     {@link Food.Servings }
     *
     */
    public void setServings(Food.Servings value) {
        this.servings = value;
    }


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
     *         &lt;element name="serving" type="{http://platform.fatsecret.com/api/1.0/}serving" maxOccurs="unbounded"/>
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
        "serving"
    })
    public static class Servings {

        @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/", required = true)
        protected List<Serving> serving;

        /**
         * Gets the value of the serving property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the serving property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getServing().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Serving }
         * 
         * 
         */
        public List<Serving> getServing() {
            if (serving == null) {
                serving = new ArrayList<Serving>();
            }
            return this.serving;
        }

    }

}
