package com.baloise.springfundamentals.handson;

import com.baloise.springfundamentals.handson.persistence.PizzaOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pizza-orders")
@RequiredArgsConstructor
public class PizzaOrderController {

    private final PizzaOrderService pizzaOrderService;

    @GetMapping
    public List<PizzaOrder> getPizzaOrders(@RequestParam Optional<String> pizzaName) {
        if (pizzaName.isPresent()) {
            return this.pizzaOrderService.findPizzaOrderByNameEquals(pizzaName.get());
        }
        return this.pizzaOrderService.getPizzaOrders();
    }

    @GetMapping("/with-ingredients/{ingredientName}")
    public List<PizzaOrder> getPizzaOrders(@PathVariable String ingredientName) {
        return this.pizzaOrderService.findWithAdditionalIngredient(ingredientName);
    }

    @GetMapping("/{id}")
    public PizzaOrder getPizzaOrderById(@PathVariable String id) {
        return this.pizzaOrderService.findPizzaOrderByNameEquals(Integer.parseInt(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createPizzaOrder(@RequestBody PizzaOrder pizzaOrder) {
        return pizzaOrderService.create(pizzaOrder);
    }
}
