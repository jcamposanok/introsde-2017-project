package external.resource.misfit;

import external.resource.misfit.activity.MisfitActivityGoalsResource;
import external.resource.misfit.activity.MisfitActivitySummaryResource;
import external.oauth.MisfitAuthService;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;


public class MisfitActivityResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private static String RESOURCE_NAME = "activity";

    public MisfitActivityResource(UriInfo uriInfo, Request request) {
        MisfitAuthService.setResourceName(RESOURCE_NAME);
        this.uriInfo = uriInfo;
        this.request = request;
    }

    @Path("summary")
    public MisfitActivitySummaryResource getMisfitActivitySummaryResource() {
        return new MisfitActivitySummaryResource(uriInfo, request);
    }

    @Path("goals")
    public MisfitActivityGoalsResource getMisfitActivityGoalsResource() {
        return new MisfitActivityGoalsResource(uriInfo, request);
    }

}
