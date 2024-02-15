package com.example.cardapio.modules.foods.dtos;

public record UpdateFoodServiceDTO(
        Long id,
        String title,
        String image,
        Integer price
) {}
