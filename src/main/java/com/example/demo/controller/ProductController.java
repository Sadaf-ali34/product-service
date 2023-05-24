package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductEntity;
import com.example.demo.enums.Category;
import com.example.demo.enums.Status;
import com.example.demo.serivces.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public Long create(@RequestBody ProductEntity productEntity){
		return productService.create(productEntity);	
	}
	
	@GetMapping("/id")
	public ProductEntity getById(@RequestParam Long id) {
		return productService.getById(id);
	}
	
	@GetMapping("/all")
	public List<ProductEntity> getAll(){
		return productService.getAll();
	}
	
	@GetMapping("/name")
	public List<ProductEntity> getByName(String name){
		return productService.getByName(name);
	}
	
	@GetMapping("/category")
	public List<ProductEntity> getByCategory(Category category){
		return productService.getByCategory(category);
	}
	
	@PutMapping
	public Status update(Long id, ProductEntity productEntity) {
		return productService.update(id, productEntity);
	}
	
	@DeleteMapping
	public Status delete(Long id) {
		return productService.delete(id);
	}
}
