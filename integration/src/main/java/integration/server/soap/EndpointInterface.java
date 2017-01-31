package integration.server.soap;

import integration.server.response.UserActivityResponse;
import integration.server.response.UserDevicesResponse;
import integration.server.response.UserNutritionResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface EndpointInterface {

    @WebMethod(operationName = "getUserDevices")
    @WebResult(name = "devices")
    public UserDevicesResponse getUserDevices(@WebParam(name = "id") String id);

    @WebMethod(operationName = "getUserActivity")
    @WebResult(name = "activity")
    public UserActivityResponse getUserActivity(@WebParam(name = "id") String id);

    @WebMethod(operationName = "getUserNutrition")
    @WebResult(name = "nutrition")
    public UserNutritionResponse getUserNutrition(@WebParam(name = "id") String id);

}
