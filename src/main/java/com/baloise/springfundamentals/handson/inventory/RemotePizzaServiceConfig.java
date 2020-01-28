package com.baloise.springfundamentals.handson.inventory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RemotePizzaServiceConfig {

    @Bean
    @Profile("!mock")
    public PizzaInventoryService bla() {
        return new RemotePizzaInventoryService();
    }
}
