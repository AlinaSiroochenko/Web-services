package lt.viko.eif.siroochenko.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the REST application.
 * This class uses the Spring Boot framework to bootstrap and launch the application.
 */
@SpringBootApplication
public class RestApp {

    /**
     * The entry point of the REST application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(RestApp.class, args);
    }
}
