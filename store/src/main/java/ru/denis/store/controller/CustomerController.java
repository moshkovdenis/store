package ru.denis.store.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.denis.store.dto.CustomerDTO;
import ru.denis.store.service.CustomerService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/find-all")
    public ResponseEntity<?> findAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/find-by-login")
    public ResponseEntity<?> findCustomerByLogin(@RequestParam("login") String login) {
        Optional<CustomerDTO> customer = customerService.findCustomerByLogin(login);
        return customer.isPresent() ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }
}
