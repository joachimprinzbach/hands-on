package com.baloise.springfundamentals.handson;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pizza-orders")
@RequiredArgsConstructor
public class PizzaOrderController {

    private final PizzaOrderService pizzaOrderService;

    @GetMapping
    public List<PizzaOrder> getPizzaOrders(@RequestParam Optional<String> pizzaName) {
        if (pizzaName.isPresent()) {
            return this.pizzaOrderService.getPizzaOrders()
                    .stream()
                    .filter(o -> o.getName().equals(pizzaName.get()))
                    .collect(Collectors.toList());
        }
        return this.pizzaOrderService.getPizzaOrders();
    }

    @GetMapping("/{id}")
    public PizzaOrder getPizzaOrderById(@PathVariable String id) {
        return this.pizzaOrderService.getPizzaOrders()
                .stream()
                .filter(o -> o.getId().equals(Integer.parseInt(id)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Order with id: " + id + " not found."));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createPizzaOrder(@RequestBody PizzaOrder pizzaOrder) {
        return pizzaOrderService.create(pizzaOrder);
    }
}
