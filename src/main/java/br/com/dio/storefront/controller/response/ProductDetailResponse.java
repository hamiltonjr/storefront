package br.com.dio.storefront.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO de resposta representando detalhes completos de um produto.
 * <p>
 * Inclui informações como identificador, nome e preço do produto.
 *
 * @param id    Identificador único do produto
 * @param name  Nome do produto
 * @param price Preço do produto
 */
public record ProductDetailResponse(
        @JsonProperty("id")
        UUID id,

        @JsonProperty("name")
        String name,

        @JsonProperty("price")
        BigDecimal price
) {}
