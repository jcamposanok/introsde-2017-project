package it.unitn.introsde.business.server.soap;


import it.unitn.introsde.business.client.RestClient;
import it.unitn.introsde.business.server.model.User;
import it.unitn.introsde.business.server.response.UserProfileResponse;

import javax.jws.WebService;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@WebService(endpointInterface = "it.unitn.introsde.business.server.soap.EndpointInterface"
        , serviceName = "BusinessLogicService")
public class Endpoint implements EndpointInterface {

    public UserProfileResponse getUserProfile() {
        User user = new User();
        final Response userResponse = RestClient.get("misfit/user", MediaType.APPLICATION_JSON);
        if (userResponse.getStatus() == 200) {

        }

        return null;
    }

}
