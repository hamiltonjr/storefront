package br.com.dio.storefront.service;

import br.com.dio.storefront.dto.StockStatusMessage;

/**
 * Interface para consumo de mensagens de alteração de disponibilidade de produtos.
 * <p>
 * Normalmente usada para processar eventos de RabbitMQ ou outro broker de mensagens.
 */
public interface IProductChangeAvailabilityConsumer {

    /**
     * Recebe uma mensagem de status de estoque e processa a alteração de disponibilidade do produto.
     *
     * @param message Mensagem contendo o identificador do produto e seu status
     */
    void receive(final StockStatusMessage message);
}
