package com.example.cardapio.modules.foods.services;


import com.example.cardapio.modules.foods.dtos.RequestCreateFoodDTO;
import com.example.cardapio.modules.foods.exceptions.FoodTitleAlreadyExistsException;
import com.example.cardapio.modules.foods.models.Food;
import com.example.cardapio.modules.foods.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateFoodService {

    @Autowired
    FoodRepository foodRepository;

    public Food execute(RequestCreateFoodDTO createFoodDTO) {
        Food foodWithSameTitle = foodRepository.findByTitle(createFoodDTO.title());

        if(foodWithSameTitle != null){
            throw new FoodTitleAlreadyExistsException();
        }

        Food food = new Food(createFoodDTO);
        return this.foodRepository.save(food);
    }
}
