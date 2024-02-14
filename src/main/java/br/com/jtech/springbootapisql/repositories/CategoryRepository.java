package br.com.jtech.springbootapisql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jtech.springbootapisql.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
