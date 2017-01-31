package external.resource.fatsecret;

import external.entity.fatsecret.Month;
import external.entity.fatsecret.MonthWrapper;
import external.oauth.FatsecretAuthService;
import external.resource.FatsecretResource;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response get(@QueryParam("date") String date, @HeaderParam("Accept") String accept) {
        Map<String, String> params = new HashMap<>();
        int dateDays = FatsecretResource.parseDaysCountFromDateString(date);
        if (dateDays > 0) {
            params.put("date", String.valueOf(dateDays));
        }
        String format = FatsecretResource.getFormatStringFromHeader(accept);
        Response response = FatsecretResource.getResponse(uriInfo, METHOD, params, format);
        if (response.getStatus() == 200) {
            if (accept.equals(MediaType.APPLICATION_JSON)) {
                MonthWrapper entity = response.readEntity(MonthWrapper.class);
                return Response.ok(entity).build();
            }
            else {
                Month entity = response.readEntity(Month.class);
                return Response.ok(entity).build();
            }
        }
        return response;
    }

}
