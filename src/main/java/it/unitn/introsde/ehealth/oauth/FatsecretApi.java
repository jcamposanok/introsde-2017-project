package it.unitn.introsde.ehealth.oauth;

import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.services.SignatureService;

public class FatsecretApi extends DefaultApi10a {

    private static final String AUTHORIZE_URL = "http://www.fatsecret.com/oauth/authorize?oauth_token=%s";

    protected FatsecretApi() {
    }

    private static class InstanceHolder {
        private static final FatsecretApi INSTANCE = new FatsecretApi();
    }

    public static FatsecretApi instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public String getAccessTokenEndpoint(){
        return "http://www.fatsecret.com/oauth/access_token";
    }

    @Override
    public String getRequestTokenEndpoint() {
        return "http://www.fatsecret.com/oauth/request_token";
    }

    @Override
    public String getAuthorizationUrl(OAuth1RequestToken requestToken) {
        return String.format(AUTHORIZE_URL, requestToken.getToken());
    }

    @Override
    public SignatureService getSignatureService() {
        return new FatsecretSignatureService();
    }

    @Override
    public Verb getRequestTokenVerb() {
        return Verb.GET;
    }

    @Override
    public Verb getAccessTokenVerb() {
        return Verb.GET;
    }
}
