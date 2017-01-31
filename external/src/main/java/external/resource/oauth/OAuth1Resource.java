package external.resource.oauth;

import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import external.entity.OAuthToken;
import external.oauth.FatsecretAuthService;
import org.glassfish.jersey.client.oauth1.AccessToken;
import org.glassfish.jersey.client.oauth1.OAuth1AuthorizationFlow;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.net.URI;
import java.time.Instant;
import java.util.concurrent.ExecutionException;

/**
 * User will be redirected back to this resource after he/she grants access to our application.
 */
@Path("oauth")
public class OAuth1Resource {
    @Context
    private UriInfo uriInfo;

    private Response authorize(String verifier, String redirectPath) {
        try {
            /*
            OAuth10aService flow = FatsecretAuthService.getFlow();
            final OAuth1AccessToken accessToken = flow.getAccessToken(FatsecretAuthService.getRequestToken(), verifier);
            FatsecretAuthService.setAccessToken(accessToken);
*/

            OAuth1AuthorizationFlow flow = FatsecretAuthService.getFlow();
            AccessToken accessToken = flow.finish(verifier);


            OAuthToken token = new OAuthToken()
                    .setUser("user")
                    .setProvider("fatsecret")
                    .setPublicToken(accessToken.getToken())
                    .setPrivateToken(accessToken.getAccessTokenSecret())
                    .setTimestampCreated(Instant.now().toEpochMilli())
                    .create();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Authorization is finished -> now redirect back to the resource
        URI uri = UriBuilder.fromUri(uriInfo.getBaseUri()).path(redirectPath).build();
        return Response.seeOther(uri).build();
    }

    @GET
    @Path("authorize/fatsecret/food-diary")
    public Response authorizeFatsecretFoodEntry(@QueryParam("oauth_token") String requestToken, @QueryParam("oauth_verifier") String verifier) {
        return authorize(verifier, "fatsecret/food-diary");
    }

    @GET
    @Path("authorize/fatsecret/food-diary/month")
    public Response authorizeFatsecretFoodEntryMonth(@QueryParam("oauth_token") String requestToken, @QueryParam("oauth_verifier") String verifier) {
        return authorize(verifier, "fatsecret/food-diary/month");
    }


}
