package it.unitn.introsde.ehealth.resource.misfit;

import it.unitn.introsde.ehealth.resource.MisfitResource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;


public class MisfitDeviceResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private static String API_ENDPOINT = "move/resource/v1/user/me/device";

    public MisfitDeviceResource(UriInfo uriInfo, Request request) {
        this.uriInfo = uriInfo;
        this.request = request;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return MisfitResource.getResponse(uriInfo, API_ENDPOINT);
    }

}
