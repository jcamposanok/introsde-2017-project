package it.unitn.introsde.ehealth.dao;


import it.unitn.introsde.ehealth.dao.util.HerokuDatabaseUrlParser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@WebListener
public class ExternalProviderDao implements ServletContextListener {

    private static String DEFAULT_DB_URL = "jdbc:sqlite:%s/db/db.sqlite";
    private static String PERSISTENCE_UNIT = "ExternalProviderPersistenceUnit";

    private static EntityManagerFactory emf; // Singleton

    public ExternalProviderDao() {
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        String databaseUrl = System.getenv("DATABASE_URL");  // This is available in Heroku

        // Read the properties file to get the base directory and db path
        if (databaseUrl == null) {
            // Local DB
            String basedir;
            Properties props = new Properties();
            URL url = this.getClass().getClassLoader().getResource("project.properties");
            String db = DEFAULT_DB_URL;
            try {
                props.load(url.openStream());
                basedir = props.getProperty("project.basedir");
                db = props.getProperty("project.db");

            } catch (IOException e) {
                e.printStackTrace();
                basedir = "";
            }
            databaseUrl = String.format(db, basedir);
            System.out.println("Use default config in persistence.xml with " + databaseUrl);
        }

        Map<String, String> properties = new HashMap<>();
        HerokuDatabaseUrlParser analyser = new HerokuDatabaseUrlParser(databaseUrl);

        // Set the db access credentials
        System.out.println("SET JDBC URL TO " + analyser.getJdbcUrl());
        properties.put("javax.persistence.jdbc.url", analyser.getJdbcUrl());
        properties.put("javax.persistence.jdbc.user", analyser.getUserName());
        properties.put("javax.persistence.jdbc.password", analyser.getPassword());

        // Set the appropriate JDBC driver
        if ("postgres".equals(analyser.getDbVendor())) {
            System.out.println("SET DRIVER FOR postgres");
            properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        } else if ("sqlite".equals(analyser.getDbVendor())) {
            System.out.println("SET DRIVER FOR sqlite");
            properties.put("javax.persistence.jdbc.driver", "org.sqlite.JDBC");
        }

        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        emf.close();
    }

    public static EntityManager createEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("Context is not initialized yet.");
        }
        try {
            return emf.createEntityManager();
        } catch (Exception e) {
            throw e;
        }
    }

}
