package com.baloise.springfundamentals.handson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaOrder {

    private Integer id;
    private String name;
    private List<String> additionalIngredients;

}
