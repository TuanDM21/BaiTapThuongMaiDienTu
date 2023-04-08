package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.model.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("from Product")
	public List<Product> getAllProduct();

	@Query("from Product P where P.name LIKE :name or P.price =:price")
	public List<Product> searchProduct(@Param("name") String name, @Param("price") Double price);

}
