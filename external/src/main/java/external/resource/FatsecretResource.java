package external.resource;


import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;
import external.entity.OAuthToken;
import external.oauth.FatsecretApi;
import external.oauth.FatsecretSignatureService;
import external.oauth.MisfitAuthService;
import external.resource.fatsecret.FatsecretFoodEntryResource;
import external.oauth.FatsecretAuthService;
import org.glassfish.jersey.client.oauth1.AccessToken;
import org.glassfish.jersey.client.oauth1.ConsumerCredentials;
import org.glassfish.jersey.client.oauth1.OAuth1ClientSupport;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.oauth1.signature.*;

import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Path("fatsecret")
public class FatsecretResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private static String API_NAME = "fatsecret";
    private static String API_ROOT_URL = "http://platform.fatsecret.com/rest/server.api";


    public FatsecretResource() {
        FatsecretAuthService.setApiName(API_NAME);
    }

    @Path("food-diary")
    public FatsecretFoodEntryResource getFatsecretFoodEntryResource() {
        return new FatsecretFoodEntryResource(uriInfo, request);
    }

    public static String getFormatStringFromHeader(String accept) {
        String format;
        switch (accept) {
            case "application/json":
                format = "json";
                break;
            case "application/xml":
                format = "xml";
                break;
            default:
                format = "xml";
        }
        return format;
    }

    public static String getHeaderFromFormatString(String format) {
        String accept;
        switch (format) {
            case "json":
                accept = MediaType.APPLICATION_JSON;
                break;
            case "xml":
                accept = MediaType.APPLICATION_XML;
                break;
            default:
                accept = MediaType.APPLICATION_XML;
        }
        return accept;
    }


    public static int parseDaysCountFromDateString(String date) {
        long dateDays = 0;
        if (date != null) {
            // Fatsecret API date param: The number of days since January 1, 1970
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
            String startDate = "1970-01-01";
            try {
                Date date1 = myFormat.parse(startDate);
                Date date2 = myFormat.parse(date);
                long diff = date2.getTime() - date1.getTime();
                dateDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return (int) dateDays;
    }


    public static Response getResponse(UriInfo uriInfo, String method) {
        return getResponse(uriInfo, method, new HashMap<>(), "json");
    }

    public static Response getResponse(UriInfo uriInfo, String method, Map<String, String> queryParams) {
        return getResponse(uriInfo, method,  queryParams, "json");
    }

    public static Response getResponse(UriInfo uriInfo, String method, Map<String, String> queryParams, String format) {
        // Check access token
        String payload = "";

        OAuthToken tokenModel = OAuthToken.find("user", "fatsecret");
        if (tokenModel != null && tokenModel.getPublicToken() != null && tokenModel.getPrivateToken() != null) {
            OAuth1AccessToken accessToken = new OAuth1AccessToken(tokenModel.getPublicToken(), tokenModel.getPrivateToken());
            FatsecretAuthService.setAccessToken(accessToken);
        }

        if (FatsecretAuthService.getAccessToken() == null) {
            try {
                return FatsecretAuthService.getAuthRedirectResponse(uriInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        AccessToken accessToken = new AccessToken(tokenModel.getPublicToken(), tokenModel.getPrivateToken());

        Feature filterFeature = OAuth1ClientSupport
                .builder(FatsecretAuthService.getConsumerCredentials())
                .feature()
                .accessToken(accessToken)
                .build();
        Client client = ClientBuilder.newBuilder().register(filterFeature).build();

        OAuth10aService service = FatsecretAuthService.getService();
        final OAuthRequest request = new OAuthRequest(Verb.GET, API_ROOT_URL);
        request.addParameter("method", method);
        request.addParameter("format", format);
        for (Map.Entry<String, String> p : queryParams.entrySet()) {
            request.addParameter(p.getKey(), p.getValue());
        }
        service.signRequest(FatsecretAuthService.getAccessToken(), request);

        String completeUrl = request.getCompleteUrl();
        WebTarget webTarget = client.target(completeUrl);

        final Response response = webTarget.request(getHeaderFromFormatString(format)).get();

        switch (response.getStatus()) {
            case 401: // Response.Status.UNAUTHORIZED
                FatsecretAuthService.setAccessToken(null);
                return FatsecretAuthService.getAuthRedirectResponse(uriInfo);
            case 200: // Response.Status.OK
                break;
            default:
        }

        return response;



        /*
        else {
            OAuth10aService service = FatsecretAuthService.getFlow();
            final OAuthRequest request = new OAuthRequest(Verb.GET, API_ROOT_URL);
            request.addParameter("method", method);
            request.addParameter("format", format);
            for (Map.Entry<String, String> p : params.entrySet()) {
                request.addParameter(p.getKey(), p.getValue());
            }
            service.signRequest(FatsecretAuthService.getAccessToken(), request);
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
        */
        // We have already an access token. Query the external from the API
        // return getAuthorizedResponse(client, uriInfo, method, queryParams, format);
    }


}
