package external.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import external.dao.ExternalProviderDao;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="OAuthToken")
@NamedQueries({
        @NamedQuery(
                name="OAuthToken.find",
                query="SELECT t FROM OAuthToken t " +
                        "WHERE t.user_id = :user_id AND t.provider = :provider " +
                        "ORDER BY t.timestamp_created DESC"
        )
})
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
    private int token_id;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "provider")
    private String provider;

    @Column(name = "public_token")
    private String public_token;

    @Column(name = "private_token")
    private String private_token;

    @Column(name = "timestamp_created")
    private long timestamp_created;

    // empty constructor needed for deserialization by JAXB
    public OAuthToken() {
    }

    public int getTokenId() {
        return token_id;
    }

    public void setTokenId(int token_id) {
        this.token_id = token_id;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPublicToken() {
        return public_token;
    }

    public void setPublicToken(String public_token) {
        this.public_token = public_token;
    }

    public String getPrivateToken() {
        return private_token;
    }

    public void setPrivateToken(String private_token) {
        this.private_token = private_token;
    }

    public long getTimestampCreated() {
        return timestamp_created;
    }

    public void setTimestampCreated(long timestamp_created) {
        this.timestamp_created = timestamp_created;
    }

    public static OAuthToken find(String user, String provider) {
        OAuthToken entity = null;
        EntityManager em = ExternalProviderDao.createEntityManager();
        if (em != null) {
            List<OAuthToken> resultList = em.createNamedQuery("OAuthToken.find")
                    .setParameter("user_id", user)
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
