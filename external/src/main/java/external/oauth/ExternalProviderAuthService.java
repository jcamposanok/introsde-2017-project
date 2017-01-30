package external.oauth;


public class ExternalProviderAuthService {
    private static ExternalProviderAuthService instance = null;

    protected static String apiName = "";
    protected static String resourceName = "";

    public static String getApiName() {
        return apiName;
    }

    public static void setApiName(String apiName) {
        ExternalProviderAuthService.apiName = apiName;
    }

    public static String getResourceName() {
        return resourceName;
    }

    public static void setResourceName(String resourceName) {
        ExternalProviderAuthService.resourceName = resourceName;
    }

    public static ExternalProviderAuthService getInstance() {
        if (instance == null) {
            instance = new ExternalProviderAuthService();
        }
        return instance;
    }
}
