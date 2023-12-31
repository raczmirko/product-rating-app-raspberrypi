package hu.okrim.productratingapp.service;

import hu.okrim.productratingapp.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category getCategoryById(Integer id);
    void addCategory(Category brand);
    List<Category> getAllCategories();
    void deleteCategory(Category brand);
}