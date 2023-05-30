package ru.denis.store.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.denis.store.dto.CustomerDTO;
import ru.denis.store.mapper.CustomerMapper;
import ru.denis.store.model.Customer;
import ru.denis.store.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerDTO> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToDto)
                .toList();
    }

    public Optional<CustomerDTO> findCustomerByLogin(String login) {
        Optional<Customer> customer = customerRepository.findCustomerByLogin(login);
        return customer.map(customerMapper::customerToDto);
    }
}
