package integration.server.soap;

import integration.client.RestClient;
import integration.client.entity.misfit.MisfitDevice;
import integration.client.entity.misfit.MisfitUser;
import integration.server.model.Device;
import integration.server.model.User;
import integration.server.response.UserActivityResponse;
import integration.server.response.UserDevicesResponse;
import integration.server.response.UserNutritionResponse;

import javax.jws.WebService;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@WebService(endpointInterface = "integration.server.soap.EndpointInterface"
        , serviceName = "BusinessLogicService")
public class Endpoint implements EndpointInterface {

    public UserDevicesResponse getUserDevices(String id) {
        UserDevicesResponse response = new UserDevicesResponse();
        User user = new User();
        List<Device> deviceList = new ArrayList<Device>();
        final Response misfitUserResponse = RestClient.get("misfit/user", MediaType.APPLICATION_JSON);
        final Response misfitDeviceResponse = RestClient.get("misfit/device", MediaType.APPLICATION_JSON);
        if (misfitUserResponse.getStatus() == 200) {
            MisfitUser misfitUser = misfitUserResponse.readEntity(MisfitUser.class);
            user.setRealName(misfitUser.name);
            if (misfitDeviceResponse.getStatus() == 200) {
                MisfitDevice misfitDevice = misfitDeviceResponse.readEntity(MisfitDevice.class);
                Device device = new Device();
                device.setDeviceType(misfitDevice.deviceType);
                deviceList.add(device);
            }
            user.setDeviceList(deviceList);
        }
        response.setResponse(user);
        return response;
    }

    public UserActivityResponse getUserActivity(String id) {
        return null;
    }

    public UserNutritionResponse getUserNutrition(String id) {
        return null;
    }

}
