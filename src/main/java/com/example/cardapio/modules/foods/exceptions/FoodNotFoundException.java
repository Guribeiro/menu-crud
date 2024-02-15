package com.example.cardapio.modules.foods.exceptions;

public class FoodNotFoundException extends RuntimeException{
    public FoodNotFoundException() {
        super("food could not be found");
    }

    public FoodNotFoundException(String message) {
        super(message);
    }

}
