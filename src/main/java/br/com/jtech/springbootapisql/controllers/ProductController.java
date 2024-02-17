package br.com.jtech.springbootapisql.controllers;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jtech.springbootapisql.models.Product;
import br.com.jtech.springbootapisql.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> findAll() {
		return productService.findAll();
	}
	
	@GetMapping(value = "/id/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product prod = productService.findById(id);
		return ResponseEntity.ok(prod);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product crProd = productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(crProd);
	}
	
	@PutMapping("/id/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product updProd = productService.updateProduct(id, product);
		return ResponseEntity.ok(updProd);
	}
	
	@DeleteMapping("/id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
}
