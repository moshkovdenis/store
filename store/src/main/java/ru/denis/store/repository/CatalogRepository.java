package ru.denis.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denis.store.model.Catalog;
import java.util.Optional;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    Optional<Catalog> findCatalogByArticul(Integer articul);
}
