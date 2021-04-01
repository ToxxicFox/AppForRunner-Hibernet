package utils;
import lab2.models.TestEntity;
import lab3.JoinedTable.models.SprinterTraining;
import lab3.JoinedTable.models.Training;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;
import java.io.IOException;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static Logger log = LogManager.getLogger(SessionFactory.class);
    private static final String USER_CONFIG_PATH = System.getenv("config");


    public static SessionFactory getSessionFactory() throws IOException {

        if (sessionFactory == null) {
            // loads configuration and mappings
            String filepath =  (USER_CONFIG_PATH ==null) ? (ConfigurationUtil.getConfigurationEntry("PATH_TO_CFG_XML")) :(USER_CONFIG_PATH);
            log.debug(filepath);
            File file = new File(filepath);
            Configuration configuration = new Configuration().configure(file);
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            MetadataSources metadataSources =
                    new MetadataSources(serviceRegistry);
            addEntities(metadataSources);
            Metadata metadata =  metadataSources.getMetadataBuilder().build();
            sessionFactory =   metadata.getSessionFactoryBuilder().build();
        }

        return sessionFactory;
    }

    private static void addEntities(MetadataSources metadataSources){
        metadataSources.addAnnotatedClass(TestEntity.class);
        //metadataSources.addAnnotatedClass(lab3.JoinedTable.models.Training.class);
        //metadataSources.addAnnotatedClass(lab3.JoinedTable.models.SprinterTraining.class);
        //metadataSources.addAnnotatedClass(lab3.SingleTable.models.Training.class);
        //metadataSources.addAnnotatedClass(lab3.SingleTable.models.SprinterTraining.class);
        //metadataSources.addAnnotatedClass(lab3.TablePerClass.models.Training.class);
        //metadataSources.addAnnotatedClass(lab3.TablePerClass.models.SprinterTraining.class);
    }
}