package com.example.ecommerce;

import com.example.ecommerce.models.Cart;
import com.example.ecommerce.models.EcommerceApp;
import com.example.ecommerce.models.Product;

import java.util.List;

public class Main {

    private static final int INITIAL_DELAY_SECONDS = 30;
    private static final int PRODUCT_1_ID = 1;
    private static final int PRODUCT_2_ID = 2;
    private static final int PRODUCT_3_ID = 3;
    private static final int PRODUCT_1_AMOUNT = 1;
    private static final int PRODUCT_2_AMOUNT = 1;
    private static final int PRODUCT_3_AMOUNT = 1;

    public static void main(String[] args) {
        EcommerceApp ecommerceApp = EcommerceApp.getInstance();
        System.out.println("Insert new shopping cart --> ");
        Cart newCart = ecommerceApp.createCart();
        List<Cart> cartList = ecommerceApp.getCartList();

        while (!cartList.isEmpty()) {
            ecommerceApp.addProductToCart(newCart.getId(), PRODUCT_1_ID, PRODUCT_1_AMOUNT);
            showShoppingCart(cartList);
            showProductsInStock(ecommerceApp.getProductList());

            ecommerceApp.addProductToCart(newCart.getId(), PRODUCT_2_ID, PRODUCT_2_AMOUNT);
            ecommerceApp.addProductToCart(newCart.getId(), PRODUCT_3_ID, PRODUCT_3_AMOUNT);

            showShoppingCart(cartList);
            showProductsInStock(ecommerceApp.getProductList());

            delay(INITIAL_DELAY_SECONDS);
        }
        System.out.println("The cart is empty");
    }
    private static void showShoppingCart(List<Cart> cartList) {
        cartList.forEach(cart -> System.out.println(" Cart Id --> " + cart.getId() + " || Product List --> " + cart.getCartItem().toString()));
    }

    private static void showProductsInStock(List<Product> productList) {
        productList.forEach(product -> System.out.println("Product description --> " + product.getDescription() + " || In Stock --> " + product.getQuantityInStock()));
    }

    private static void delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}