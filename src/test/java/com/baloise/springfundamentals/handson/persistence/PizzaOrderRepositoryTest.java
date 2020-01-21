package com.baloise.springfundamentals.handson.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PizzaOrderRepositoryTest {

    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;

    @Test
    void repository_roundtrip() {
        PizzaOrder salamiPizzaOrder = new PizzaOrder(null, "Salami", Arrays.asList("Onions", "Pineapple"));

        PizzaOrder savedOrder = pizzaOrderRepository.save(salamiPizzaOrder);

        List<PizzaOrder> allPizzas = pizzaOrderRepository.findAll();
        assertThat(allPizzas).contains(salamiPizzaOrder);

        Optional<PizzaOrder> foundOrder = pizzaOrderRepository.findById(savedOrder.getId());
        assertThat(foundOrder).isPresent();

        List<PizzaOrder> ordersWithAdditionalPineapple = pizzaOrderRepository.findAllByAdditionalIngredientsContains("Pineapple");
        assertThat(ordersWithAdditionalPineapple).contains(salamiPizzaOrder);
    }
}