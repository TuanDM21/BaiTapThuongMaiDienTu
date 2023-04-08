package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Cart;
import com.project.model.User;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUser(User user);
}
