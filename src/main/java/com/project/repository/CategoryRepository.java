package com.project.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Category;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
