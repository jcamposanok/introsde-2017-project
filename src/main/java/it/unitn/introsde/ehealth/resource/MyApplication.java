package it.unitn.introsde.ehealth.resource;

import it.unitn.introsde.ehealth.resource.fatsecret.FatsecretFoodResource;
import it.unitn.introsde.ehealth.resource.misfit.MisfitDeviceResource;
import it.unitn.introsde.ehealth.resource.misfit.MisfitUserResource;
import it.unitn.introsde.ehealth.resource.oauth.OAuth1Resource;
import it.unitn.introsde.ehealth.resource.oauth.OAuth2Resource;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.mustache.MustacheMvcFeature;

import javax.ws.rs.ApplicationPath;
import java.util.logging.Logger;

@ApplicationPath("/")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        register(OAuth1Resource.class);
        register(OAuth2Resource.class);

        // Google Fit
        register(FitnessResource.class);

        // Fatsecret
        register(FatsecretResource.class);
        register(FatsecretFoodResource.class);

        // Misfit
        register(MisfitResource.class);
        register(MisfitDeviceResource.class);
        register(MisfitUserResource.class);

        register(MustacheMvcFeature.class);
        property(MustacheMvcFeature.TEMPLATE_BASE_PATH, "/mustache");

        register(new LoggingFeature(Logger.getLogger("example.server"), LoggingFeature.Verbosity.PAYLOAD_ANY));
    }

}
