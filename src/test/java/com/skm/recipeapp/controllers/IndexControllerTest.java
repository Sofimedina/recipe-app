package com.skm.recipeapp.controllers;

import com.skm.recipeapp.domain.Recipe;
import com.skm.recipeapp.repositories.RecipeRepository;
import com.skm.recipeapp.services.RecipeService;
import com.skm.recipeapp.services.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;

class IndexControllerTest {
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    IndexController indexController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        indexController=new IndexController(recipeService);
    }

    @Test
    void getIndexPage() {

        //GIVEN
        Set<Recipe> recipes=new HashSet<>();
        Recipe recipe=new Recipe();
        recipe.setId(1l);
        Recipe recipe2=new Recipe();
        recipe.setId(2l);

        recipes.add(recipe);
        recipes.add(recipe2);

        Mockito.when(recipeService.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor=ArgumentCaptor.forClass(Set.class);

        //WHEN
        String viewName= indexController.getIndexPage(model);

        //Then
        assertEquals("index",viewName);
        Mockito.verify(recipeService,Mockito.times(1)).getRecipes();
        Mockito.verify(model,Mockito.times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
        Set<Recipe> setInController=argumentCaptor.getValue();
        assertEquals(2,setInController.size())  ;
    }
}