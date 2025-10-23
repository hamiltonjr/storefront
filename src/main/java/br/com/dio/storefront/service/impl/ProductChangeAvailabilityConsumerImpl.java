package br.com.dio.storefront.service.impl;

import br.com.dio.storefront.dto.StockStatusMessage;
import br.com.dio.storefront.service.IProductService;
import br.com.dio.storefront.service.IProductChangeAvailabilityConsumer;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Implementação do consumidor de mensagens de alteração de disponibilidade de produtos.
 * <p>
 * Escuta a fila RabbitMQ definida em spring.rabbitmq.queue.product-change-availability
 * e delega a alteração de status para o ProductService.
 */
@Service
@AllArgsConstructor
public class ProductChangeAvailabilityConsumerImpl implements IProductChangeAvailabilityConsumer {

    /** Serviço de produtos usado para alterar status */
    private final IProductService service;

    /**
     * Recebe uma mensagem de RabbitMQ e atualiza a disponibilidade do produto.
     *
     * @param message Mensagem contendo id do produto e status
     */
    @RabbitListener(queues = "${spring.rabbitmq.queue.product-change-availability}")
    @Override
    public void receive(StockStatusMessage message) {
        service.changeActivated(message.id(), message.active());
    }
}
