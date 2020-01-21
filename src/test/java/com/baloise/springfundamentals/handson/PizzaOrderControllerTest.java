package com.baloise.springfundamentals.handson;

import com.baloise.springfundamentals.handson.persistence.PizzaOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PizzaOrderController.class)
class PizzaOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PizzaOrderService pizzaOrderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void pizzaOrderWithId_200OK_correctPizzaOrder() throws Exception {
        PizzaOrder salamiPizzaOrder = new PizzaOrder(10, "Salami", Collections.emptyList());
        doReturn(salamiPizzaOrder)
                .when(pizzaOrderService).findPizzaOrderById(10);

        this.mockMvc
                .perform(get("/pizza-orders/10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(salamiPizzaOrder)));
    }
}