package br.com.jtech.springbootapisql.services;

import br.com.jtech.springbootapisql.models.Category;
import br.com.jtech.springbootapisql.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category category) {
        Category obj = categoryRepository.getReferenceById(id);
        obj.setName(category.getName());
        return categoryRepository.save(obj);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }


}
