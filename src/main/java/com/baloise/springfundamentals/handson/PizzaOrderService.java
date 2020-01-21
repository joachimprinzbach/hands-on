package com.baloise.springfundamentals.handson;

import com.baloise.springfundamentals.handson.inventory.PizzaInventoryService;
import com.baloise.springfundamentals.handson.persistence.PizzaOrder;
import com.baloise.springfundamentals.handson.persistence.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaOrderService {

    private final PizzaInventoryService pizzaInventoryService;
    private final PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    public PizzaOrderService(PizzaInventoryService pizzaInventoryService, PizzaOrderRepository pizzaOrderRepository) {
        this.pizzaInventoryService = pizzaInventoryService;
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrderRepository.findAll();
    }

    public List<PizzaOrder> findByPizzaOrderItemName(String name) {
        return pizzaOrderRepository.findCustomByPizzaOrderItemName(name);
    }

    public PizzaOrder getById(Integer id) {
        Optional<PizzaOrder> potentiallyFoundPizzaOrder = pizzaOrderRepository.findById(id);
        return potentiallyFoundPizzaOrder.orElseThrow(() -> new IllegalArgumentException("Order with id: " + id + " not found."));
    }

    public Integer create(PizzaOrder pizzaOrder) {
        pizzaOrder.getPizzaOrderItems().forEach(orderItem -> {
            boolean isAvailable = pizzaInventoryService.isAvailable(orderItem.getName());
            if (!isAvailable) {
                throw new IllegalStateException("Pizza " + orderItem.getName() + " is out of stock.");
            }
            orderItem.setPizzaOrder(pizzaOrder);
        });
        PizzaOrder savedOrder = pizzaOrderRepository.save(pizzaOrder);
        return savedOrder.getId();
    }
}
