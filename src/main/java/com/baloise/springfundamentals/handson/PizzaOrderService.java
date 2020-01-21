package com.baloise.springfundamentals.handson;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PizzaOrderService {

    private static final List<PizzaOrder> PIZZA_ORDERS = new ArrayList<>(Arrays.asList(
            new PizzaOrder(1, "Salami", Arrays.asList("Mushrooms", "Kangaroo")),
            new PizzaOrder(2, "Funghi", Collections.emptyList()),
            new PizzaOrder(3, "Hawai", Collections.emptyList()),
            new PizzaOrder(5, "Margherita", Arrays.asList("Mushrooms", "Onions", "Salami", "Extra Cheese"))
    ));

    public List<PizzaOrder> getPizzaOrders() {
        return PIZZA_ORDERS;
    }

    public Integer create(PizzaOrder pizzaOrder) {
        PIZZA_ORDERS.add(pizzaOrder);
        return pizzaOrder.getId();
    }
}
