package lt.viko.eif.siroochenko.restaurant;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The main class that initializes and runs the Restaurant Web Service application.
 */
@SpringBootApplication
public class RestaurantApplication {

    /**
     * The main method to start the application.
     *
     * @param args The command line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }

    /**
     * Creates a bean for ModelMapper, which is used for object mapping.
     *
     * @return An instance of ModelMapper to be used for object mapping.
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
