package com.project.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Category;
import com.project.repository.CategoryRepository;
import com.project.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService<Category> {
	
	@Autowired
	CategoryRepository CategoryR;

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return CategoryR.findAll();
	}

	@Override
	public Optional<Category> findbyId(Long id) {
		// TODO Auto-generated method stub
		return CategoryR.findById(id);
	}

	@Override
	public Category SaveOrUpdate(Category t) {
		// TODO Auto-generated method stub
		return CategoryR.save(t);
	}

	@Override
	public String delete(Long id) {
		String s = "";
		try {
			CategoryR.deleteById(id);
			s = "delete successfully";
		} catch (Exception e) {
			s= "Unknow id";
			e.printStackTrace();
		}
		return s;
	}

}
