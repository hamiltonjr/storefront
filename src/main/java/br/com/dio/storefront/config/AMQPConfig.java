package br.com.dio.storefront.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração do RabbitMQ para o microsserviço Storefront.
 * <p>
 * Define o conversor de mensagens JSON e o template RabbitTemplate
 * que será usado para enviar mensagens para as filas do RabbitMQ.
 */
@Configuration
public class AMQPConfig {

    /**
     * Bean responsável por converter objetos Java em JSON ao enviar mensagens
     * para o RabbitMQ e vice-versa.
     *
     * @return o conversor Jackson2JsonMessageConverter
     */
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Bean que fornece o RabbitTemplate configurado com o conversor JSON.
     * É usado para enviar mensagens para filas do RabbitMQ.
     *
     * @param connectionFactory a fábrica de conexões do RabbitMQ
     * @param converter         o conversor de mensagens JSON
     * @return um RabbitTemplate pronto para uso
     */
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory,
                                         final Jackson2JsonMessageConverter converter) {
        var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;
    }
}
