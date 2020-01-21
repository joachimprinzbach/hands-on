package com.baloise.springfundamentals.handson;

import com.baloise.springfundamentals.handson.persistence.PizzaOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pizza-orders")
public class PizzaOrderController {

    private final PizzaOrderService pizzaOrderService;

    @Autowired
    public PizzaOrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @GetMapping
    public List<PizzaOrder> getPizzaOrders(@RequestParam Optional<String> name) {
        if (name.isPresent()) {
            return this.pizzaOrderService.findByPizzaOrderItemName(name.get());
        }
        return this.pizzaOrderService.getPizzaOrders();
    }

    @GetMapping("/{id}")
    public PizzaOrder getPizzaOrderById(@PathVariable String id) {
        return this.pizzaOrderService.getById(Integer.parseInt(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createPizzaOrder(@RequestBody PizzaOrder pizzaOrder) {
        return pizzaOrderService.create(pizzaOrder);
    }
}
