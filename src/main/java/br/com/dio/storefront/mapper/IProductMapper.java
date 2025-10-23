package br.com.dio.storefront.mapper;

import br.com.dio.storefront.controller.request.ProductSaveRequest;
import br.com.dio.storefront.controller.response.ProductAvailableResponse;
import br.com.dio.storefront.controller.response.ProductDetailResponse;
import br.com.dio.storefront.controller.response.ProductSavedResponse;
import br.com.dio.storefront.dto.ProductInfoDTO;
import br.com.dio.storefront.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.math.BigDecimal;
import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * Mapper MapStruct para conversão entre ProductEntity, DTOs internos e DTOs de request/response.
 */
@Mapper(componentModel = SPRING)
public interface IProductMapper {

    /**
     * Converte ProductEntity para ProductInfoDTO incluindo preço.
     *
     * @param entity Entity do produto
     * @param price  Preço do produto
     * @return ProductInfoDTO
     */
    ProductInfoDTO toDTO(final ProductEntity entity, final BigDecimal price);

    /**
     * Converte ProductSaveRequest em ProductEntity.
     * <p>
     * O campo 'active' é definido como false por padrão.
     *
     * @param request DTO de criação de produto
     * @return ProductEntity
     */
    @Mapping(target = "active", constant = "false")
    ProductEntity toEntity(final ProductSaveRequest request);

    /**
     * Converte ProductEntity em ProductSavedResponse.
     *
     * @param entity Entity do produto
     * @return DTO de resposta após salvar o produto
     */
    ProductSavedResponse toResponse(final ProductEntity entity);

    /**
     * Converte lista de ProductEntity em lista de ProductAvailableResponse.
     *
     * @param entities Lista de entidades
     * @return Lista de DTOs de produtos disponíveis
     */
    List<ProductAvailableResponse> toResponse(final List<ProductEntity> entities);

    /**
     * Converte ProductInfoDTO em ProductDetailResponse.
     *
     * @param dto DTO interno do produto
     * @return DTO detalhado de resposta
     */
    ProductDetailResponse toResponse(final ProductInfoDTO dto);
}
