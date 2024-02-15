package com.example.cardapio.modules.foods.services;

import com.example.cardapio.modules.foods.dtos.RequestUpdateFoodDTO;
import com.example.cardapio.modules.foods.dtos.UpdateFoodServiceDTO;
import com.example.cardapio.modules.foods.exceptions.FoodNotFoundException;
import com.example.cardapio.modules.foods.models.Food;
import com.example.cardapio.modules.foods.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateFoodService {

    @Autowired
    FoodRepository foodRepository;
    public Food execute(UpdateFoodServiceDTO updateFoodDTO) throws FoodNotFoundException{
        Food food = this.foodRepository.findById(updateFoodDTO.id()).orElseThrow(FoodNotFoundException::new);

        food.setTitle(updateFoodDTO.title());
        food.setImage(updateFoodDTO.image());
        food.setPrice(updateFoodDTO.price());

        foodRepository.save(food);

        return food;
    }
}
