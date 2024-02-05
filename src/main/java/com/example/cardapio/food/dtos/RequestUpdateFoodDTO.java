package com.example.cardapio.food.dtos;

public record RequestUpdateFoodDTO(

        Long id,
        String title,
        String image,
        Integer price
) {}
