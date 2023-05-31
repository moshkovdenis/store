package ru.denis.store.dto;

import lombok.Builder;
import lombok.Data;
import ru.denis.store.model.Basket;

@Data
@Builder
public class CustomerDTO {
    private Long id;
    private String name;
    private Integer age;
    private String login;
    private Basket basket;
}
