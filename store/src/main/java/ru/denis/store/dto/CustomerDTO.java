package ru.denis.store.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CustomerDTO {
    private Long id;
    private String name;
    private Integer age;
    private String login;
    private Set<BasketDTO> basket;
}
