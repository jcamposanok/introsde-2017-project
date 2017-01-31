package external.resource;

import external.resource.fatsecret.FatsecretFoodEntryResource;
import external.resource.misfit.MisfitUserResource;
import external.resource.misfit.MisfitActivityGoalsResource;
import external.resource.misfit.MisfitActivitySummaryResource;
import external.resource.oauth.OAuth1Resource;
import external.resource.oauth.OAuth2Resource;
import external.resource.fatsecret.FatsecretFoodEntryMonthResource;
import external.resource.misfit.MisfitActivityResource;
import external.resource.misfit.MisfitDeviceResource;
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
        register(FatsecretFoodEntryResource.class); // fatsecret/food-diary [(date, food_entry_id)+]
        register(FatsecretFoodEntryMonthResource.class); // fatsecret/food-diary/month [date?]

        // Misfit
        register(MisfitResource.class); // misfit
        register(MisfitDeviceResource.class); // misfit/device
        register(MisfitUserResource.class); // misfit/user
        register(MisfitActivityResource.class); // misfit/activity
        register(MisfitActivitySummaryResource.class); // misfit/activity/summary [start, end]
        register(MisfitActivityGoalsResource.class); // misfit/activity/goals [start, end]

        register(new LoggingFeature(Logger.getLogger("external.server"), LoggingFeature.Verbosity.PAYLOAD_ANY));
    }

}
