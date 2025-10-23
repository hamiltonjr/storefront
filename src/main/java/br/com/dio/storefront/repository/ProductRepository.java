package br.com.dio.storefront.repository;

import br.com.dio.storefront.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

/**
 * Repositório JPA para operações CRUD em ProductEntity.
 * <p>
 * Inclui métodos personalizados para busca de produtos ativos.
 */
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    /**
     * Busca todos os produtos ativos, ordenados pelo nome em ordem crescente.
     *
     * @return Lista de ProductEntity ativos ordenados por nome
     */
    List<ProductEntity> findByActiveTrueOrderByNameAsc();
}
