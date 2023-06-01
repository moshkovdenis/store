package ru.denis.store.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketCatalogDTO {
    private CatalogDTO catalog;
}
