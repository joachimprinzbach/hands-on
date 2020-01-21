package com.baloise.springfundamentals.handson;

import com.baloise.springfundamentals.handson.inventory.PizzaInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PizzaOrderService {

    private final PizzaInventoryService pizzaInventoryService;

    @Autowired
    public PizzaOrderService(PizzaInventoryService pizzaInventoryService) {
        this.pizzaInventoryService = pizzaInventoryService;
    }

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
        pizzaOrder.getPizzaOrderItems().forEach(orerItem -> {
            boolean isAvailable = pizzaInventoryService.isAvailable(orerItem.getName());
            if(!isAvailable) {
                throw new IllegalStateException("Pizza " + orerItem.getName() + " is out of stock.");
            }
        });
        PIZZA_ORDERS.add(pizzaOrder);
        return pizzaOrder.getId();
    }
}
