package com.project.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.project.model.Product;

public interface ProductService<T> extends IService<T> {
	public List<Product> getAllProduct();
	
	public List<Product> searchProduct(@Param("name") String name, @Param("price") Double price);

}
