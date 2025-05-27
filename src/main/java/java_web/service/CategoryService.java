package java_web.service;

import java_web.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories(String name);
    boolean addCategory(String name, String description, byte status);
    boolean isExisted(String name);
}
