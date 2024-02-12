package com.example.cardapio.modules.foods.controllers;

import com.example.cardapio.modules.foods.models.Food;
import com.example.cardapio.modules.foods.repositories.FoodRepository;
import com.example.cardapio.modules.foods.dtos.RequestCreateFoodDTO;
import com.example.cardapio.modules.foods.dtos.RequestUpdateFoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("foods")
public class FoodController {

    @Autowired
    private FoodRepository repository;
    @GetMapping
    public List<Food> getAll(){
        return repository.findAll();
    };

    @PostMapping
    public Food createFood(@RequestBody @Validated RequestCreateFoodDTO data) {
        Food food = new Food(data);
        return this.repository.save(food);
    }

    @PutMapping("/{id}")
    public Food updateFood(
            @PathVariable("id") Long id,
            @RequestBody
            @Validated RequestUpdateFoodDTO data
    ){
        Food food = this.repository.findById(id).orElseThrow();

        food.setTitle(data.title());
        food.setImage(data.image());
        food.setPrice(data.price());

        repository.save(food);

        return food;
    }

    @DeleteMapping("/{id}")
    public void deleteFood(
        @PathVariable("id") Long id
    ) {
        Food food = this.repository.findById(id).orElseThrow();

        this.repository.deleteById(food.getId());
    }
}
