package com.example.demo.serivces;

import java.util.List;

import com.example.demo.entity.ProductEntity;
import com.example.demo.enums.Category;
import com.example.demo.enums.Status;

/*
 * product creation
 * 
 * get product by id | single product
 * get all product | list product
 * get product by name | list
 * get product by category | list
 * 
 * Update product
 * 
 * Delete product
 * 
 * */

public interface ProductService {
	
    Long create(ProductEntity productEntity);
    ProductEntity getById(Long id);
    List<ProductEntity> getAll();
	List<ProductEntity> getByName(String name);
	List<ProductEntity> getByCategory(Category category);
	Status update(Long id, ProductEntity productEntity);
	Status delete(Long id);
	
}
