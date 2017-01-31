
package integration.client.entity.fatsecret;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for food_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="food_type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Brand"/>
 *     &lt;enumeration value="Generic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "food_type", namespace = "http://platform.fatsecret.com/api/1.0/")
@XmlEnum
public enum FoodType {

    @XmlEnumValue("Brand")
    BRAND("Brand"),
    @XmlEnumValue("Generic")
    GENERIC("Generic");
    private final String value;

    FoodType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FoodType fromValue(String v) {
        for (FoodType c: FoodType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
