package com.example.Cardapio.controller;


import com.example.Cardapio.foods.Food;
import com.example.Cardapio.foods.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){

        Food foodData = new Food(data);
        repository.save(foodData);

    }

    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();

        //Retorna a lista de comida '-'
        return foodList;

    }

}
