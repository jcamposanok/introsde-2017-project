package it.unitn.introsde.ehealth.resource.misfit;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

public class MisfitActivitySummaryResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    String startDate;
    String endDate;

    private static String API_ENDPOINT = "/move/resource/v1/user/me/activity/summary";

    public MisfitActivitySummaryResource(UriInfo uriInfo, Request request, String startDate, String endDate) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
