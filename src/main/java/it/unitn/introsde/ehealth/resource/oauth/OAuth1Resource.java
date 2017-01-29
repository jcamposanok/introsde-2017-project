package it.unitn.introsde.ehealth.resource.oauth;

import com.github.scribejava.core.extractors.OAuth1AccessTokenExtractor;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import it.unitn.introsde.ehealth.model.TokenModel;
import it.unitn.introsde.ehealth.oauth.FatsecretAuthService;

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
            OAuth10aService flow = FatsecretAuthService.getFlow();
            final OAuth1AccessToken accessToken = flow.getAccessToken(FatsecretAuthService.getRequestToken(), verifier);
            FatsecretAuthService.setAccessToken(accessToken);

            TokenModel token = new TokenModel()
                    .setUser("user")
                    .setProvider("fatsecret")
                    .setPublicToken(accessToken.getToken())
                    .setPrivateToken(accessToken.getTokenSecret())
                    .setTimestampCreated(Instant.now().toEpochMilli())
                    .create();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
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
