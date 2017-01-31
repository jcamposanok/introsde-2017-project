
package external.entity.fatsecret;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="max_results" type="{http://platform.fatsecret.com/api/1.0/}max_results"/>
 *         &lt;element name="total_results" type="{http://platform.fatsecret.com/api/1.0/}total_results"/>
 *         &lt;element name="page_number" type="{http://platform.fatsecret.com/api/1.0/}page_number"/>
 *         &lt;element name="food" type="{http://platform.fatsecret.com/api/1.0/}food" maxOccurs="unbounded" minOccurs="0"/>
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
    "maxResults",
    "totalResults",
    "pageNumber",
    "food"
})
@XmlRootElement(name = "foods", namespace = "http://platform.fatsecret.com/api/1.0/")
public class Foods {

    @XmlElement(name = "max_results", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected int maxResults;
    @XmlElement(name = "total_results", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected int totalResults;
    @XmlElement(name = "page_number", namespace = "http://platform.fatsecret.com/api/1.0/")
    protected int pageNumber;
    @XmlElement(namespace = "http://platform.fatsecret.com/api/1.0/")
    protected List<Food> food;

    /**
     * Gets the value of the maxResults property.
     * 
     */
    public int getMaxResults() {
        return maxResults;
    }

    /**
     * Sets the value of the maxResults property.
     * 
     */
    public void setMaxResults(int value) {
        this.maxResults = value;
    }

    /**
     * Gets the value of the totalResults property.
     * 
     */
    public int getTotalResults() {
        return totalResults;
    }

    /**
     * Sets the value of the totalResults property.
     * 
     */
    public void setTotalResults(int value) {
        this.totalResults = value;
    }

    /**
     * Gets the value of the pageNumber property.
     * 
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets the value of the pageNumber property.
     * 
     */
    public void setPageNumber(int value) {
        this.pageNumber = value;
    }

    /**
     * Gets the value of the food property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the food property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFood().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Food }
     * 
     * 
     */
    public List<Food> getFood() {
        if (food == null) {
            food = new ArrayList<Food>();
        }
        return this.food;
    }

}
