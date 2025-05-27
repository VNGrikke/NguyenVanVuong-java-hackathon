package java_web.repository;

import java_web.model.Category;

import java.util.List;


public interface CategoryRepository {
    List<Category> getAllCategories(String name);
    boolean addCategory(String name, String description, byte status);
    boolean isExisted(String name);
}
