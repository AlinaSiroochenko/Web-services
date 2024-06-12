package lt.viko.eif.siroochenko.rest.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SwaggerConfig is a configuration class for setting up Swagger API documentation.
 * This configuration class sets up a public API group that includes all paths in the application.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Creates a GroupedOpenApi bean for the public API.
     * This bean configures Swagger to document all endpoints in the application.
     *
     * @return a GroupedOpenApi instance configured for the public API.
     */
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("springshop-public")
                .pathsToMatch("/**")
                .build();
    }
}
