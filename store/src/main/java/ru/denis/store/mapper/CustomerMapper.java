package ru.denis.store.mapper;

import org.mapstruct.Mapper;
import ru.denis.store.dto.CustomerDTO;
import ru.denis.store.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO customerToDto(Customer customer);
    Customer dtoToCustomer(CustomerDTO customerDTO);
}
