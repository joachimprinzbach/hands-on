package com.baloise.springfundamentals.handson.inventory;

import java.util.Random;

public class RemotePizzaInventoryService implements PizzaInventoryService {

    @Override
    public boolean isAvailable(String pizzaName) {
        return new Random().nextBoolean();
    }
}
