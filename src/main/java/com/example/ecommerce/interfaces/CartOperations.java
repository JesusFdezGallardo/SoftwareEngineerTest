package com.example.ecommerce.interfaces;

import com.example.ecommerce.models.Cart;
import com.example.ecommerce.models.Product;

import java.util.List;

public interface CartOperations {
    Cart createCart();

    Cart getCartById(long id);

    void addProductToCart(long cartId, long idProduct, int amount);

    void deleteCart(long cartId);

    List<Cart> getCartList();

    List<Product> getProductList();
}
