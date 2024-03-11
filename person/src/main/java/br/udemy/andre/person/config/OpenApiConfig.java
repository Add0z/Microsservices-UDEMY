package br.udemy.andre.person.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApiCustom() {
        return new OpenAPI()
                .info(new Info()
                .title("Person API")
                .version("v1")
                .description("Person API reference for developers")
                .termsOfService("http://swagger.io/terms/")
                .license(new io.swagger.v3.oas.models.info.License()
                    .name("Apache 2.0")
                    .url("http://springdoc.org")
                    )
                );
    }
}
