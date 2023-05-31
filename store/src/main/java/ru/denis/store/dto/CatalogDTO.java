package ru.denis.store.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatalogDTO {
    private Long id;
    private String description;
    private Integer price;
    private Integer articul;
    private Integer count;
    private Integer rating;
}
