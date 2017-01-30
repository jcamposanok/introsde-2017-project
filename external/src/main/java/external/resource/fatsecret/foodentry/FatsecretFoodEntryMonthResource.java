package external.resource.fatsecret.foodentry;

import external.oauth.FatsecretAuthService;
import external.resource.FatsecretResource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;
import java.util.HashMap;
import java.util.Map;


public class FatsecretFoodEntryMonthResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private static String RESOURCE_NAME = "food-diary/month";
    private static String METHOD = "food_entries.get_month";

    public FatsecretFoodEntryMonthResource(UriInfo uriInfo, Request request) {
        FatsecretAuthService.setResourceName(RESOURCE_NAME);
        this.uriInfo = uriInfo;
        this.request = request;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("date") String date) {
        Map<String, String> params = new HashMap<>();
        int dateDays = FatsecretResource.parseDaysCountFromDateString(date);
        if (dateDays > 0) {
            params.put("date", String.valueOf(dateDays));
        }
        return FatsecretResource.getResponse(uriInfo, METHOD, params);
    }

}
