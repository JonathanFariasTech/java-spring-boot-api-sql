package br.com.jtech.springbootapisql.controllers;

import br.com.jtech.springbootapisql.models.Category;
import br.com.jtech.springbootapisql.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping(value = "/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category cat = categoryService.findById(id);
        return ResponseEntity.ok(cat);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category cat = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(cat);
    }

    @PutMapping(value = "/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category updCategory) {
        Category updCat = categoryService.updateCategory(id, updCategory);
        return ResponseEntity.ok(updCat);
    }

    @DeleteMapping(value = "/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }


}
