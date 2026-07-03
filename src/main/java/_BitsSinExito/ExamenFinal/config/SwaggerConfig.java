package _BitsSinExito.ExamenFinal.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Examen Final - Servicios")
                        .version("1.0")
                        .description("Documentación de la API REST para la gestión de servicios (CRUD)")
                        .contact(new Contact().name("7BitsSinExito")));
    }
}
