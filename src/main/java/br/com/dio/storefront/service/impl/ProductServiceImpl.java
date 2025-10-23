package br.com.dio.storefront.service.impl;

import br.com.dio.storefront.dto.ProductDetailDTO;
import br.com.dio.storefront.dto.ProductInfoDTO;
import br.com.dio.storefront.entity.ProductEntity;
import br.com.dio.storefront.mapper.IProductMapper;
import br.com.dio.storefront.repository.ProductRepository;
import br.com.dio.storefront.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Implementação do serviço de produtos do storefront.
 * <p>
 * Responsável por salvar produtos, alterar disponibilidade,
 * buscar produtos ativos, consultar informações detalhadas e processar compras.
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository repository;
    private final RestClient warehouseClient;
    private final IProductMapper mapper;

    @Override
    public ProductEntity save(final ProductEntity entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void changeActivated(final UUID id, final boolean active) {
        var entity = findById(id);
        entity.setActive(active);
        repository.save(entity);
    }

    @Override
    public List<ProductEntity> findAllActive() {
        return repository.findByActiveTrueOrderByNameAsc();
    }

    @Override
    public ProductInfoDTO findInfo(final UUID id) {
        var entity = findById(id);
        var price = requestCurrentAmount(id);
        return mapper.toDTO(entity, price);
    }

    @Override
    @Transactional
    public void purchase(final UUID id) {
        purchaseWarehouse(id);
    }

    /** Busca um produto pelo id ou lança exceção se não encontrado */
    private ProductEntity findById(final UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produto não encontrado: " + id));
    }

    /** Solicita preço atual do produto no warehouse via REST */
    private BigDecimal requestCurrentAmount(final UUID id) {
        var dto = warehouseClient.get()
                .uri("/products/" + id)
                .retrieve()
                .body(ProductDetailDTO.class);
        return dto.price();
    }

    /** Processa compra do produto no warehouse via REST */
    private void purchaseWarehouse(final UUID id) {
        var path = String.format("/products/%s/purchase", id);
        warehouseClient.post()
                .uri(path)
                .retrieve()
                .toBodilessEntity();
    }
}
