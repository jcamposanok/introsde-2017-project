package it.unitn.introsde.ehealth.resource;


import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;
import it.unitn.introsde.ehealth.oauth.FatsecretAuthService;
import it.unitn.introsde.ehealth.resource.fatsecret.FatsecretFoodEntryResource;
import org.glassfish.jersey.logging.LoggingFeature;

import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
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

    private static String CONSUMER_KEY = "442a0eadd6e54a56b103d43181e83482";
    private static String CONSUMER_SECRET = "d0b8e71af4ef4eff90f7670bdfa72197";

    private static String API_NAME = "fatsecret";

    private static String API_ROOT_URL = "http://platform.fatsecret.com/rest/server.api";


    public FatsecretResource() {
        FatsecretAuthService.setConsumerCredentials(CONSUMER_KEY, CONSUMER_SECRET);
        FatsecretAuthService.setApiName(API_NAME);
    }

    @Path("food-diary")
    public FatsecretFoodEntryResource getFatsecretFoodEntryResource() {
        return new FatsecretFoodEntryResource(uriInfo, request);
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

    public static Response getResponse(UriInfo uriInfo, String method, Map<String, String> params) {
        return getResponse(uriInfo, method, params, "json");
    }

    public static Response getResponse(UriInfo uriInfo, String method, Map<String, String> params, String format) {
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
            for (Map.Entry<String, String> p : params.entrySet()) {
                request.addParameter(p.getKey(), p.getValue());
            }
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
