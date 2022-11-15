package src.persistence;


import src.domain.Category;

import java.util.List;


public interface CategoryDao {
    List<Category> getCategoryList();

    Category getCategory(String var1);
}