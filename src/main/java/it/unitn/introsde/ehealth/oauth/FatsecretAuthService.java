package it.unitn.introsde.ehealth.oauth;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.SignatureType;
import com.github.scribejava.core.oauth.OAuth10aService;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class FatsecretAuthService extends ExternalProviderAuthService {

    private static String consumerKey = null;
    private static String consumerSecret = null;

    private static OAuth1AccessToken accessToken = null;

    private static OAuth10aService flow;
    private static OAuth1RequestToken requestToken;

    private static String REDIRECT_PATH = "oauth/authorize";


    public static OAuth10aService getFlow() {
        if (flow == null) {
            getFlow("");
        }
        return flow;
    }

    public static OAuth10aService getFlow(String callbackUri) {
        if (flow == null) {
            ServiceBuilder serviceBuilder = new ServiceBuilder()
                    .apiKey(consumerKey)
                    .apiSecret(consumerSecret);
            if (callbackUri != "") {
                serviceBuilder = serviceBuilder.callback(callbackUri);
            }
            flow = serviceBuilder
                    .signatureType(SignatureType.QueryString)
                    .build(FatsecretApi.instance());
        }
        return flow;
    }

    public static OAuth1RequestToken getRequestToken() {
        return requestToken;
    }

    public static OAuth1AccessToken getAccessToken() {
        return accessToken;
    }
    public static void setAccessToken(OAuth1AccessToken accessToken) {
        FatsecretAuthService.accessToken = accessToken;
    }

    public static void setConsumerCredentials(String consumerKey, String consumerSecret) {
        FatsecretAuthService.consumerKey = consumerKey;
        FatsecretAuthService.consumerSecret = consumerSecret;
    }

    public static Response getAuthRedirectResponse(UriInfo uriInfo) throws InterruptedException, ExecutionException, IOException {
        String callbackUri = UriBuilder
                .fromUri(uriInfo.getBaseUri())
                .path(REDIRECT_PATH).path(apiName).path(resourceName).build().toString();

        flow = getFlow(callbackUri);

        requestToken = flow.getRequestToken();
        final String authorizationUri = flow.getAuthorizationUrl(requestToken);

        // redirect user to authorization URI
        return Response.seeOther(UriBuilder.fromUri(authorizationUri).build()).build();
    }

}
