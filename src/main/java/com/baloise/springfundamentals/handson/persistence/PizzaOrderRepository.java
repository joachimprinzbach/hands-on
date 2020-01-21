package com.baloise.springfundamentals.handson.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Integer> {

    @Query("select PizzaOrder from PizzaOrder u, PizzaOrderItem i where u.id = i.pizzaOrder.id and i.name = ?1")
    List<PizzaOrder> findCustomByPizzaOrderItemName(String name);
}
