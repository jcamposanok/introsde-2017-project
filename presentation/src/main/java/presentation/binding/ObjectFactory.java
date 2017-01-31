
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

    private final static QName _GetUserDevices_QNAME = new QName("http://soap.server.integration/", "getUserDevices");
    private final static QName _Device_QNAME = new QName("http://soap.server.integration/", "device");
    private final static QName _GetUserCalories_QNAME = new QName("http://soap.server.integration/", "getUserCalories");
    private final static QName _User_QNAME = new QName("http://soap.server.integration/", "user");
    private final static QName _GetUserCaloriesResponse_QNAME = new QName("http://soap.server.integration/", "getUserCaloriesResponse");
    private final static QName _GetUserDevicesResponse_QNAME = new QName("http://soap.server.integration/", "getUserDevicesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: presentation.binding
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserDevicesResponse }
     * 
     */
    public GetUserDevicesResponse createGetUserDevicesResponse() {
        return new GetUserDevicesResponse();
    }

    /**
     * Create an instance of {@link GetUserCaloriesResponse }
     * 
     */
    public GetUserCaloriesResponse createGetUserCaloriesResponse() {
        return new GetUserCaloriesResponse();
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
     * Create an instance of {@link GetUserCalories }
     * 
     */
    public GetUserCalories createGetUserCalories() {
        return new GetUserCalories();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link UserCaloriesResponse }
     * 
     */
    public UserCaloriesResponse createUserCaloriesResponse() {
        return new UserCaloriesResponse();
    }

    /**
     * Create an instance of {@link UserDevicesResponse }
     * 
     */
    public UserDevicesResponse createUserDevicesResponse() {
        return new UserDevicesResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserCalories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.server.integration/", name = "getUserCalories")
    public JAXBElement<GetUserCalories> createGetUserCalories(GetUserCalories value) {
        return new JAXBElement<GetUserCalories>(_GetUserCalories_QNAME, GetUserCalories.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserCaloriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.server.integration/", name = "getUserCaloriesResponse")
    public JAXBElement<GetUserCaloriesResponse> createGetUserCaloriesResponse(GetUserCaloriesResponse value) {
        return new JAXBElement<GetUserCaloriesResponse>(_GetUserCaloriesResponse_QNAME, GetUserCaloriesResponse.class, null, value);
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
