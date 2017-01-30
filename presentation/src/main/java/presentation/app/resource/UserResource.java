package presentation.app.resource;

import org.glassfish.jersey.server.mvc.Template;
import presentation.binding.BusinessLogicService;
import presentation.binding.EndpointInterface;
import presentation.binding.UserProfileResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("user")
public class UserResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Template(name = "/view")
    public Map<String, Object> getView() {
        Map<String, Object> model = new HashMap<String, Object>();
        EndpointInterface service = new BusinessLogicService().getEndpointPort();
        //invoke business method
        UserProfileResponse userProfileResponse = service.getUserProfile("user");
        model.put("response", userProfileResponse.getResponse());
        return model;
    }

}
