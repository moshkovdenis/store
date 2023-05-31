package ru.denis.store.repository;

import jakarta.transaction.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.denis.store.model.Basket;
import ru.denis.store.model.Customer;

public interface BasketRepository extends JpaRepository<Basket, Long> {


    @Modifying
    @Query(value = "INSERT INTO basket_catalog (basket_id, catalog_id) VALUES (?1, ?2)", nativeQuery = true)
    void addCatalogToBasket(Long basketId, Long catalogId);


    @Modifying
    @Query(value = "DELETE FROM basket_catalog WHERE basket_id = ?1 AND catalog_id = ?2", nativeQuery = true)
    void removeCatalogFromBasket(Long basketId, Long catalogId);

    Basket getDistinctByCustomer_Id(Long customer);
}
