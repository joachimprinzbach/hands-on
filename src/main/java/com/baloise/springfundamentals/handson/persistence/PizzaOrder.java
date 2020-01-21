package com.baloise.springfundamentals.handson.persistence;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pizzaOrders")
public class PizzaOrder {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(mappedBy = "pizzaOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PizzaOrderItem> pizzaOrderItems;

    public PizzaOrder() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
