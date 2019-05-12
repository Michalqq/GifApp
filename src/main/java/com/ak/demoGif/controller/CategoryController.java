package com.ak.demoGif.controller;

import com.ak.demoGif.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/categories")
    public String gifCategories (ModelMap modelMap){
        modelMap.put("categories", categoryRepository.getAllCategories());
        return "categories";
    }

}
