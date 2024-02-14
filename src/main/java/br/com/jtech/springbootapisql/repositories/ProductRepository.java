package br.com.jtech.springbootapisql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jtech.springbootapisql.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
