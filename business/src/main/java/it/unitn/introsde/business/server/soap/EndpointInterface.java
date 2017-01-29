package it.unitn.introsde.business.server.soap;

import it.unitn.introsde.business.server.response.UserProfileResponse;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface EndpointInterface {

    @WebMethod(operationName = "getUserProfile")
    @WebResult(name = "profile")
    public UserProfileResponse getUserProfile();

}
