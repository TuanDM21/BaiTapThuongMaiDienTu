package com.project.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Product;
import com.project.repository.ProductRepository;
import com.project.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService<Product> {

	@Autowired
	ProductRepository ProductR;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		List<Product> list = ProductR.findAll();
		System.out.println(list.size());
		return list;
	}

	@Override
	public Optional<Product> findbyId(Long id) {
		// TODO Auto-generated method stub
		return ProductR.findById(id);
	}

	@Override
	public Product SaveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		return ProductR.save(product);
	}

	@Override
	public String delete(Long id) {
		String s = "";
		try {
			ProductR.deleteById(id);
			s = "delete successfully";
		} catch (Exception e) {
			s = "Unknow id";
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return ProductR.getAllProduct();
	}

	@Override
	public List<Product> searchProduct(String name, Double price) {
		// TODO Auto-generated method stub
		return ProductR.searchProduct(name, price);
	}

}
