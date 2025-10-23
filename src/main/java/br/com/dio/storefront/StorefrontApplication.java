package br.com.dio.storefront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal do microsserviço Storefront.
 * <p>
 * Inicializa o contexto Spring Boot e sobe a aplicação web na porta configurada.
 */
@SpringBootApplication
public class StorefrontApplication {

    /**
     * Método principal que inicia a aplicação.
     *
     * @param args Argumentos da linha de comando (opcional)
     */
    public static void main(String[] args) {
        SpringApplication.run(StorefrontApplication.class, args);
    }
}
