package com.skm.recipeapp.services;

import com.skm.recipeapp.domain.Recipe;
import com.skm.recipeapp.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

public interface RecipeService {
    public Set<Recipe> getRecipes();

}
