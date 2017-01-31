package external.resource;

import external.resource.misfit.MisfitUserResource;
import external.entity.OAuthToken;
import external.oauth.MisfitAuthService;
import external.resource.misfit.MisfitActivityResource;
import external.resource.misfit.MisfitDeviceResource;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;

import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import java.util.HashMap;
import java.util.Map;
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
        return new MisfitUserResource(uriInfo, request);
    }

    @Path("device")
    public MisfitDeviceResource getMisfitDeviceResource() {
        return new MisfitDeviceResource(uriInfo, request);
    }

    @Path("activity")
    public MisfitActivityResource getMisfitActivityResource() {
        return new MisfitActivityResource(uriInfo, request);
    }

    public static Response getResponse(UriInfo uriInfo, String targetPath) {
        return getResponse(uriInfo, targetPath, new HashMap<String, String>());
    }

    public static Response getResponse(UriInfo uriInfo, String targetPath, Map<String, String> queryParams) {
        Client client = ClientBuilder.newClient();

        // Check access token
        OAuthToken token = OAuthToken.find("user", "misfit");
        if (token != null && token.getPrivateToken() != null) {
            String accessToken = token.getPrivateToken();
            MisfitAuthService.setAccessToken(accessToken);

            Feature filterFeature = OAuth2ClientSupport.feature(accessToken);
            client = client.register(filterFeature);
        }
        if (MisfitAuthService.getAccessToken() == null) {
            return MisfitAuthService.getAuthRedirectResponse(OAUTH_URL, TOKEN_URL, OAUTH_SCOPE, uriInfo);
        }
        // We have already an access token. Query the external from the API
        return getAuthorizedResponse(client, uriInfo, targetPath, queryParams);
    }

    private static Response getAuthorizedResponse(Client client, UriInfo uriInfo, String targetPath, Map<String, String> queryParams) {
        client.register(JacksonFeature.class);
        client.register(new LoggingFeature(Logger.getLogger(API_NAME),
                LoggingFeature.Verbosity.PAYLOAD_ANY)
        );

        WebTarget webTarget = client.target(API_ROOT_URL).path(targetPath);
        for (Map.Entry<String, String> p : queryParams.entrySet()) {
            webTarget = webTarget.queryParam(p.getKey(), p.getValue());
        }
        final Response response = webTarget.request().get();

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
