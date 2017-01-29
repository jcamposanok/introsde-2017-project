package it.unitn.introsde.data.resource;

import it.unitn.introsde.data.resource.fatsecret.FatsecretFoodEntryResource;
import it.unitn.introsde.data.resource.misfit.MisfitUserResource;
import it.unitn.introsde.data.resource.misfit.activity.MisfitActivityGoalsResource;
import it.unitn.introsde.data.resource.misfit.activity.MisfitActivitySummaryResource;
import it.unitn.introsde.data.resource.oauth.OAuth1Resource;
import it.unitn.introsde.data.resource.oauth.OAuth2Resource;
import it.unitn.introsde.data.resource.fatsecret.foodentry.FatsecretFoodEntryMonthResource;
import it.unitn.introsde.data.resource.misfit.MisfitActivityResource;
import it.unitn.introsde.data.resource.misfit.MisfitDeviceResource;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import java.util.logging.Logger;

@ApplicationPath("/")
public class ResourceLoader extends ResourceConfig {

    public ResourceLoader() {
        register(OAuth1Resource.class);
        register(OAuth2Resource.class);

        // Google Fit
        register(FitnessResource.class);

        // Fatsecret
        register(FatsecretResource.class); // fatsecret
        register(FatsecretFoodEntryResource.class); // fatsecret/food-entry [(date, food_entry_id)+]
        register(FatsecretFoodEntryMonthResource.class); // fatsecret/food-entry/month [date?]

        // Misfit
        register(MisfitResource.class); // misfit
        register(MisfitDeviceResource.class); // misfit/device
        register(MisfitUserResource.class); // misfit/user
        register(MisfitActivityResource.class); // misfit/activity
        register(MisfitActivitySummaryResource.class); // misfit/activity/summary [start, end]
        register(MisfitActivityGoalsResource.class); // misfit/activity/goals [start, end]

        // register(MustacheMvcFeature.class);
        // property(MustacheMvcFeature.TEMPLATE_BASE_PATH, "/mustache");

        register(new LoggingFeature(Logger.getLogger("example.server"), LoggingFeature.Verbosity.PAYLOAD_ANY));
    }

}