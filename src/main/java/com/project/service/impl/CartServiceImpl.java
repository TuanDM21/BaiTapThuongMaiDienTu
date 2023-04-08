package com.project.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Cart;
import com.project.model.CartProduct;
import com.project.model.Product;
import com.project.model.User;
import com.project.repository.CartProductRepository;
import com.project.repository.CartRepository;
import com.project.repository.ProductRepository;
import com.project.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, CartProductRepository cartProductRepository,
                            ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    @Override
    public List<CartProduct> getCartProducts(Long cartId) {
        return cartProductRepository.findAllByCart_Id(cartId);
    }

    @Override
    public void addProductToCart(Long cartId, Long productId, Integer quantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(EntityNotFoundException::new);
        Product product = productRepository.findById(productId).orElseThrow(EntityNotFoundException::new);

        CartProduct cartProduct = new CartProduct();
        cartProduct.setCart(cart);
        cartProduct.setProduct(product);
        cartProduct.setQuantity(quantity);
        cartProductRepository.save(cartProduct);
    }

    @Override
    public void removeProductFromCart(Long cartProductId) {
        cartProductRepository.deleteById(cartProductId);
    }
}
