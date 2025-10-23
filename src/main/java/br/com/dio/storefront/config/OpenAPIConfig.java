package br.com.dio.storefront.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração do OpenAPI (Swagger) para documentação da API do Storefront.
 * <p>
 * Cria um bean OpenAPI com título, versão e descrição da API, permitindo
 * que a documentação seja gerada automaticamente.
 */
@Configuration
public class OpenAPIConfig {

    /**
     * Bean que fornece as informações básicas da API para o Swagger/OpenAPI.
     *
     * @return o objeto OpenAPI com informações da API
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API da Vitrine do E-commerce")
                        .version("1.0")
                        .description("Documentação da API da vitrine do e-commerce."));
    }
}
