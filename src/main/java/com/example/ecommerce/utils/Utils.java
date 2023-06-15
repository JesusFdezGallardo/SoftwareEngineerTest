package com.example.ecommerce.utils;

import com.example.ecommerce.models.Cart;
import com.example.ecommerce.models.Product;

import java.util.ArrayList;
import java.util.List;


public class Utils {
    public static String ERROR_CART_NOT_FOUND = "Cart with the specified ID was not found.";
    public static String ERROR_PRODUCT_NOT_FOUND = "Product with the specified ID was not found.";
    public static String ERROR_PRODUCT_NOT_STOCK = "Insufficient stock for product: ";
    /**
     * Method to create an empty ArrayList or to be able to add generic shopping carts
     *
     * @return
     */
    public static List<Cart> addBasicCart() {
        List<Cart> salida = new ArrayList<>();
        return salida;
    }

    /**
     * Method to create a list of products available in the shop
     * @return
     */
    public static List<Product> addProducts() {
        List<Product> salida = new ArrayList<>();
        Product product1 = new Product("Batería de portátil", 100);
        salida.add(product1);
        Product product2 = new Product("Cargador de móvil", 100);
        salida.add(product2);
        Product product3 = new Product("Boligrafo bic", 100);
        salida.add(product3);
        return salida;
    }
}
