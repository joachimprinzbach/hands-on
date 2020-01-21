package com.baloise.springfundamentals.handson;

import com.baloise.springfundamentals.handson.inventory.PizzaInventoryService;
import com.baloise.springfundamentals.handson.persistence.PizzaOrder;
import com.baloise.springfundamentals.handson.persistence.PizzaOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PizzaOrderService {

    private final PizzaInventoryService pizzaInventoryService;
    private final PizzaOrderRepository pizzaOrderRepository;

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrderRepository.findAll();
    }

    public List<PizzaOrder> findWithAdditionalIngredient(String ingredientName) {
        return pizzaOrderRepository.findAllByAdditionalIngredientsContains(ingredientName);
    }

    public List<PizzaOrder> findPizzaOrderByNameEquals(String pizzaName) {
        return pizzaOrderRepository.findPizzaOrdersByNameEqualsOrderByIdDesc(pizzaName);
    }

    public PizzaOrder findPizzaOrderById(Integer id) {
        Optional<PizzaOrder> potentiallyFoundOrder = pizzaOrderRepository.findById(id);
        return potentiallyFoundOrder.orElseThrow(() -> new IllegalArgumentException("Order with id: " + id + " not found."));
    }

    public Integer create(PizzaOrder pizzaOrder) {
        boolean isAvailable = pizzaInventoryService.isAvailable(pizzaOrder.getName());
        if (!isAvailable) {
            throw new IllegalStateException("Pizza " + pizzaOrder.getName() + " is out of stock.");
        }
        PizzaOrder savedPizzaOrder = pizzaOrderRepository.save(pizzaOrder);
        return savedPizzaOrder.getId();
    }
}
