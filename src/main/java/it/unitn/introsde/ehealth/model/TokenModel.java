package it.unitn.introsde.ehealth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.unitn.introsde.ehealth.dao.ExternalProviderDao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="TokenModel")
@NamedQueries({
        @NamedQuery(name="TokenModel.find", query="SELECT t FROM TokenModel t WHERE t.user = :user AND t.provider = :provider ORDER BY t.timestampCreated DESC")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenModel implements Serializable {

    @Id
    @GeneratedValue(generator = "TokenModel", strategy = GenerationType.TABLE)
    @TableGenerator(name = "TokenModel",
            table = "Sequence",
            pkColumnName = "name",
            pkColumnValue = "TokenModel",
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

    public TokenModel() {
    }

    public int getTokenId() {
        return tokenId;
    }

    public TokenModel setTokenId(int tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public String getUser() {
        return user;
    }

    public TokenModel setUser(String user) {
        this.user = user;
        return this;
    }

    public String getProvider() {
        return provider;
    }

    public TokenModel setProvider(String provider) {
        this.provider = provider;
        return this;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public TokenModel setPublicToken(String publicToken) {
        this.publicToken = publicToken;
        return this;
    }

    public String getPrivateToken() {
        return privateToken;
    }

    public TokenModel setPrivateToken(String privateToken) {
        this.privateToken = privateToken;
        return this;
    }

    public long getTimestampCreated() {
        return timestampCreated;
    }

    public TokenModel setTimestampCreated(long timestampCreated) {
        this.timestampCreated = timestampCreated;
        return this;
    }


    public static TokenModel find(String user, String provider) {
        TokenModel entity = null;
        EntityManager em = ExternalProviderDao.createEntityManager();
        if (em != null) {
            List<TokenModel> resultList = em.createNamedQuery("TokenModel.find")
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


    public TokenModel create() {
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

    /*
    public TokenModel update() {
        EntityManager em = ExternalProviderDao.createEntityManager();
        TokenModel entity = this;
        if (em != null) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            entity = em.merge(entity);
            tx.commit();
            em.close();
        }
        return entity;
    }
    */
}
