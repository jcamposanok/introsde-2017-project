package external.resource.misfit;

import external.entity.misfit.MisfitActivityGoalList;
import external.oauth.MisfitAuthService;
import external.resource.MisfitResource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;
import java.util.HashMap;
import java.util.Map;

public class MisfitActivityGoalsResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private static String RESOURCE_NAME = "activity/goals";
    private static String API_ENDPOINT = "/move/resource/v1/user/me/activity/goals";

    public MisfitActivityGoalsResource(UriInfo uriInfo, Request request) {
        MisfitAuthService.setResourceName(RESOURCE_NAME);
        this.uriInfo = uriInfo;
        this.request = request;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response get(@QueryParam("start") String start, @QueryParam("end") String end) {
        Map<String, String> params = new HashMap<>();
        params.put("start_date", start);
        params.put("end_date", end);
        Response response =  MisfitResource.getResponse(uriInfo, API_ENDPOINT, params);
        if (response.getStatus() == 200) {
            MisfitActivityGoalList entity = response.readEntity(MisfitActivityGoalList.class);
            return Response.ok(entity).build();
        }
        return response;
    }

}
