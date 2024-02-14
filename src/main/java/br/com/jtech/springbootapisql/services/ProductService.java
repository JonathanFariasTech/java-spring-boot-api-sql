package br.com.jtech.springbootapisql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jtech.springbootapisql.models.Product;
import br.com.jtech.springbootapisql.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		return productRepository.findById(id).orElseThrow(IllegalArgumentException::new);
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateProduct(Long id, Product updProduct) {
		Product obj = productRepository.getReferenceById(id);
		obj.setName(updProduct.getName());
		obj.setDescription(updProduct.getDescription());
		obj.setPrice(updProduct.getPrice());
		obj.setImgUrl(updProduct.getImgUrl());
		return productRepository.save(obj);
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
