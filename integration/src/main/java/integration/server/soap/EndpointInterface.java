package integration.server.soap;

import integration.server.response.UserCaloriesResponse;
import integration.server.response.UserDevicesResponse;

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

    @WebMethod(operationName = "getUserCalories")
    @WebResult(name = "calories")
    public UserCaloriesResponse getUserCalories(@WebParam(name = "id") String id, @WebParam(name = "year") String year, @WebParam(name = "month") String month);

}
