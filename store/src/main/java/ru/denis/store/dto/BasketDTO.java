package ru.denis.store.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BasketDTO {
    private Long id;
    private List<BasketCatalogDTO> basketCatalogs;
    private Boolean completed;
}
