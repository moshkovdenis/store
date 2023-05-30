package ru.denis.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denis.store.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerByLogin(String login);
}
