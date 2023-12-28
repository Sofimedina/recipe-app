package com.skm.recipeapp.services;

import com.skm.recipeapp.domain.Recipe;
import com.skm.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipeServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    RecipeServiceImpl recipeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService=new RecipeServiceImpl(recipeRepository);

    }

    @Test
    void getRecipes() {
        Set<Recipe> recipeAdded=new HashSet<>();
        recipeAdded.add(new Recipe());
        Mockito.when(recipeRepository.findAll()).thenReturn(recipeAdded);
        Set<Recipe> recipes=recipeService.getRecipes();

        assertNotNull(recipes);
        assertEquals(recipes.size(),1);
        Mockito.verify(recipeRepository,Mockito.times(1)).findAll();
    }
}