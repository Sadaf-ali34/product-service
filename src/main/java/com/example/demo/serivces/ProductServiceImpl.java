package com.example.demo.serivces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.enums.Category;
import com.example.demo.enums.Status;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Long create(ProductEntity productEntity) {
		ProductEntity savedProductEntity = productRepository.save(productEntity);
		Long id = savedProductEntity.getId();
		return id;
	}

	@Override
	public ProductEntity getById(Long id) {
		Optional<ProductEntity> optional = productRepository.findById(id);
		boolean isPresent = optional.isPresent();
		if(isPresent) {
			ProductEntity productEntity = optional.get();
			return productEntity;
		}else {
			return null;
		}
	}

	@Override
	public List<ProductEntity> getAll() {
		List<ProductEntity> productList = productRepository.findAll();
		return productList;
	}

	@Override
	public List<ProductEntity> getByName(String name) {
		List<ProductEntity> productList = productRepository.findByName(name);
		return productList;
	}

	@Override
	public List<ProductEntity> getByCategory(Category category) {
		List<ProductEntity> productList = productRepository.findByCategory(category);
		return productList;	
	}

	@Override
	public Status update(Long id, ProductEntity productEntity) {
		ProductEntity storedProductEntity = getById(id);
		if (storedProductEntity != null) {
			storedProductEntity.setCategory(productEntity.getCategory());
			storedProductEntity.setDate(productEntity.getDate());
			storedProductEntity.setName(productEntity.getName());
			storedProductEntity.setTime(productEntity.getTime());
			productRepository.save(storedProductEntity);	
			return Status.SUCCESS;
		} 
		
		return Status.FAILED;
	}

	@Override
	public Status delete(Long id) {
		productRepository.deleteById(id);
		return Status.SUCCESS;
	}

}
