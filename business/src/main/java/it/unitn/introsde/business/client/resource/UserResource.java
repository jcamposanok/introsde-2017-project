package it.unitn.introsde.business.client.resource;

import it.unitn.introsde.business.client.RestClient;
import it.unitn.introsde.business.client.model.DeviceModel;
import it.unitn.introsde.business.client.model.UserModel;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;


public class UserResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response get() {
        Response misfitUser = RestClient.get("misfit/user", MediaType.APPLICATION_JSON);
        Response misfitDevice = RestClient.get("misfit/device", MediaType.APPLICATION_JSON);

        UserModel user = misfitUser.readEntity(UserModel.class);
        DeviceModel device = misfitDevice.readEntity(DeviceModel.class);
        
        return Response.ok().build();
    }

}
