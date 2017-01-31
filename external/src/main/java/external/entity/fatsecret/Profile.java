
package external.entity.fatsecret;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="auth_token" type="{http://platform.fatsecret.com/api/1.0/}auth_token" minOccurs="0"/>
 *         &lt;element name="auth_secret" type="{http://platform.fatsecret.com/api/1.0/}auth_secret" minOccurs="0"/>
 *         &lt;element name="weight_measure" type="{http://platform.fatsecret.com/api/1.0/}weight_measure" minOccurs="0"/>
 *         &lt;element name="height_measure" type="{http://platform.fatsecret.com/api/1.0/}height_measure" minOccurs="0"/>
 *         &lt;element name="last_weight_kg" type="{http://platform.fatsecret.com/api/1.0/}last_weight_kg" minOccurs="0"/>
 *         &lt;element name="last_weight_date_int" type="{http://platform.fatsecret.com/api/1.0/}last_weight_date_int" minOccurs="0"/>
 *         &lt;element name="last_weight_comment" type="{http://platform.fatsecret.com/api/1.0/}last_weight_comment" minOccurs="0"/>
 *         &lt;element name="goal_weight_kg" type="{http://platform.fatsecret.com/api/1.0/}goal_weight_kg" minOccurs="0"/>
 *         &lt;element name="height_cm" type="{http://platform.fatsecret.com/api/1.0/}height_cm" minOccurs="0"/>
 *         &lt;element name="session_key" type="{http://platform.fatsecret.com/api/1.0/}session_key" minOccurs="0"/>
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
    "authToken",
    "authSecret",
    "weightMeasure",
    "heightMeasure",
    "lastWeightKg",
    "lastWeightDateInt",
    "lastWeightComment",
    "goalWeightKg",
    "heightCm",
    "sessionKey"
})
@XmlRootElement(name = "profile", namespace = "http://platform.fatsecret.com/api/1.0/")
public class Profile {

    @XmlElement(name = "auth_token", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected String authToken;
    @XmlElement(name = "auth_secret", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected String authSecret;
    @XmlElement(name = "weight_measure", namespace = "http://platform.fatsecret.com/api/1.0/")
    @XmlSchemaType(name = "string")
    protected WeightMeasure weightMeasure;
    @XmlElement(name = "height_measure", namespace = "http://platform.fatsecret.com/api/1.0/")
    @XmlSchemaType(name = "string")
    protected HeightMeasure heightMeasure;
    @XmlElement(name = "last_weight_kg", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal lastWeightKg;
    @XmlElement(name = "last_weight_date_int", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected Integer lastWeightDateInt;
    @XmlElement(name = "last_weight_comment", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected String lastWeightComment;
    @XmlElement(name = "goal_weight_kg", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal goalWeightKg;
    @XmlElement(name = "height_cm", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected BigDecimal heightCm;
    @XmlElement(name = "session_key", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected String sessionKey;

    /**
     * Gets the value of the authToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * Sets the value of the authToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthToken(String value) {
        this.authToken = value;
    }

    /**
     * Gets the value of the authSecret property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthSecret() {
        return authSecret;
    }

    /**
     * Sets the value of the authSecret property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthSecret(String value) {
        this.authSecret = value;
    }

    /**
     * Gets the value of the weightMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link WeightMeasure }
     *     
     */
    public WeightMeasure getWeightMeasure() {
        return weightMeasure;
    }

    /**
     * Sets the value of the weightMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeightMeasure }
     *     
     */
    public void setWeightMeasure(WeightMeasure value) {
        this.weightMeasure = value;
    }

    /**
     * Gets the value of the heightMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link HeightMeasure }
     *     
     */
    public HeightMeasure getHeightMeasure() {
        return heightMeasure;
    }

    /**
     * Sets the value of the heightMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeightMeasure }
     *     
     */
    public void setHeightMeasure(HeightMeasure value) {
        this.heightMeasure = value;
    }

    /**
     * Gets the value of the lastWeightKg property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLastWeightKg() {
        return lastWeightKg;
    }

    /**
     * Sets the value of the lastWeightKg property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLastWeightKg(BigDecimal value) {
        this.lastWeightKg = value;
    }

    /**
     * Gets the value of the lastWeightDateInt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLastWeightDateInt() {
        return lastWeightDateInt;
    }

    /**
     * Sets the value of the lastWeightDateInt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLastWeightDateInt(Integer value) {
        this.lastWeightDateInt = value;
    }

    /**
     * Gets the value of the lastWeightComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastWeightComment() {
        return lastWeightComment;
    }

    /**
     * Sets the value of the lastWeightComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastWeightComment(String value) {
        this.lastWeightComment = value;
    }

    /**
     * Gets the value of the goalWeightKg property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGoalWeightKg() {
        return goalWeightKg;
    }

    /**
     * Sets the value of the goalWeightKg property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGoalWeightKg(BigDecimal value) {
        this.goalWeightKg = value;
    }

    /**
     * Gets the value of the heightCm property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHeightCm() {
        return heightCm;
    }

    /**
     * Sets the value of the heightCm property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHeightCm(BigDecimal value) {
        this.heightCm = value;
    }

    /**
     * Gets the value of the sessionKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * Sets the value of the sessionKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionKey(String value) {
        this.sessionKey = value;
    }

}
