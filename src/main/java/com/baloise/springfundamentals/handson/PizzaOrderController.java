package com.baloise.springfundamentals.handson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            return this.pizzaOrderService.getPizzaOrders()
                    .stream()
                    .filter(o -> o.getPizzaOrderItems().stream().anyMatch(poi -> poi.getName().contains(name.get())))
                    .collect(Collectors.toList());
        }
        return this.pizzaOrderService.getPizzaOrders();
    }

    @GetMapping("/{id}")
    public PizzaOrder getPizzaOrderById(@PathVariable String id) {
        return this.pizzaOrderService.getPizzaOrders()
                .stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Order with id: " + id + " not found."));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createPizzaOrder(@RequestBody PizzaOrder pizzaOrder) {
        return pizzaOrderService.create(pizzaOrder);
    }
}
