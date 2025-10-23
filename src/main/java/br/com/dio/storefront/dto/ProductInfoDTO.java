package br.com.dio.storefront.dto;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * DTO usado para transferir informações resumidas de um produto.
 * <p>
 * Contém identificador, nome e preço, geralmente usado para listagens ou consultas internas.
 *
 * @param id    Identificador único do produto
 * @param name  Nome do produto
 * @param price Preço do produto
 */
public record ProductInfoDTO(
        UUID id,
        String name,
        BigDecimal price
) {}
