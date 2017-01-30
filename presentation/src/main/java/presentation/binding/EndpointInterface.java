
package presentation.binding;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "EndpointInterface", targetNamespace = "http://soap.server.integration/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EndpointInterface {


    /**
     * 
     * @param id
     * @return
     *     returns presentation.binding.UserProfileResponse
     */
    @WebMethod
    @WebResult(name = "profile", targetNamespace = "")
    @RequestWrapper(localName = "getUserProfile", targetNamespace = "http://soap.server.integration/", className = "presentation.binding.GetUserProfile")
    @ResponseWrapper(localName = "getUserProfileResponse", targetNamespace = "http://soap.server.integration/", className = "presentation.binding.GetUserProfileResponse")
    @Action(input = "http://soap.server.integration/EndpointInterface/getUserProfileRequest", output = "http://soap.server.integration/EndpointInterface/getUserProfileResponse")
    public UserProfileResponse getUserProfile(
        @WebParam(name = "id", targetNamespace = "")
        String id);

    /**
     * 
     * @param id
     * @return
     *     returns presentation.binding.UserActivityResponse
     */
    @WebMethod
    @WebResult(name = "activity", targetNamespace = "")
    @RequestWrapper(localName = "getUserActivity", targetNamespace = "http://soap.server.integration/", className = "presentation.binding.GetUserActivity")
    @ResponseWrapper(localName = "getUserActivityResponse", targetNamespace = "http://soap.server.integration/", className = "presentation.binding.GetUserActivityResponse")
    @Action(input = "http://soap.server.integration/EndpointInterface/getUserActivityRequest", output = "http://soap.server.integration/EndpointInterface/getUserActivityResponse")
    public UserActivityResponse getUserActivity(
        @WebParam(name = "id", targetNamespace = "")
        String id);

    /**
     * 
     * @param id
     * @return
     *     returns presentation.binding.UserNutritionResponse
     */
    @WebMethod
    @WebResult(name = "nutrition", targetNamespace = "")
    @RequestWrapper(localName = "getUserNutrition", targetNamespace = "http://soap.server.integration/", className = "presentation.binding.GetUserNutrition")
    @ResponseWrapper(localName = "getUserNutritionResponse", targetNamespace = "http://soap.server.integration/", className = "presentation.binding.GetUserNutritionResponse")
    @Action(input = "http://soap.server.integration/EndpointInterface/getUserNutritionRequest", output = "http://soap.server.integration/EndpointInterface/getUserNutritionResponse")
    public UserNutritionResponse getUserNutrition(
        @WebParam(name = "id", targetNamespace = "")
        String id);

}
