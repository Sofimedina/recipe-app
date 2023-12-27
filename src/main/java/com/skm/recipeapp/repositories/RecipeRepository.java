package com.skm.recipeapp.repositories;

import com.skm.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
    @Override
    Set<Recipe> findAll();
}
