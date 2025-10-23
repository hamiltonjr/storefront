package br.com.dio.storefront.controller;

import br.com.dio.storefront.controller.request.ProductSaveRequest;
import br.com.dio.storefront.controller.response.ProductAvailableResponse;
import br.com.dio.storefront.controller.response.ProductDetailResponse;
import br.com.dio.storefront.controller.response.ProductSavedResponse;
import br.com.dio.storefront.mapper.IProductMapper;
import br.com.dio.storefront.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 * Controller REST para gerenciar produtos do storefront.
 * <p>
 * Fornece endpoints para criar produtos, listar produtos ativos,
 * consultar detalhes e registrar compras.
 */
@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final IProductService service;
    private final IProductMapper mapper;

    /**
     * Cria um novo produto.
     *
     * @param request DTO com os dados do produto
     * @return DTO com os dados do produto salvo
     */
    @PostMapping
    @ResponseStatus(CREATED)
    public ProductSavedResponse create(@Valid @RequestBody final ProductSaveRequest request) {
        var entity = mapper.toEntity(request);
        entity = service.save(entity);
        return mapper.toResponse(entity);
    }

    /**
     * Registra a compra de um produto pelo ID.
     *
     * @param id UUID do produto
     */
    @PostMapping("{id}/purchase")
    @ResponseStatus(NO_CONTENT)
    public void purchase(@PathVariable final UUID id){
        service.purchase(id);
    }

    /**
     * Lista todos os produtos ativos disponíveis.
     *
     * @return lista de DTOs de produtos ativos
     */
    @GetMapping
    public List<ProductAvailableResponse> listAvailable(){
        var entities = service.findAllActive();
        return mapper.toResponse(entities);
    }

    /**
     * Consulta detalhes de um produto pelo ID.
     *
     * @param id UUID do produto
     * @return DTO com detalhes do produto
     */
    @GetMapping("{id}")
    public ProductDetailResponse findById(@PathVariable final UUID id){
        var dto = service.findInfo(id);
        return mapper.toResponse(dto);
    }
}
