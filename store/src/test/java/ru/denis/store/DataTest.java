package ru.denis.store;

import ru.denis.store.dto.CustomerDTO;
import ru.denis.store.model.Customer;

public class DataTest {

    public static CustomerDTO getCustomerDTO() {
        return CustomerDTO.builder()
                .id(1L)
                .name("Test")
                .age(25)
                .build();
    }

    public static Customer getCustomer() {
        return Customer.builder()
                .id(1L)
                .name("Test")
                .age(25)
                .build();
    }
}
