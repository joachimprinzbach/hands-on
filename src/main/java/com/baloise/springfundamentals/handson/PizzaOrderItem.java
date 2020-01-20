package com.baloise.springfundamentals.handson;

import java.util.Objects;

public class PizzaOrderItem {

    private String name;
    private int quantity;

    public PizzaOrderItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PizzaOrderItem{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaOrderItem that = (PizzaOrderItem) o;
        return quantity == that.quantity &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity);
    }
}
