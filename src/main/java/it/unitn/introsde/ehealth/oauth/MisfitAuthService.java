package it.unitn.introsde.ehealth.oauth;

import org.glassfish.jersey.client.oauth2.ClientIdentifier;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;



public class MisfitAuthService {

    private static String accessToken = null;

    private static String apiName = "";
    private static String resourceName = "";

    private static OAuth2CodeGrantFlow flow;
    private static ClientIdentifier clientIdentifier;

    private static String REDIRECT_PATH = "oauth2/authorize";


    public static String getApiName() {
        return apiName;
    }
    public static void setApiName(String apiName) {
        MisfitAuthService.apiName = apiName;
    }

    public static String getResourceName() {
        return resourceName;
    }
    public static void setResourceName(String resourceName) {
        MisfitAuthService.resourceName = resourceName;
    }

    public static String getAccessToken() {
        return accessToken;
    }
    public static void setAccessToken(String accessToken) {
        MisfitAuthService.accessToken = accessToken;
    }

    public static OAuth2CodeGrantFlow getFlow() {
        return flow;
    }

    public static ClientIdentifier getClientIdentifier() {
        return clientIdentifier;
    }
    public static void setClientIdentifier(ClientIdentifier clientIdentifier) {
        MisfitAuthService.clientIdentifier = clientIdentifier;
    }
    public static void setClientIdentifier(String key, String secret) {
        ClientIdentifier clientId = new ClientIdentifier(key, secret);
        setClientIdentifier(clientId);
    }

    public static Response getAuthRedirectResponse(String OAuthUri, String OAuthTokenUri, String OAuthScope, UriInfo uriInfo) {
        String redirectUri = UriBuilder
                .fromUri(uriInfo.getBaseUri())
                .path(REDIRECT_PATH).path(apiName).path(resourceName).build().toString();

        OAuth2CodeGrantFlow.Builder builder =
                OAuth2ClientSupport.authorizationCodeGrantFlowBuilder(
                        MisfitAuthService.getClientIdentifier(),
                        OAuthUri,
                        OAuthTokenUri
                );

        OAuth2CodeGrantFlow flow = builder
                .property(OAuth2CodeGrantFlow.Phase.AUTHORIZATION, "readOnly", "true")
                .scope(OAuthScope)
                .redirectUri(redirectUri)
                .build();

        MisfitAuthService.flow = flow;

        String authorizationUri = flow.start();

        // Redirect user to authorization URI
        return Response.seeOther(UriBuilder.fromUri(authorizationUri).build()).build();
    }

}
