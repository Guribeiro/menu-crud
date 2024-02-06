package com.example.cardapio.modules.foods.repositories;

import com.example.cardapio.modules.foods.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
