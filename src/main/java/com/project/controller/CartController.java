package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.AddToCartRequest;
import com.project.model.Cart;
import com.project.model.CartProduct;
import com.project.model.User;
import com.project.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@PostMapping
	public ResponseEntity<Cart> createCart(@RequestBody User user) {
		Cart cart = cartService.createCart(user);
		return ResponseEntity.ok(cart);
	}

	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable Long cartId) {
		Cart cart = cartService.getCartById(cartId);
		return ResponseEntity.ok(cart);
	}

	@GetMapping("/{cartId}/products")
	public ResponseEntity<List<CartProduct>> getCartProducts(@PathVariable Long cartId) {
		List<CartProduct> cartProducts = cartService.getCartProducts(cartId);
		return ResponseEntity.ok(cartProducts);
	}

	@PostMapping("/{cartId}/products")
	public ResponseEntity<Void> addProductToCart(@PathVariable Long cartId, @RequestBody AddToCartRequest request) {
		cartService.addProductToCart(cartId, request.getProductId(), request.getQuantity());
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/products/{cartProductId}")
	public ResponseEntity<Void> removeProductFromCart(@PathVariable Long cartProductId) {
		cartService.removeProductFromCart(cartProductId);
		return ResponseEntity.ok().build();
	}
}
