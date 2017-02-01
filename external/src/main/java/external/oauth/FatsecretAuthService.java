package external.oauth;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.SignatureType;
import com.github.scribejava.core.oauth.OAuth10aService;
import org.glassfish.jersey.client.oauth1.ConsumerCredentials;
import org.glassfish.jersey.client.oauth1.OAuth1AuthorizationFlow;
import org.glassfish.jersey.client.oauth1.OAuth1ClientSupport;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class FatsecretAuthService extends ExternalProviderAuthService {

    private static String CONSUMER_KEY = "442a0eadd6e54a56b103d43181e83482";
    private static String CONSUMER_SECRET = "d0b8e71af4ef4eff90f7670bdfa72197";

    private static OAuth1AccessToken accessToken = null;

    // private static OAuth10aService flow;
    private static OAuth1RequestToken requestToken;

    private static String REDIRECT_PATH = "oauth/authorize";


    public static ConsumerCredentials getConsumerCredentials() {
        return consumerCredentials;
    }

    private static ConsumerCredentials consumerCredentials = new ConsumerCredentials(CONSUMER_KEY, CONSUMER_SECRET);

    public static OAuth1AuthorizationFlow getFlow() {
        return flow;
    }

    private static OAuth1AuthorizationFlow flow = OAuth1ClientSupport
            .builder(consumerCredentials)
            .authorizationFlow(
                "http://www.fatsecret.com/oauth/request_token",
                "http://www.fatsecret.com/oauth/access_token",
                "http://www.fatsecret.com/oauth/authorize"
            ).build();

    public static OAuth10aService getService() {
        return service;
    }

    private static OAuth10aService service = new ServiceBuilder()
            .apiKey(CONSUMER_KEY)
            .apiSecret(CONSUMER_SECRET)
            .signatureType(SignatureType.QueryString)
            .build(FatsecretApi.instance());


/*
    public static OAuth10aService getFlow() {
        if (flow == null) {
            getFlow("");
        }
        return flow;
    }

    public static OAuth10aService getFlow(String callbackUri) {
        if (flow == null) {
            ServiceBuilder serviceBuilder = new ServiceBuilder()
                    .apiKey(CONSUMER_KEY)
                    .apiSecret(CONSUMER_SECRET);
            if (callbackUri != "") {
                serviceBuilder = serviceBuilder.callback(callbackUri);
            }
            flow = serviceBuilder
                    .signatureType(SignatureType.QueryString)
                    .build(FatsecretApi.instance());
        }
        return flow;
    }
        */

    public static OAuth1RequestToken getRequestToken() {
        return requestToken;
    }

    public static OAuth1AccessToken getAccessToken() {
        return accessToken;
    }
    public static void setAccessToken(OAuth1AccessToken accessToken) {
        FatsecretAuthService.accessToken = accessToken;
    }

    public static Response getAuthRedirectResponse(UriInfo uriInfo) {//throws InterruptedException, ExecutionException, IOException {
        String callbackUri = UriBuilder
                .fromUri(uriInfo.getBaseUri())
                .path(REDIRECT_PATH).path(apiName).path(resourceName).build().toString();

        OAuth10aService authFlow = new ServiceBuilder()
                .apiKey(CONSUMER_KEY)
                .apiSecret(CONSUMER_SECRET)
                .callback(callbackUri)
                .signatureType(SignatureType.QueryString)
                .build(FatsecretApi.instance());

        String authorizationUri;
        try {
            requestToken = authFlow.getRequestToken();
            authorizationUri = authFlow.getAuthorizationUrl(requestToken);
        }
        catch (Exception e) {
            authorizationUri = flow.start();
        }

        // redirect user to authorization URI
        return Response.seeOther(UriBuilder.fromUri(authorizationUri).build()).build();
    }

}
