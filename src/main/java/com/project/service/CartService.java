package com.project.service;

import java.util.List;

import com.project.model.Cart;
import com.project.model.CartProduct;
import com.project.model.User;

public interface CartService {
    Cart createCart(User user);

    Cart getCartById(Long cartId);

    List<CartProduct> getCartProducts(Long cartId);

    void addProductToCart(Long cartId, Long productId, Integer quantity);

    void removeProductFromCart(Long cartProductId);
}


