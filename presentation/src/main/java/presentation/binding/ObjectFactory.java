
package presentation.binding;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the presentation.binding package. 
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

    private final static QName _GetUserNutritionResponse_QNAME = new QName("http://soap.server.integration/", "getUserNutritionResponse");
    private final static QName _GetUserActivityResponse_QNAME = new QName("http://soap.server.integration/", "getUserActivityResponse");
    private final static QName _GetUserDevices_QNAME = new QName("http://soap.server.integration/", "getUserDevices");
    private final static QName _Device_QNAME = new QName("http://soap.server.integration/", "device");
    private final static QName _GetUserNutrition_QNAME = new QName("http://soap.server.integration/", "getUserNutrition");
    private final static QName _User_QNAME = new QName("http://soap.server.integration/", "user");
    private final static QName _GetUserActivity_QNAME = new QName("http://soap.server.integration/", "getUserActivity");
    private final static QName _GetUserDevicesResponse_QNAME = new QName("http://soap.server.integration/", "getUserDevicesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: presentation.binding
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserActivityResponse }
     * 
     */
    public GetUserActivityResponse createGetUserActivityResponse() {
        return new GetUserActivityResponse();
    }

    /**
     * Create an instance of {@link GetUserNutritionResponse }
     * 
     */
    public GetUserNutritionResponse createGetUserNutritionResponse() {
        return new GetUserNutritionResponse();
    }

    /**
     * Create an instance of {@link GetUserActivity }
     * 
     */
    public GetUserActivity createGetUserActivity() {
        return new GetUserActivity();
    }

    /**
     * Create an instance of {@link GetUserDevicesResponse }
     * 
     */
    public GetUserDevicesResponse createGetUserDevicesResponse() {
        return new GetUserDevicesResponse();
    }

    /**
     * Create an instance of {@link GetUserDevices }
     * 
     */
    public GetUserDevices createGetUserDevices() {
        return new GetUserDevices();
    }

    /**
     * Create an instance of {@link Device }
     * 
     */
    public Device createDevice() {
        return new Device();
    }

    /**
     * Create an instance of {@link GetUserNutrition }
     * 
     */
    public GetUserNutrition createGetUserNutrition() {
        return new GetUserNutrition();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link UserDevicesResponse }
     * 
     */
    public UserDevicesResponse createUserDevicesResponse() {
        return new UserDevicesResponse();
    }

    /**
     * Create an instance of {@link UserActivityResponse }
     * 
     */
    public UserActivityResponse createUserActivityResponse() {
        return new UserActivityResponse();
    }

    /**
     * Create an instance of {@link UserNutritionResponse }
     * 
     */
    public UserNutritionResponse createUserNutritionResponse() {
        return new UserNutritionResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserNutritionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.server.integration/", name = "getUserNutritionResponse")
    public JAXBElement<GetUserNutritionResponse> createGetUserNutritionResponse(GetUserNutritionResponse value) {
        return new JAXBElement<GetUserNutritionResponse>(_GetUserNutritionResponse_QNAME, GetUserNutritionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserActivityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.server.integration/", name = "getUserActivityResponse")
    public JAXBElement<GetUserActivityResponse> createGetUserActivityResponse(GetUserActivityResponse value) {
        return new JAXBElement<GetUserActivityResponse>(_GetUserActivityResponse_QNAME, GetUserActivityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserDevices }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.server.integration/", name = "getUserDevices")
    public JAXBElement<GetUserDevices> createGetUserDevices(GetUserDevices value) {
        return new JAXBElement<GetUserDevices>(_GetUserDevices_QNAME, GetUserDevices.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Device }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.server.integration/", name = "device")
    public JAXBElement<Device> createDevice(Device value) {
        return new JAXBElement<Device>(_Device_QNAME, Device.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserNutrition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.server.integration/", name = "getUserNutrition")
    public JAXBElement<GetUserNutrition> createGetUserNutrition(GetUserNutrition value) {
        return new JAXBElement<GetUserNutrition>(_GetUserNutrition_QNAME, GetUserNutrition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.server.integration/", name = "user")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserActivity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.server.integration/", name = "getUserActivity")
    public JAXBElement<GetUserActivity> createGetUserActivity(GetUserActivity value) {
        return new JAXBElement<GetUserActivity>(_GetUserActivity_QNAME, GetUserActivity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserDevicesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.server.integration/", name = "getUserDevicesResponse")
    public JAXBElement<GetUserDevicesResponse> createGetUserDevicesResponse(GetUserDevicesResponse value) {
        return new JAXBElement<GetUserDevicesResponse>(_GetUserDevicesResponse_QNAME, GetUserDevicesResponse.class, null, value);
    }

}
