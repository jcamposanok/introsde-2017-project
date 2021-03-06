package external.resource.oauth;

import java.net.URI;
import java.time.Instant;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import external.entity.OAuthToken;
import external.oauth.MisfitAuthService;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.TokenResult;

/**
 * User will be redirected back to this resource after he/she grants access to our application.
 */
@Path("oauth2")
public class OAuth2Resource {
    @Context
    private UriInfo uriInfo;

    private Response authorize(String code, String state, String redirectPath) {
        OAuth2CodeGrantFlow flow = MisfitAuthService.getFlow();
        TokenResult tokenResult = flow.finish(code, state);

        MisfitAuthService.setAccessToken(tokenResult.getAccessToken());

        OAuthToken token = new OAuthToken();
        token.setUserId("user"); // TODO: Implement different users
        token.setProvider("misfit");
        token.setPrivateToken(tokenResult.getAccessToken());
        token.setTimestampCreated(Instant.now().toEpochMilli());
        token.create();

        // Authorization is finished -> now redirect back to the resource
        URI uri = UriBuilder.fromUri(uriInfo.getBaseUri()).path(redirectPath).build();
        return Response.seeOther(uri).build();
    }

    @GET
    @Path("authorize/misfit/user")
    public Response authorizeMisfitUser(@QueryParam("code") String code, @QueryParam("state") String state) {
        return authorize(code, state, "misfit/user");
    }

    @GET
    @Path("authorize/misfit/device")
    public Response authorizeMisfitDevice(@QueryParam("code") String code, @QueryParam("state") String state) {
        return authorize(code, state, "misfit/device");
    }

    @GET
    @Path("authorize/misfit/activity")
    public Response authorizeMisfitActivity(@QueryParam("code") String code, @QueryParam("state") String state) {
        return authorize(code, state, "misfit/activity");
    }

    @GET
    @Path("authorize/misfit/activity/summary")
    public Response authorizeMisfitActivitySummary(@QueryParam("code") String code, @QueryParam("state") String state) {
        return authorize(code, state, "misfit/activity/summary");
    }

    @GET
    @Path("authorize/misfit/activity/goals")
    public Response authorizeMisfitActivityGoals(@QueryParam("code") String code, @QueryParam("state") String state) {
        return authorize(code, state, "misfit/activity/goals");
    }

}
