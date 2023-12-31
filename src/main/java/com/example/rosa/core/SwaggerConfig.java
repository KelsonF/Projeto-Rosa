package com.example.rosa.core;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI OpenApiConfig(){
        return new OpenAPI().
                info(new Info().title("Project Rosa API")
                        .description("Generic API description")
                        .version("1.0"));
    }
}
