package com.skm.recipeapp.controllers;

import com.skm.recipeapp.domain.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @GetMapping("/getRandomRecipe")
    public Recipe getRandomRecipe(){
        Recipe recipe=new Recipe();

        recipe.setId(1L);
        recipe.setDescription("some recipe");

        return recipe;

    }
}
