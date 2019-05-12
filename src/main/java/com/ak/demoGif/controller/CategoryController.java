package com.ak.demoGif.controller;

import com.ak.demoGif.model.repository.CategoryRepository;
import com.ak.demoGif.model.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GifRepository gifRepository;

    @RequestMapping("/categories")
    public String gifCategories(ModelMap modelMap) {
        modelMap.put("categories", categoryRepository.getAllCategories());
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String gifsCategory(@PathVariable int id, ModelMap modelMap) {
        modelMap.put("gifs", gifRepository.getGifsByCategoryId(id));
        // 1. Pobranie gifów z id danej kategorii
        modelMap.put("category", categoryRepository.getCategoryById(id));
        // 2. Pobranie kategorii po id
        return "category";
    }
}
