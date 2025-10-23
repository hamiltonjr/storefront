package br.com.dio.storefront.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO usado internamente no microsserviço Storefront para transferir dados completos de um produto.
 * <p>
 * Contém identificador, nome e preço do produto.
 *
 * @param id    Identificador único do produto
 * @param name  Nome do produto
 * @param price Preço do produto
 */
public record ProductDetailDTO(
        @JsonProperty("id")
        UUID id,

        @JsonProperty("name")
        String name,

        @JsonProperty("price")
        BigDecimal price
) {}
