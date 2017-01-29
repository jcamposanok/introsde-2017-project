package it.unitn.introsde.ehealth.resource.fatsecret;

import it.unitn.introsde.ehealth.resource.FatsecretResource;
import it.unitn.introsde.ehealth.resource.MisfitResource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;


public class FatsecretFoodResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private static String METHOD = "food_entries.get_month";

    public FatsecretFoodResource(UriInfo uriInfo, Request request) {
        this.uriInfo = uriInfo;
        this.request = request;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return FatsecretResource.getResponse(uriInfo, METHOD);
    }

}
