package com.baloise.springfundamentals.handson.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PizzaOrder {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ElementCollection
    private List<String> additionalIngredients;

}
