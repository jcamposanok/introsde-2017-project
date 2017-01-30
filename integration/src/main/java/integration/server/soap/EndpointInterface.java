package integration.server.soap;

import integration.server.response.UserActivityResponse;
import integration.server.response.UserNutritionResponse;
import integration.server.response.UserProfileResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface EndpointInterface {

    @WebMethod(operationName = "getUserProfile")
    @WebResult(name = "profile")
    public UserProfileResponse getUserProfile(@WebParam(name = "id") String id);

    @WebMethod(operationName = "getUserActivity")
    @WebResult(name = "activity")
    public UserActivityResponse getUserActivity(@WebParam(name = "id") String id);

    @WebMethod(operationName = "getUserNutrition")
    @WebResult(name = "nutrition")
    public UserNutritionResponse getUserNutrition(@WebParam(name = "id") String id);

}
