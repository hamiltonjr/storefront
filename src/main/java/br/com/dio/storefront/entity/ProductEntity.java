package br.com.dio.storefront.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Objects;
import java.util.UUID;

/**
 * Entidade JPA que representa um produto no storefront.
 * <p>
 * Contém identificador, nome e status de ativação do produto.
 */
@Entity
@Getter
@Setter
@ToString
public class ProductEntity {

    /** Identificador único do produto */
    @Id
    private UUID id;

    /** Nome do produto */
    @Column(nullable = false, length = 255)
    private String name;

    /** Indica se o produto está ativo */
    @Column(nullable = false)
    private Boolean active;

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ProductEntity that)) return false;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(active, that.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active);
    }
}
