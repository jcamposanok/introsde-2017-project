package it.unitn.introsde.ehealth.resource;


import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;
import it.unitn.introsde.ehealth.oauth.FatsecretAuthService;
import it.unitn.introsde.ehealth.resource.fatsecret.FatsecretFoodResource;
import org.glassfish.jersey.logging.LoggingFeature;

import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

@Path("fatsecret")
public class FatsecretResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private static String CONSUMER_KEY = "442a0eadd6e54a56b103d43181e83482";
    private static String CONSUMER_SECRET = "d0b8e71af4ef4eff90f7670bdfa72197";

    private static String API_NAME = "fatsecret";

    private static String API_ROOT_URL = "http://platform.fatsecret.com/rest/server.api";


    public FatsecretResource() {
        FatsecretAuthService.setConsumerCredentials(CONSUMER_KEY, CONSUMER_SECRET);
        FatsecretAuthService.setApiName(API_NAME);
    }

    @Path("foods")
    public FatsecretFoodResource getFatsecretFoodResource() {
        FatsecretAuthService.setResourceName("foods");
        return new FatsecretFoodResource(uriInfo, request);
    }

    public static Response getResponse(UriInfo uriInfo, String method) {
        return getResponse(uriInfo, method, "json");
    }

    public static Response getResponse(UriInfo uriInfo, String method, String format) {
        // Check access token
        String payload = "";
        if (FatsecretAuthService.getAccessToken() == null) {
            try {
                return FatsecretAuthService.getAuthRedirectResponse(uriInfo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            OAuth10aService service = FatsecretAuthService.getFlow();
            final OAuthRequest request = new OAuthRequest(Verb.GET, API_ROOT_URL);
            request.addParameter("method", method);
            request.addParameter("format", format);
            service.signRequest(FatsecretAuthService.getAccessToken(), request); // the access token from step 4
            try {
                final com.github.scribejava.core.model.Response serviceResponse = service.execute(request);
                payload = serviceResponse.getBody();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Response.ok(payload).build();
    }

    private static Response getAuthorizedResponse(Client client, UriInfo uriInfo, String method) {
        // client.register(JacksonFeature.class);
        client.register(new LoggingFeature(Logger.getLogger(API_NAME),
                LoggingFeature.Verbosity.PAYLOAD_ANY)
        );

        WebTarget baseTarget = client.target(API_ROOT_URL);
        Response response = baseTarget.queryParam("method", method).request().get();

        switch (response.getStatus()) {
            case 401: // Response.Status.UNAUTHORIZED
                FatsecretAuthService.setAccessToken(null);
                // return FatsecretAuthService.getAuthRedirectResponse(REQUEST_TOKEN_URL, ACCESS_TOKEN_URL, AUTHORIZATION_URL, uriInfo);
            case 200: // Response.Status.OK
                break;
            default:
        }

        return response;
    }
}
