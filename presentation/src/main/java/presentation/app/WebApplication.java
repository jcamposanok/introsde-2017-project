package presentation.app;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.mustache.MustacheMvcFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class WebApplication extends ResourceConfig {

  public WebApplication() {
    property(MustacheMvcFeature.TEMPLATE_BASE_PATH, "/templates");
    register(MustacheMvcFeature.class);
    packages("presentation.app.resource");
  }

}
