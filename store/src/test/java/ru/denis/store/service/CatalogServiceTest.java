package ru.denis.store.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.denis.store.DataTest;
import ru.denis.store.dto.CatalogDTO;
import ru.denis.store.dto.CustomerDTO;
import ru.denis.store.mapper.CatalogMapper;
import ru.denis.store.repository.CatalogRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@Slf4j
public class CatalogServiceTest {

    @Mock
    private CatalogRepository catalogRepository;
    @Mock
    private CatalogMapper catalogMapper;
    @InjectMocks
    private CatalogService catalogService;

    @Test
    void findAllCatalog() {
        when(catalogRepository.findAll())
                .thenReturn(List.of(DataTest.getCatalog()));
        when(catalogMapper.catalogToDto(any()))
                .thenReturn(DataTest.getCatalogDTO());
        List<CatalogDTO> catalogs = catalogService.findAllCatalog();
        assertThat(catalogs)
                .asList()
                .isNotEmpty();
        log.info(catalogs.toString());
    }

    @Test
    void findCatalogByArticul_ExpectFindCatalogByArticul() {
        when(catalogRepository.findCatalogByArticul(anyInt()))
                .thenReturn(Optional.of(DataTest.getCatalog()));
        when(catalogMapper.catalogToDto(any()))
                .thenReturn(DataTest.getCatalogDTO());
        Optional<CatalogDTO> catalog = catalogService.findCatalogByArtucul(anyInt());
        assertThat(catalog)
                .isPresent();
        log.info(catalog.toString());
    }

    @Test
    void findCatalogByArticul_ExpectNotFindCatalogByarticul() {
        when(catalogRepository.findCatalogByArticul(anyInt()))
                .thenReturn(Optional.empty());
        Optional<CatalogDTO> catalog = catalogService.findCatalogByArtucul(anyInt());
        assertThat(catalog)
                .isEmpty();
    }
}
