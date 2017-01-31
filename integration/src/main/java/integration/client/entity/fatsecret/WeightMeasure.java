
package integration.client.entity.fatsecret;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for weight_measure.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="weight_measure">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Kg"/>
 *     &lt;enumeration value="Lb"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "weight_measure", namespace = "http://platform.fatsecret.com/api/1.0/")
@XmlEnum
public enum WeightMeasure {

    @XmlEnumValue("Kg")
    KG("Kg"),
    @XmlEnumValue("Lb")
    LB("Lb");
    private final String value;

    WeightMeasure(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WeightMeasure fromValue(String v) {
        for (WeightMeasure c: WeightMeasure.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
