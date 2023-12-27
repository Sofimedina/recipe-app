package com.skm.recipeapp.controllers;

import com.skm.recipeapp.repositories.CategoryRepository;
import com.skm.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"","/","/index"})
    public String getIndexPage(){

        return "index";
    }




}
