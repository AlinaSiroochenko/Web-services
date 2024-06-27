package lt.viko.eif.siroochenko.restaurantconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Configuration class for setting up the Restaurant client and marshaller.
 */
@Configuration
public class RestaurantConfiguration {

    /**
     * Creates and configures a Jaxb2Marshaller for the specified context path.
     * @return The configured Jaxb2Marshaller.
     */
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("lt.viko.eif.siroochenko.restaurantconsumer.wsdl");
        return marshaller;
    }

    /**
     * Creates a RestaurantClient bean and injects the Jaxb2Marshaller into it.
     * @param marshaller The Jaxb2Marshaller used for marshalling and unmarshalling.
     * @return The configured RestaurantClient.
     */
    @Bean
    public RestaurantClient restaurantClient(Jaxb2Marshaller marshaller) {
        RestaurantClient restaurantClient = new RestaurantClient();
        restaurantClient.setDefaultUri("http://localhost:8080/ws");
        restaurantClient.setMarshaller(marshaller);
        restaurantClient.setUnmarshaller(marshaller);
        return restaurantClient;
    }
}
