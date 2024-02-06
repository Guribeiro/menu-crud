package com.example.cardapio.modules.foods.dtos;

public record RequestUpdateFoodDTO(

        Long id,
        String title,
        String image,
        Integer price
) {}
