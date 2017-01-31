package external.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import external.dao.ExternalProviderDao;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="OAuthToken")
@NamedQueries({
        @NamedQuery(
                name="OAuthToken.find",
                query="SELECT t FROM OAuthToken t " +
                        "WHERE t.user = :user AND t.provider = :provider " +
                        "ORDER BY t.timestampCreated DESC"
        )
})
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class OAuthToken implements Serializable {

    @Id
    @GeneratedValue(generator = "OAuthToken", strategy = GenerationType.TABLE)
    @TableGenerator(name = "OAuthToken",
            table = "Sequence",
            pkColumnName = "name",
            pkColumnValue = "OAuthToken",
            valueColumnName = "seq",
            initialValue = 1,
            allocationSize = 100)
    private int tokenId;

    @Column(name = "user")
    private String user;

    @Column(name = "provider")
    private String provider;

    @Column(name = "publicToken")
    private String publicToken;

    @Column(name = "privateToken")
    private String privateToken;

    @Column(name = "timestampCreated")
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


    public static OAuthToken find(String user, String provider) {
        OAuthToken entity = null;
        EntityManager em = ExternalProviderDao.createEntityManager();
        if (em != null) {
            List<OAuthToken> resultList = em.createNamedQuery("OAuthToken.find")
                    .setParameter("user", user)
                    .setParameter("provider", provider)
                    .getResultList();
            if (resultList != null && resultList.size() > 0) {
                entity = resultList.get(0);
            }
            em.close();
        }
        return entity;
    }

    public OAuthToken create() {
        EntityManager em = ExternalProviderDao.createEntityManager();
        if (em != null) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(this);
            tx.commit();
            em.close();
        }
        return this;
    }
}
