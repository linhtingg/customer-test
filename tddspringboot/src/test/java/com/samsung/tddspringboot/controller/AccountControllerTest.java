package com.samsung.tddspringboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsung.tddspringboot.repository.models.Account;
import com.samsung.tddspringboot.services.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @MockBean
    AccountService accountService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_hello_view() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("Hello"))
                .andExpect(model().attributeExists("name"))
                .andDo(print());
    }

    @Test
    public void should_return_success_page() throws Exception {
        when(accountService.withDrawMoney(anyString(), anyLong())).thenReturn("Giao dịch thành công.");

        Account acc = Account.builder().Number("0541001456123").Money(500000l).build();

        this.mockMvc.perform(post("/withdraw")
                .content(new ObjectMapper().writeValueAsString(acc))
                .contentType("application/json").accept("application/json")
                )
                .andExpect(status().isOk())
                .andExpect(view().name("withDrawResult"))
                .andExpect(content().string(containsString("<h1>Giao dịch thành công.</h1>")))
                .andDo(print());
    }
}
