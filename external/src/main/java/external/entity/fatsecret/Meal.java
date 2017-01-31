
package external.entity.fatsecret;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for meal.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="meal">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Breakfast"/>
 *     &lt;enumeration value="Lunch"/>
 *     &lt;enumeration value="Dinner"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "meal", namespace = "http://platform.fatsecret.com/api/1.0/")
@XmlEnum
public enum Meal {

    @XmlEnumValue("Breakfast")
    BREAKFAST("Breakfast"),
    @XmlEnumValue("Lunch")
    LUNCH("Lunch"),
    @XmlEnumValue("Dinner")
    DINNER("Dinner"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    Meal(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Meal fromValue(String v) {
        for (Meal c: Meal.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
