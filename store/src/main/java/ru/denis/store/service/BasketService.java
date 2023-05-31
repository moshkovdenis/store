package ru.denis.store.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.denis.store.dto.CustomerDTO;
import ru.denis.store.mapper.CatalogMapper;
import ru.denis.store.mapper.CustomerMapper;
import ru.denis.store.model.Basket;
import ru.denis.store.model.Catalog;
import ru.denis.store.model.Customer;
import ru.denis.store.repository.BasketRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;

    private final CustomerService customerService;

    private final CustomerMapper customerMapper;


    public void addCatalogToBasket(Long basketId, Long catalogId) {
        basketRepository.addCatalogToBasket(basketId, catalogId);
    }

    public void removeCatalogFromBasket(Long basketId, Long catalogId) {
        basketRepository.removeCatalogFromBasket(basketId, catalogId);
    }

    public Integer getTotalCost(String login) {

        Optional<CustomerDTO> customer = customerService.findCustomerByLogin(login);
        if(customer.isPresent()) {
            Basket basket = customer.get().getBasket();
            return basket.getCatalogs()
                    .stream()
                    .map(Catalog::getCount)
                    .reduce(Integer::sum)
                    .get();
        }
        return 0;
    }
}
