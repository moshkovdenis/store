package ru.denis.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "basket_catalog")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BasketCatalog {
    @Id
    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @Id
    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;
}
