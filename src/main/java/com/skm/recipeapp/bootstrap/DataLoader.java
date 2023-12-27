package com.skm.recipeapp.bootstrap;

import com.skm.recipeapp.domain.*;
import com.skm.recipeapp.repositories.CategoryRepository;
import com.skm.recipeapp.repositories.RecipeRepository;
import com.skm.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;


    public DataLoader(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {




        Recipe recipeGuacamole = new Recipe();
        recipeGuacamole.setDescription("Advocado recipe");
        recipeGuacamole.setPrepTime(20);
        recipeGuacamole.setCookTime(0);
        recipeGuacamole.setDifficulty(Difficulty.EASY);
        recipeGuacamole.setDirections("Cut the avocados:blaa bla bla");

        Note guacamoleNotes=new Note();
        guacamoleNotes.setRecipeNotes("have fun");
        guacamoleNotes.setRecipe(recipeGuacamole);
        recipeGuacamole.setNotes(guacamoleNotes);


        recipeGuacamole.getIngredients().add(new Ingredient("advocado",new BigDecimal(2),recipeGuacamole,unitOfMeasureRepository.findByDescription("Whole").get()));
        recipeGuacamole.getIngredients().add(new Ingredient("cilantro",new BigDecimal(2),recipeGuacamole,unitOfMeasureRepository.findByDescription("Tablespoon").get()));

        recipeGuacamole.getCategories().add(categoryRepository.findByDescription("Mexican").get());

        recipeRepository.save(recipeGuacamole);


    }
}
