package it.unitn.introsde.ehealth.resource.fatsecret;

import it.unitn.introsde.ehealth.oauth.FatsecretAuthService;
import it.unitn.introsde.ehealth.resource.FatsecretResource;
import it.unitn.introsde.ehealth.resource.fatsecret.foodentry.FatsecretFoodEntryMonthResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;
import java.util.*;


public class FatsecretFoodEntryResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private static String RESOURCE_NAME = "food-diary";
    private static String METHOD = "food_entries.get";

    public FatsecretFoodEntryResource(UriInfo uriInfo, Request request) {
        FatsecretAuthService.setResourceName(RESOURCE_NAME);
        this.uriInfo = uriInfo;
        this.request = request;
    }

    @Path("month")
    public FatsecretFoodEntryMonthResource getFatsecretFoodEntryMonthResource() {
        return new FatsecretFoodEntryMonthResource(uriInfo, request);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("date") String date, @QueryParam("food_entry_id") String food_entry_id) {
        // Fatsecret API: You must specify EITHER date or food_entry_id
        Map<String, String> params = new HashMap<>();
        int dateDays = FatsecretResource.parseDaysCountFromDateString(date);
        if (dateDays > 0) {
            params.put("date", String.valueOf(dateDays));
        }
        else if (food_entry_id != null) {
            params.put("food_entry_id", food_entry_id);
        }
        else {
            return Response.status(400).build();
        }
        return FatsecretResource.getResponse(uriInfo, METHOD, params);
    }

}
