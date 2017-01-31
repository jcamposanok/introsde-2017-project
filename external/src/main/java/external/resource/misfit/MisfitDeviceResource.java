package external.resource.misfit;

import external.entity.misfit.MisfitDevice;
import external.resource.MisfitResource;
import external.oauth.MisfitAuthService;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;


public class MisfitDeviceResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private static String RESOURCE_NAME = "device";
    private static String API_ENDPOINT = "move/resource/v1/user/me/device";

    public MisfitDeviceResource(UriInfo uriInfo, Request request) {
        MisfitAuthService.setResourceName(RESOURCE_NAME);
        this.uriInfo = uriInfo;
        this.request = request;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response get() {
        Response response =  MisfitResource.getResponse(uriInfo, API_ENDPOINT);
        if (response.getStatus() == 200) {
            MisfitDevice entity = response.readEntity(MisfitDevice.class);
            return Response.ok(entity).build();
        }
        return response;
    }

}
