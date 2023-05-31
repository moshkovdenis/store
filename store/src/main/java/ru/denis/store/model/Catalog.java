package ru.denis.store.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "catalog")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Catalog {
    @Id
    @GeneratedValue()
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Integer price;
    @Column(name = "articul")
    private Integer articul;
    @Column(name = "count")
    private Integer count;
    @Column(name = "rating")
    private Integer rating;

}
