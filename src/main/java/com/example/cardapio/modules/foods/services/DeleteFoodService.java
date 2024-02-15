package com.example.cardapio.modules.foods.services;

import com.example.cardapio.modules.foods.exceptions.FoodNotFoundException;
import com.example.cardapio.modules.foods.models.Food;
import com.example.cardapio.modules.foods.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteFoodService {
    @Autowired
    FoodRepository foodRepository;

    public void execute(Long id) throws FoodNotFoundException{
        Food food = this.foodRepository.findById(id).orElseThrow(FoodNotFoundException::new);

        this.foodRepository.deleteById(food.getId());
    }
}
