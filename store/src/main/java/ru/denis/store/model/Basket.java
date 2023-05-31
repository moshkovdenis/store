package ru.denis.store.model;

import jakarta.persistence.*;

import lombok.*;
import java.util.Set;

@Entity
@Table(name = "basket")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Basket {
    @Id
    @GeneratedValue()
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalog_id", referencedColumnName = "id")
    private Set<Catalog> catalogs;
}