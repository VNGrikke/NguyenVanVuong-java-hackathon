package java_web.service;

import java_web.model.Category;
import java_web.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getAllCategories(String name) {
        return categoryRepository.getAllCategories(name);
    }

    @Override
    public boolean addCategory(String name, String description, byte status ) {
        return categoryRepository.addCategory(name, description, status);
    }

    @Override
    public boolean isExisted(String name) {
        return categoryRepository.isExisted(name);
    }


}
