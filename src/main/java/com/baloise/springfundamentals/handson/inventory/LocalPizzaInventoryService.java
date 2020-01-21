package com.baloise.springfundamentals.handson.inventory;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("mock")
public class LocalPizzaInventoryService implements PizzaInventoryService {

    @Override
    public boolean isAvailable(String pizzaName) {
        return true;
    }
}
