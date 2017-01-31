package presentation.app.resource;

import org.glassfish.jersey.server.mvc.Template;
import presentation.binding.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("dashboard")
public class DashboardResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Template(name = "/dashboard")
    public Map<String, Object> getView() {
        Map<String, Object> model = new HashMap<String, Object>();
        EndpointInterface service = new BusinessLogicService().getEndpointPort();

        // Invoke WS methods from integration layer
        UserDevicesResponse userDevicesResponse = service.getUserDevices("user");
        UserCaloriesResponse userCaloriesResponse = service.getUserCalories("user", "2017", "01");

        User user = userDevicesResponse.getResponse();
        List<Device> deviceList = user.getDeviceList();

        int calorieBalance = userCaloriesResponse.getCaloriesGained() - userCaloriesResponse.getCaloriesConsumed();
        String resultClass = "info";
        String message = "No data available";
        if (calorieBalance  > 0) {
            resultClass = "alert";
            message = "Push yourself harder!";
        }
        else if (calorieBalance < 0) {
            resultClass = "success";
            message = "Keep up the good work!";
        }

        model.put("user", user);
        model.put("devices", deviceList);
        model.put("summary", userCaloriesResponse);
        model.put("result", calorieBalance);
        model.put("resultClass", resultClass);
        model.put("message", message);

        return model;
    }

}
