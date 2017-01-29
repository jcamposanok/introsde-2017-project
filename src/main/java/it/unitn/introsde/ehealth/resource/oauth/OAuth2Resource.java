package it.unitn.introsde.ehealth.resource.oauth;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import it.unitn.introsde.ehealth.oauth.MisfitAuthService;
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

}
