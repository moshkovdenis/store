package ru.denis.store;

import ru.denis.store.dto.CatalogDTO;
import ru.denis.store.dto.CustomerDTO;
import ru.denis.store.model.Catalog;
import ru.denis.store.model.Customer;

public class DataTest {

    public static CustomerDTO getCustomerDTO() {
        return CustomerDTO.builder()
                .id(1L)
                .name("Test")
                .login("test")
                .age(25)
                .build();
    }

    public static Customer getCustomer() {
        return Customer.builder()
                .id(1L)
                .name("Test")
                .login("test")
                .age(25)
                .build();
    }

    public static CatalogDTO getCatalogDTO() {
        return CatalogDTO.builder()
                .id(1L)
                .description("Test")
                .price(50)
                .articul(001)
                .count(1)
                .rating(10)
                .build();
    }

    public static Catalog getCatalog() {
        return Catalog.builder()
                .id(1L)
                .description("Test")
                .price(50)
                .articul(001)
                .count(1)
                .rating(10)
                .build();
    }
}
