package it.unitn.introsde.ehealth.resource.misfit;

import it.unitn.introsde.ehealth.oauth.MisfitAuthService;
import it.unitn.introsde.ehealth.resource.fatsecret.foodentry.FatsecretFoodEntryMonthResource;
import it.unitn.introsde.ehealth.resource.misfit.activity.MisfitActivityGoalsResource;
import it.unitn.introsde.ehealth.resource.misfit.activity.MisfitActivitySummaryResource;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;


public class MisfitActivityResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    private static String RESOURCE_NAME = "activity";

    public MisfitActivityResource(UriInfo uriInfo, Request request) {
        MisfitAuthService.setResourceName(RESOURCE_NAME);
        this.uriInfo = uriInfo;
        this.request = request;
    }

    @Path("summary")
    public MisfitActivitySummaryResource getMisfitActivitySummaryResource() {
        return new MisfitActivitySummaryResource(uriInfo, request);
    }

    @Path("goals")
    public MisfitActivityGoalsResource getMisfitActivityGoalsResource() {
        return new MisfitActivityGoalsResource(uriInfo, request);
    }

}
