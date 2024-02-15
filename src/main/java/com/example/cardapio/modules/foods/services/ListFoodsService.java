package com.example.cardapio.modules.foods.services;

import com.example.cardapio.modules.foods.models.Food;
import com.example.cardapio.modules.foods.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListFoodsService {
    @Autowired
    FoodRepository foodRepository;
    public List<Food> execute(){
        return this.foodRepository.findAll();
    }
}
