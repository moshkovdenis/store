package ru.denis.store.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CatalogControllerTest extends AbstractControllerTest {

    @BeforeEach
    @SneakyThrows
    protected void setUp() {
        super.setUp();
    }

    @Test
    @SneakyThrows
    void findAllCatalog_ExpectFindAllCatalogs() {
        mvc.perform(get("/api/v1/catalog/find-all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @SneakyThrows
    void findCatalogByArticul_ExpectFindCatalogByArticul() {
        mvc.perform(get("/api/v1/catalog/find-by-articul")
                        .param("articul", "001")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @SneakyThrows
    void findCatalogByArticul_ExpectNotFindCatalogByArticul() {
        mvc.perform(get("/api/v1/catalog/find-by-articul")
                        .param("articul", "987987564")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }
}
