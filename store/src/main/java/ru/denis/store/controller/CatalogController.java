package ru.denis.store.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.denis.store.dto.CatalogDTO;
import ru.denis.store.service.CatalogService;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/catalog")
@AllArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("/find-all")
    public ResponseEntity<?> findAllCatalog() {
        return ResponseEntity.ok(catalogService.findAllCatalog());
    }

    @GetMapping("/find-by-articul")
    public ResponseEntity<?> findCatalogByActicul(@RequestParam("articul") Integer articul) {
        Optional<CatalogDTO> catalog = catalogService.findCatalogByArtucul(articul);
        return catalog.isPresent() ? ResponseEntity.ok(catalog) : ResponseEntity.notFound().build();
    }
}
