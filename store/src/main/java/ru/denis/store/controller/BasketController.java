package ru.denis.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.denis.store.service.BasketService;

@RestController
@RequestMapping("/api/v1/basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/{basketId}/catalog/{catalogId}")
    public ResponseEntity<?> addCatalogToBasket(@PathVariable Long basketId, @PathVariable Long catalogId) {
        try {
            basketService.addCatalogToBasket(basketId, catalogId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{basketId}/catalog/{catalogId}")
    public ResponseEntity<?> removeCatalogFromBasket(@PathVariable Long basketId, @PathVariable Long catalogId) {
        try {
            basketService.removeCatalogFromBasket(basketId, catalogId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/total-cost")
    public ResponseEntity<Integer> getTotalCost(@RequestParam("login") String login) {
        Integer totalCost = basketService.getTotalCost(login);
        return new ResponseEntity<>(totalCost, HttpStatus.OK);
    }
}
