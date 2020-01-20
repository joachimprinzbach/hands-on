package com.baloise.springfundamentals.handson;

import java.util.List;
import java.util.Objects;

public class PizzaOrder {

    private String id;
    private List<PizzaOrderItem> pizzaOrderItems;

    public PizzaOrder(String id, List<PizzaOrderItem> pizzaOrderItems) {
        this.id = id;
        this.pizzaOrderItems = pizzaOrderItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PizzaOrderItem> getPizzaOrderItems() {
        return pizzaOrderItems;
    }

    public void setPizzaOrderItems(List<PizzaOrderItem> pizzaOrderItems) {
        this.pizzaOrderItems = pizzaOrderItems;
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "id='" + id + '\'' +
                ", pizzaOrderItems=" + pizzaOrderItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaOrder that = (PizzaOrder) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(pizzaOrderItems, that.pizzaOrderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pizzaOrderItems);
    }
}
