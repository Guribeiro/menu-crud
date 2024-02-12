package com.example.cardapio.modules.foods.dtos;

public record RequestCreateFoodDTO(
        String title,
        String image,
        Integer price
) {}
