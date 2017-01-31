package external.resource.fatsecret;

import external.entity.fatsecret.FoodEntries;
import external.entity.fatsecret.FoodEntriesWrapper;
import external.entity.fatsecret.FoodEntry;
import external.oauth.FatsecretAuthService;
import external.resource.FatsecretResource;

import javax.ws.rs.*;
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
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response get(@QueryParam("date") String date, @QueryParam("food_entry_id") String food_entry_id, @HeaderParam("Accept") String accept) {
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
        String format = FatsecretResource.getFormatStringFromHeader(accept);
        Response response = FatsecretResource.getResponse(uriInfo, METHOD, params, format);
        if (response.getStatus() == 200) {
            if (accept.equals(MediaType.APPLICATION_JSON)) {
                FoodEntriesWrapper entity = response.readEntity(FoodEntriesWrapper.class);
                return Response.ok(entity).build();
            }
            else {
                FoodEntry entity = response.readEntity(FoodEntry.class);
                return Response.ok(entity).build();
            }
        }
        return response;
    }

}
