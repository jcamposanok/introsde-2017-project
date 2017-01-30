
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
    private final static QName _GetUserProfile_QNAME = new QName("http://soap.server.integration/", "getUserProfile");
    private final static QName _GetUserProfileResponse_QNAME = new QName("http://soap.server.integration/", "getUserProfileResponse");
    private final static QName _GetUserNutrition_QNAME = new QName("http://soap.server.integration/", "getUserNutrition");
    private final static QName _GetUserActivity_QNAME = new QName("http://soap.server.integration/", "getUserActivity");

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
     * Create an instance of {@link GetUserNutrition }
     * 
     */
    public GetUserNutrition createGetUserNutrition() {
        return new GetUserNutrition();
    }

    /**
     * Create an instance of {@link GetUserProfile }
     * 
     */
    public GetUserProfile createGetUserProfile() {
        return new GetUserProfile();
    }

    /**
     * Create an instance of {@link GetUserProfileResponse }
     * 
     */
    public GetUserProfileResponse createGetUserProfileResponse() {
        return new GetUserProfileResponse();
    }

    /**
     * Create an instance of {@link UserProfileResponse }
     * 
     */
    public UserProfileResponse createUserProfileResponse() {
        return new UserProfileResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.server.integration/", name = "getUserProfile")
    public JAXBElement<GetUserProfile> createGetUserProfile(GetUserProfile value) {
        return new JAXBElement<GetUserProfile>(_GetUserProfile_QNAME, GetUserProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserProfileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.server.integration/", name = "getUserProfileResponse")
    public JAXBElement<GetUserProfileResponse> createGetUserProfileResponse(GetUserProfileResponse value) {
        return new JAXBElement<GetUserProfileResponse>(_GetUserProfileResponse_QNAME, GetUserProfileResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserActivity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.server.integration/", name = "getUserActivity")
    public JAXBElement<GetUserActivity> createGetUserActivity(GetUserActivity value) {
        return new JAXBElement<GetUserActivity>(_GetUserActivity_QNAME, GetUserActivity.class, null, value);
    }

}
