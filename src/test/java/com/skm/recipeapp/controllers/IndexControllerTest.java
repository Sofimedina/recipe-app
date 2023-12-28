package com.skm.recipeapp.controllers;

import com.skm.recipeapp.domain.Recipe;
import com.skm.recipeapp.repositories.RecipeRepository;
import com.skm.recipeapp.services.RecipeService;
import com.skm.recipeapp.services.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class IndexControllerTest {
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        recipeService=new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getIndexPage() {

    }

    @Test
    void getRecipes() {

        Recipe recipe=new Recipe();
        Recipe recipe2=new Recipe();
        HashSet recipeData=new HashSet();
        recipeData.add(recipe);
        recipeData.add(recipe2);

        Mockito.when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipeSet=recipeService.getRecipes();

        assertEquals(recipeSet.size(),2);
        Mockito.verify(recipeRepository,Mockito.times(1)).findAll();
    }
}