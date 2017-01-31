package integration.client;

import integration.server.soap.Endpoint;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class RestClient {

    private static String dataApi = "";
    private static WebTarget service;

    static {
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        service = client.target(getDataApi());
    }

    public static String getDataApi() {
        if (dataApi == "") {
            Properties props = new Properties();
            URL propFileUrl = Endpoint.class.getClassLoader().getResource("project.properties");
            try {
                props.load(propFileUrl.openStream());
                dataApi = props.getProperty("project.data.api");
            } catch (IOException e) {
                e.printStackTrace();
                dataApi = "";
            }
        }
        dataApi = (dataApi.charAt(dataApi.length() - 1) == '/') ? dataApi + "/" : dataApi;
        System.out.println("Data layer REST API URL set to " + dataApi);
        return dataApi;
    }

    public static WebTarget getService() {
        return service;
    }

    public static Response get(String path, String mediaType, Map<String, Object> params) {
        WebTarget target = service.path(path);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            target = target.queryParam(entry.getKey(), entry.getValue());
        }
        Response res = target.request(mediaType).accept(mediaType).get();
        res.bufferEntity(); // To use readEntity multiple times
        return res;
    }

    public static Response get(String path, String mediaType) {
        return get(path, mediaType, new HashMap<String, Object>());
    }

}
