package br.com.dio.storefront.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 * DTO de resposta representando um produto disponível na vitrine.
 * <p>
 * Usado para listar produtos ativos ao cliente.
 *
 * @param id   Identificador único do produto
 * @param name Nome do produto
 */
public record ProductAvailableResponse(
        @JsonProperty("id")
        UUID id,

        @JsonProperty("name")
        String name
) {}
