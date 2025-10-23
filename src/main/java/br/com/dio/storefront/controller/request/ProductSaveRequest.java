package br.com.dio.storefront.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.UUID;

/**
 * DTO de requisição para criação de um produto.
 * <p>
 * Contém os dados necessários que o cliente envia ao criar um produto na vitrine.
 *
 * @param id   Identificador único do produto (opcional, geralmente gerado pelo backend)
 * @param name Nome do produto (obrigatório, não pode ser vazio)
 */
public record ProductSaveRequest(
        @JsonProperty("id")
        UUID id,

        @JsonProperty("name")
        @NotBlank(message = "O nome do produto não pode estar vazio")
        @Size(max = 255, message = "O nome do produto deve ter no máximo 255 caracteres")
        String name
) {}
