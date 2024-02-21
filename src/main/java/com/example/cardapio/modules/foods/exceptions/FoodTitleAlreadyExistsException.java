package com.example.cardapio.modules.foods.exceptions;

public class FoodTitleAlreadyExistsException extends RuntimeException {
    public FoodTitleAlreadyExistsException() {
        super("food title already in use");
    };

    FoodTitleAlreadyExistsException(String message){
        super(message);
    }

}
