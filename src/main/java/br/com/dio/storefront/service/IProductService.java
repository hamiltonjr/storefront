package br.com.dio.storefront.service;

import br.com.dio.storefront.dto.ProductInfoDTO;
import br.com.dio.storefront.entity.ProductEntity;
import java.util.List;
import java.util.UUID;

/**
 * Interface de serviço para operações de produtos no storefront.
 * <p>
 * Define os métodos de criação, atualização, listagem e compra de produtos.
 */
public interface IProductService {

    /**
     * Salva um novo produto ou atualiza um existente.
     *
     * @param entity Entidade do produto
     * @return Entidade do produto persistida
     */
    ProductEntity save(final ProductEntity entity);

    /**
     * Altera o status de ativação de um produto.
     *
     * @param id     Identificador do produto
     * @param active True para ativar, false para desativar
     */
    void changeActivated(final UUID id, final boolean active);

    /**
     * Retorna todos os produtos ativos.
     *
     * @return Lista de entidades de produtos ativos
     */
    List<ProductEntity> findAllActive();

    /**
     * Retorna informações detalhadas de um produto.
     *
     * @param id Identificador do produto
     * @return DTO com informações do produto
     */
    ProductInfoDTO findInfo(final UUID id);

    /**
     * Realiza a compra de um produto.
     *
     * @param id Identificador do produto a ser comprado
     */
    void purchase(final UUID id);
}
