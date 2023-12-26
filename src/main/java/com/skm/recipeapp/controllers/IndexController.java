package com.skm.recipeapp.controllers;

import com.skm.recipeapp.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private final CategoryRepository categoryRepository;

    public IndexController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){
        System.out.println("Id:"+this.categoryRepository.findByDescription("Italian").get().getId());
        return "index";
    }




}
