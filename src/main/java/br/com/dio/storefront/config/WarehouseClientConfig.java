package br.com.dio.storefront.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WarehouseClientConfig {

    /**
     * Bean RestTemplate para comunicação com o microsserviço Warehouse.
     *
     * @param basePath URL base do Warehouse (injetada via application.yml)
     * @return RestTemplate configurado
     */
    @Bean
    public RestTemplate storefrontClient(@Value("${warehouse.base-path}") final String basePath) {
        RestTemplate restTemplate = new RestTemplate();
        // Se quiser, aqui dá pra configurar interceptors ou base URL via UriTemplateHandler
        return restTemplate;
    }

    /**
     * Cria um {@link RestClient} genérico que pode ser injetado em serviços
     * que precisam fazer chamadas HTTP externas.
     *
     * @return uma instância configurada de {@link RestClient}
     */
    @Bean
    public RestClient restClient() {
        return RestClient.create();
    }
}
