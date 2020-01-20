package com.baloise.springfundamentals.handson;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PizzaOrderService {

    private static final List<PizzaOrder> PIZZA_ORDERS = new ArrayList<>(Arrays.asList(
            new PizzaOrder("1", Arrays.asList(
                    new PizzaOrderItem("Salami", 2),
                    new PizzaOrderItem("Funghi", 1)
            )),
            new PizzaOrder("2", Arrays.asList(
                    new PizzaOrderItem("Prosciutto & Pineapple", 1)
            )))
    );

    public List<PizzaOrder> getPizzaOrders() {
        return PIZZA_ORDERS;
    }

    public String create(PizzaOrder pizzaOrder) {
        PIZZA_ORDERS.add(pizzaOrder);
        return pizzaOrder.getId();
    }
}
