package com.baloise.springfundamentals.handson;

import com.baloise.springfundamentals.handson.persistence.PizzaOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PizzaOrderController.class)
class PizzaOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PizzaOrderService pizzaOrderService;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        doReturn(new PizzaOrder(10, "Salami", Collections.emptyList()))
                .when(pizzaOrderService).findPizzaOrderById(10);

        this.mockMvc
                .perform(get("/pizza-orders/10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  " +
                        "\"id\":10,\n" +
                        "  \"name\":\"Salami\",\n" +
                        "  \"additionalIngredients\":[]\n" +
                        "}"));
    }
}