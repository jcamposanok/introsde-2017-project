
package external.entity.fatsecret;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the external.entity.fatsecret package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Success_QNAME = new QName("http://platform.fatsecret.com/api/1.0/", "success");
    private final static QName _FoodEntryId_QNAME = new QName("http://platform.fatsecret.com/api/1.0/", "food_entry_id");
    private final static QName _Food_QNAME = new QName("http://platform.fatsecret.com/api/1.0/", "food");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: external.entity.fatsecret
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Food }
     * 
     */
    public Food createFood() {
        return new Food();
    }

    /**
     * Create an instance of {@link Foods }
     * 
     */
    public Foods createFoods() {
        return new Foods();
    }

    /**
     * Create an instance of {@link Month }
     * 
     */
    public Month createMonth() {
        return new Month();
    }

    /**
     * Create an instance of {@link Day }
     * 
     */
    public Day createDay() {
        return new Day();
    }

    /**
     * Create an instance of {@link ExerciseEntries }
     * 
     */
    public ExerciseEntries createExerciseEntries() {
        return new ExerciseEntries();
    }

    /**
     * Create an instance of {@link ExerciseEntry }
     * 
     */
    public ExerciseEntry createExerciseEntry() {
        return new ExerciseEntry();
    }

    /**
     * Create an instance of {@link ExerciseTypes }
     * 
     */
    public ExerciseTypes createExerciseTypes() {
        return new ExerciseTypes();
    }

    /**
     * Create an instance of {@link Exercise }
     * 
     */
    public Exercise createExercise() {
        return new Exercise();
    }

    /**
     * Create an instance of {@link Profile }
     * 
     */
    public Profile createProfile() {
        return new Profile();
    }

    /**
     * Create an instance of {@link FoodEntries }
     * 
     */
    public FoodEntries createFoodEntries() {
        return new FoodEntries();
    }

    /**
     * Create an instance of {@link FoodEntry }
     * 
     */
    public FoodEntry createFoodEntry() {
        return new FoodEntry();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link Serving }
     * 
     */
    public Serving createServing() {
        return new Serving();
    }

    /**
     * Create an instance of {@link Food.Servings }
     * 
     */
    public Food.Servings createFoodServings() {
        return new Food.Servings();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://platform.fatsecret.com/api/1.0/", name = "success")
    public JAXBElement<Boolean> createSuccess(Boolean value) {
        return new JAXBElement<Boolean>(_Success_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://platform.fatsecret.com/api/1.0/", name = "food_entry_id")
    public JAXBElement<Long> createFoodEntryId(Long value) {
        return new JAXBElement<Long>(_FoodEntryId_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Food }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://platform.fatsecret.com/api/1.0/", name = "food")
    public JAXBElement<Food> createFood(Food value) {
        return new JAXBElement<Food>(_Food_QNAME, Food.class, null, value);
    }

}
