package integration.client.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class OAuthToken {

    private int tokenId;

    private String user;

    private String provider;

    private String publicToken;

    private String privateToken;

    private long timestampCreated;

    // empty constructor needed for deserialization by JAXB
    public OAuthToken() {
    }

    @XmlElement
    public int getTokenId() {
        return tokenId;
    }

    public OAuthToken setTokenId(int tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    @XmlElement
    public String getUser() {
        return user;
    }

    public OAuthToken setUser(String user) {
        this.user = user;
        return this;
    }

    @XmlElement
    public String getProvider() {
        return provider;
    }

    public OAuthToken setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    @XmlElement
    public String getPublicToken() {
        return publicToken;
    }

    public OAuthToken setPublicToken(String publicToken) {
        this.publicToken = publicToken;
        return this;
    }

    @XmlElement
    public String getPrivateToken() {
        return privateToken;
    }

    public OAuthToken setPrivateToken(String privateToken) {
        this.privateToken = privateToken;
        return this;
    }

    @XmlElement
    public long getTimestampCreated() {
        return timestampCreated;
    }

    public OAuthToken setTimestampCreated(long timestampCreated) {
        this.timestampCreated = timestampCreated;
        return this;
    }

}
