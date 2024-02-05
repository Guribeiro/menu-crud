package com.example.cardapio.food.dtos;

public record RequestCreateFoodDTO(
        String title,
        String image,
        Integer price
) {}
