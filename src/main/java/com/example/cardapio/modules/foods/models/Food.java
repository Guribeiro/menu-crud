package com.example.cardapio.modules.foods.models;

import com.example.cardapio.modules.foods.dtos.RequestCreateFoodDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;

    public Food(RequestCreateFoodDTO requestFood){
        this.title = requestFood.title();
        this.image = requestFood.image();
        this.price = requestFood.price();
    }
}
