package ru.denis.store.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerControllerTest extends AbstractControllerTest {

    @BeforeEach
    @SneakyThrows
    protected void setUp() {
        super.setUp();
    }

    @Test
    @SneakyThrows
    void findAllCustomers_ExpectFindAllCustomers() {
        mvc.perform(get("/api/v1/customer/find-all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @SneakyThrows
    void findCustomerByLogin_ExpectFindCustomerByLogin() {
        mvc.perform(get("/api/v1/customer/find-by-login")
                .param("login", "Ivan")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @SneakyThrows
    void findCustomerByLogin_ExpectNotFindCustomerByLogin() {
        mvc.perform(get("/api/v1/customer/find-by-login")
                        .param("login", "kasdfkasdhfk")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }
}