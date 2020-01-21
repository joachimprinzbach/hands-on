package com.baloise.springfundamentals.handson.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Integer> {

    @Query("select o from PizzaOrder o where :name in elements(o.additionalIngredients)")
    List<PizzaOrder> findAllByAdditionalIngredientsContains(String name);

    List<PizzaOrder> findPizzaOrdersByNameEqualsOrderByIdDesc(String name);
}
