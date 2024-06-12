package lt.viko.eif.siroochenko.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig is a configuration class for setting up CORS (Cross-Origin Resource Sharing) in the application.
 * This configuration class defines the CORS policy, specifying which origins, methods, and headers are allowed.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configures CORS mappings.
     * This method allows CORS requests to all endpoints from the specified origin, with the specified methods and headers.
     *
     * @param registry the CorsRegistry to add the CORS mappings to.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:7777")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
