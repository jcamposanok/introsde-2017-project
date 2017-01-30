package integration.server.soap;

import integration.client.RestClient;
import integration.server.model.UserModel;
import integration.server.response.UserActivityResponse;
import integration.server.response.UserNutritionResponse;
import integration.server.response.UserProfileResponse;

import javax.jws.WebService;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@WebService(endpointInterface = "integration.server.soap.EndpointInterface"
        , serviceName = "BusinessLogicService")
public class Endpoint implements EndpointInterface {

    public UserProfileResponse getUserProfile(String id) {
        UserProfileResponse response = new UserProfileResponse();
        UserModel user = new UserModel();
        final Response misfitUserResponse = RestClient.get("misfit/user", MediaType.APPLICATION_JSON);
        final Response misfitDeviceResponse = RestClient.get("misfit/device", MediaType.APPLICATION_JSON);
        if (misfitUserResponse.getStatus() == 200) {
            user.setRealName("misfit OK");
        }
        if (misfitDeviceResponse.getStatus() == 200) {
            user.setRealName(user.getRealName().concat("device OK"));
        }
        response.setResponse(user.getRealName());
        return response;
    }

    public UserActivityResponse getUserActivity(String id) {
        return null;
    }

    public UserNutritionResponse getUserNutrition(String id) {
        return null;
    }

}
