package ru.denis.store.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.denis.store.dto.CatalogDTO;
import ru.denis.store.mapper.CatalogMapper;
import ru.denis.store.model.Catalog;
import ru.denis.store.repository.CatalogRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatalogService {
    private final CatalogRepository catalogRepository;
    private final CatalogMapper catalogMapper;

    public List<CatalogDTO> findAllCatalog() {
        return catalogRepository.findAll()
                .stream()
                .map(catalogMapper::catalogToDto)
                .toList();
    }

    public Optional<CatalogDTO> findCatalogByArtucul(Integer articul) {
        Optional<Catalog> catalog = catalogRepository.findCatalogByArticul(articul);
        return catalog.map(catalogMapper::catalogToDto);
    }
}
