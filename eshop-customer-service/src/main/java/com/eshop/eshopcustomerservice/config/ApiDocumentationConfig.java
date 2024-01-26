package com.eshop.eshopcustomerservice.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "E-Shop Customer Service Rest APIs",
                description = "E-Shop Customer Service Rest API documentation",
                version = "1.0.0",
                contact = @Contact(
                        name = "Sathish Sampath",
                        email = "sathishsmpth@gmail.com",
                        url = "https://sathish.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://sathish.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "E-Shop Core Service docs",
                url = "http://localhost:9001/swagger-ui/index.html"
        )
)
@Configuration
public class ApiDocumentationConfig {
}
