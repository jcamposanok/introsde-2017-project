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

        User user = userDevicesResponse.getResponse();
        List<Device> deviceList = user.getDeviceList();

        model.put("user", user);
        model.put("devices", deviceList);
        return model;
    }

}
