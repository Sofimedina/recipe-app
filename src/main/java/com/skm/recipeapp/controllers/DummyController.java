package com.skm.recipeapp.controllers;

import com.skm.recipeapp.domain.Recipe;
import com.skm.recipeapp.repositories.RecipeRepository;
import com.skm.recipeapp.services.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class DummyController {
    private final RecipeService recipeService;

    public DummyController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/getRecipes")
    public Set<Recipe> getRecipes(){

        Set<Recipe> recipes=new HashSet<>();
        recipes=recipeService.getRecipes();
        System.out.println(recipes);

        return null;
    }
}
