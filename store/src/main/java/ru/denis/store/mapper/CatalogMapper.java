package ru.denis.store.mapper;

import org.mapstruct.Mapper;
import ru.denis.store.dto.CatalogDTO;
import ru.denis.store.model.Catalog;

@Mapper(componentModel = "spring")
public interface CatalogMapper {
    CatalogDTO catalogToDto(Catalog catalog);
    Catalog dtoToCatalog(CatalogDTO catalogDTO);
}
