package lab5.utils;

import lab5.models.Challenge;
import lab5.models.Runner;
import lab5.models.Training;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

public class HibernateUtil {

    private static final String CUSTOM_CONFIG_PATH = System.getProperty("hibernatePath");

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration;
            if (CUSTOM_CONFIG_PATH != null) {
                configuration = new Configuration().configure(new File(CUSTOM_CONFIG_PATH));
            } else {
                configuration = new Configuration();
            }
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            MetadataSources metadataSources =
                    new MetadataSources(serviceRegistry);
            metadataSources.addAnnotatedClass(Runner.class);
            metadataSources.addAnnotatedClass(Challenge.class);
            metadataSources.addAnnotatedClass(Training.class);
            sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        }

        return sessionFactory;
    }
}