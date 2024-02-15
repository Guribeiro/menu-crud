package com.example.cardapio.modules.foods.controllers;

import com.example.cardapio.modules.foods.dtos.UpdateFoodServiceDTO;
import com.example.cardapio.modules.foods.models.Food;
import com.example.cardapio.modules.foods.dtos.RequestCreateFoodDTO;
import com.example.cardapio.modules.foods.dtos.RequestUpdateFoodDTO;
import com.example.cardapio.modules.foods.services.CreateFoodService;
import com.example.cardapio.modules.foods.services.DeleteFoodService;
import com.example.cardapio.modules.foods.services.ListFoodsService;
import com.example.cardapio.modules.foods.services.UpdateFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("foods")
public class FoodController {
    @Autowired
    private ListFoodsService listFoodsService;
    @Autowired
    private CreateFoodService createFoodService;

    @Autowired
    private UpdateFoodService updateFoodService;

    @Autowired
    private DeleteFoodService deleteFoodService;

    @GetMapping
    public List<Food> getAll(){
        return this.listFoodsService.execute();
    };

    @PostMapping
    public Food createFood(@RequestBody @Validated RequestCreateFoodDTO createFoodDTO) {
        return this.createFoodService.execute(createFoodDTO);
    }

    @PutMapping("/{id}")
    public Food updateFood(
            @PathVariable("id") Long id,
            @RequestBody
            @Validated RequestUpdateFoodDTO updateFoodDTO
    ) throws Exception {
        var updateFoodServiceDTO = new UpdateFoodServiceDTO(id, updateFoodDTO.title(), updateFoodDTO.image(), updateFoodDTO.price());
        return this.updateFoodService.execute(updateFoodServiceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFood(
        @PathVariable("id") Long id
    ) throws Exception{
        this.deleteFoodService.execute(id);
    }
}
