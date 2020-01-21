package com.baloise.springfundamentals.handson.inventory;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Profile("!mock")
public class RemotePizzaInventoryService implements PizzaInventoryService {

    @Override
    public boolean isAvailable(String pizzaName) {
        return new Random().nextBoolean();
    }
}
