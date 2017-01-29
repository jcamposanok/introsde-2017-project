package it.unitn.introsde.ehealth.resource;

import com.google.api.services.fitness.Fitness;
import it.unitn.introsde.ehealth.oauth.GoogleAuthService;
import org.glassfish.jersey.server.mvc.Template;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("fitness")
public class FitnessResource {

    Fitness fitness;

    @GET
    @Template(name = "/fitness.mustache")
    @Produces("text/html")
    public Response getStats() throws IOException {
        fitness = GoogleAuthService.getFitnessService();


        String fields = fitness.users().dataSources().list("me").getFields();
        return Response.ok(fields).build();
    }

}
