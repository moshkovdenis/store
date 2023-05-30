package ru.denis.store.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.denis.store.DataTest;
import ru.denis.store.dto.CustomerDTO;
import ru.denis.store.mapper.CustomerMapper;
import ru.denis.store.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@Slf4j
class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerMapper customerMapper;
    @InjectMocks
    private CustomerService customerService;

    @Test
    void findAllCustomers() {
        when(customerRepository.findAll())
                .thenReturn(List.of(DataTest.getCustomer()));
        when(customerMapper.customerToDto(any()))
                .thenReturn(DataTest.getCustomerDTO());
        List<CustomerDTO> customers = customerService.findAllCustomers();
        assertThat(customers)
                .asList()
                .isNotEmpty();
        log.info(customers.toString());
    }

    @Test
    void findCustomerByLogin_ExpectFindCustomerByLogin() {
        when(customerRepository.findCustomerByLogin(anyString()))
                .thenReturn(Optional.of(DataTest.getCustomer()));
        when(customerMapper.customerToDto(any()))
                .thenReturn(DataTest.getCustomerDTO());
        Optional<CustomerDTO> customer = customerService.findCustomerByLogin(anyString());
        assertThat(customer)
                .isPresent();
        log.info(customer.toString());
    }

    @Test
    void findCustomerByLogin_ExpectNotFindCustomerByLogin() {
        when(customerRepository.findCustomerByLogin(anyString()))
                .thenReturn(Optional.empty());
        Optional<CustomerDTO> customer = customerService.findCustomerByLogin(anyString());
        assertThat(customer)
                .isEmpty();
    }
}