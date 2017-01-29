package it.unitn.introsde.data.resource.misfit;

import it.unitn.introsde.data.oauth.MisfitAuthService;
import it.unitn.introsde.data.resource.MisfitResource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;


public class MisfitUserResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private static String RESOURCE_NAME = "user";
    private static String API_ENDPOINT = "move/resource/v1/user/me/profile";

    public MisfitUserResource(UriInfo uriInfo, Request request) {
        MisfitAuthService.setResourceName(RESOURCE_NAME);
        this.uriInfo = uriInfo;
        this.request = request;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return MisfitResource.getResponse(uriInfo, API_ENDPOINT);
    }

}
