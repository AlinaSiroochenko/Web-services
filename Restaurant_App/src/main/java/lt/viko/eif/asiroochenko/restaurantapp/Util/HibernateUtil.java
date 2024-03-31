package lt.viko.eif.asiroochenko.restaurantapp.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * The HibernateUtil class provides utility methods for managing Hibernate SessionFactory.
 * It initializes the Hibernate SessionFactory based on the configuration provided in the hibernate.cfg.xml file.
 * It also provides a method to shut down the SessionFactory when it's no longer needed.
 */
public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    /**
     * Retrieves the Hibernate SessionFactory.
     *
     * @return The Hibernate SessionFactory.
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create a new StandardServiceRegistry using the configurations from hibernate.cfg.xml
                registry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources sources = new MetadataSources(registry);
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch(Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    /**
     * Shuts down the Hibernate SessionFactory.
     */
    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
