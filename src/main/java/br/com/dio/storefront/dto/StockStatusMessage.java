package br.com.dio.storefront.dto;

import java.util.UUID;

/**
 * DTO usado para transmitir o status de estoque de um produto.
 * <p>
 * Contém o identificador do produto e o status (ex: "AVAILABLE", "OUT_OF_STOCK").
 *
 * @param id     Identificador único do produto
 * @param status Status do estoque do produto
 */
public record StockStatusMessage(
        UUID id,
        String status
) {

    /**
     * Verifica se o produto está ativo/ disponível em estoque.
     *
     * @return true se o status for "AVAILABLE", false caso contrário
     */
    public boolean active() {
        return "AVAILABLE".equals(status);
    }
}
