package com.ak.demoGif.model.repository;

import com.ak.demoGif.model.Category;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Repository
public class CategoryRepository {

    public static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(0, "funny"),
            new Category(1, "sport"),
            new Category(2, "IT"),
            new Category(3, "other")
    );

    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }
    public Category getCategoryById(int id) {
        return ALL_CATEGORIES.get(id);
//        for (Category category : ALL_CATEGORIES){
//            if (category.getId() == id) return category;
//        }
//        return new Category(-1, "error");
    }
}
