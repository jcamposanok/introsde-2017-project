package external.resource.misfit.activity;

import external.oauth.MisfitAuthService;
import external.resource.MisfitResource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;
import java.util.HashMap;
import java.util.Map;

public class MisfitActivitySummaryResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private static String RESOURCE_NAME = "activity/summary";
    private static String API_ENDPOINT = "/move/resource/v1/user/me/activity/summary";

    public MisfitActivitySummaryResource(UriInfo uriInfo, Request request) {
        MisfitAuthService.setResourceName(RESOURCE_NAME);
        this.uriInfo = uriInfo;
        this.request = request;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("start") String start, @QueryParam("end") String end) {
        Map<String, String> params = new HashMap<>();
        params.put("start_date", start);
        params.put("end_date", end);
        return MisfitResource.getResponse(uriInfo, API_ENDPOINT, params);
    }

}
