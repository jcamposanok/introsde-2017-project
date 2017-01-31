
package integration.client.entity.fatsecret;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for height_measure.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="height_measure">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Cm"/>
 *     &lt;enumeration value="Inch"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "height_measure", namespace = "http://platform.fatsecret.com/api/1.0/")
@XmlEnum
public enum HeightMeasure {

    @XmlEnumValue("Cm")
    CM("Cm"),
    @XmlEnumValue("Inch")
    INCH("Inch");
    private final String value;

    HeightMeasure(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HeightMeasure fromValue(String v) {
        for (HeightMeasure c: HeightMeasure.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
