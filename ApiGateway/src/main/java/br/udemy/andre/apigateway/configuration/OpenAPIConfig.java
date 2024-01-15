package br.udemy.andre.apigateway.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

// Other import statements...

@Configuration
public class OpenAPIConfig {

    @Bean
    @Lazy(false)
    public List<GroupedOpenApi> apis(
            SwaggerUiConfigParameters config,
            RouteDefinitionLocator locator) {

        var definitions = locator.getRouteDefinitions().collectList().block();
        List<GroupedOpenApi> groupedOpenApis = new ArrayList<>();

        definitions.stream()
                .filter(routeDefinition -> routeDefinition.getId() != null && !routeDefinition.getId().isEmpty())
                .forEach(routeDefinition -> {
                    String name = routeDefinition.getId();
                    config.addGroup(name);
                    GroupedOpenApi groupedOpenApi = GroupedOpenApi.builder()
                            .pathsToMatch("/" + name + "/**")
                            .group(name)
                            .displayName(name)  // Use displayName to set a friendly name in the UI
                            .build();
                    groupedOpenApis.add(groupedOpenApi);
                });

        return groupedOpenApis;
    }

    @Bean
    @Lazy(false)
    public SwaggerUiConfigParameters swaggerUiConfigParameters(SwaggerUiConfigProperties swaggerUiConfigProperties) {
        return new SwaggerUiConfigParameters(swaggerUiConfigProperties);
    }

    @Bean
    @Lazy(false)
    public SwaggerUiConfigProperties swaggerUiConfigProperties() {
        return new SwaggerUiConfigProperties();
    }
}
