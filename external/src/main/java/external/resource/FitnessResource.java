package external.resource;

import com.google.api.services.fitness.Fitness;
import external.oauth.GoogleAuthService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("fitness")
public class FitnessResource {

    Fitness fitness;

    @GET
    @Produces("text/html")
    public Response getStats() throws IOException {
        fitness = GoogleAuthService.getFitnessService();
        String fields = fitness.users().dataSources().list("me").getFields();
        return Response.ok(fields).build();
    }

}
