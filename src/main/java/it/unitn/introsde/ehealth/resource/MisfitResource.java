package it.unitn.introsde.ehealth.resource;

import it.unitn.introsde.ehealth.oauth.MisfitAuthService;
import it.unitn.introsde.ehealth.resource.misfit.MisfitActivitySummaryResource;
import it.unitn.introsde.ehealth.resource.misfit.MisfitDeviceResource;
import it.unitn.introsde.ehealth.resource.misfit.MisfitUserResource;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import java.util.logging.Logger;


@Path("misfit")
public class MisfitResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private static String CLIENT_ID = "9W2mY7duGNzo1Za3";
    private static String CLIENT_SECRET = "KbUzEGAdbSHtGrunz4txkSPtrBkCvpHr";

    private static String API_NAME = "misfit";

    private static String TOKEN_URL = "https://api.misfitwearables.com/auth/tokens/exchange";
    private static String OAUTH_URL = "https://api.misfitwearables.com/auth/dialog/authorize";
    private static String OAUTH_SCOPE = "public,birthday,email,tracking,session,sleep";

    private static String API_ROOT_URL = "https://api.misfitwearables.com/";


    public MisfitResource() {
        MisfitAuthService.setClientIdentifier(CLIENT_ID, CLIENT_SECRET);
        MisfitAuthService.setApiName(API_NAME);
    }

    @Path("user")
    public MisfitUserResource getMisfitUserResource() {
        MisfitAuthService.setResourceName("user");
        return new MisfitUserResource(uriInfo, request);
    }

    @Path("device")
    public MisfitDeviceResource getMisfitDeviceResource() {
        MisfitAuthService.setResourceName("device");
        return new MisfitDeviceResource(uriInfo, request);
    }

    @Path("activity")
    public MisfitActivitySummaryResource getMisfitActivitySummaryResource(
            @QueryParam("start") String start, @QueryParam("end") String end) {
        MisfitAuthService.setResourceName("activity");
        return new MisfitActivitySummaryResource(uriInfo, request, start, end);
    }

    public static Response getResponse(UriInfo uriInfo, String targetPath) {
        // Check access token
        if (MisfitAuthService.getAccessToken() == null) {
            return MisfitAuthService.getAuthRedirectResponse(OAUTH_URL, TOKEN_URL, OAUTH_SCOPE, uriInfo);
        }
        // We have already an access token. Query the data from the API
        Client client = MisfitAuthService.getFlow().getAuthorizedClient();
        return getAuthorizedResponse(client, uriInfo, targetPath);
    }

    private static Response getAuthorizedResponse(Client client, UriInfo uriInfo, String targetPath) {
        client.register(JacksonFeature.class);
        client.register(new LoggingFeature(Logger.getLogger(API_NAME),
                LoggingFeature.Verbosity.PAYLOAD_ANY)
        );

        WebTarget baseTarget = client.target(API_ROOT_URL);
        Response response = baseTarget.path(targetPath).request().get();

        switch (response.getStatus()) {
            case 401: // Response.Status.UNAUTHORIZED
                MisfitAuthService.setAccessToken(null);
                return MisfitAuthService.getAuthRedirectResponse(OAUTH_URL, TOKEN_URL, OAUTH_SCOPE, uriInfo);
            case 200: // Response.Status.OK
                break;
            default:
        }

        return response;
    }
}
