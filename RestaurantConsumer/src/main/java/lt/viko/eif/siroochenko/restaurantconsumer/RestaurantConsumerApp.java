package lt.viko.eif.siroochenko.restaurantconsumer;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The main entry point for the RestaurantConsumer application.
 * This class initializes and starts the Spring Boot application.
 */
@SpringBootApplication
public class RestaurantConsumerApp {

    /**
     * The main method to start the RestaurantConsumer application.
     * @param args The command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(RestaurantConsumerApp.class, args);
    }

    /**
     * Configures and provides a ModelMapper bean for mapping between different object models.
     * @return A ModelMapper bean instance.
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
