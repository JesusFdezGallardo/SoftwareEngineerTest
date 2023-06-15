package com.example.ecommerce.models;

import com.example.ecommerce.exceptions.EcommerceAppException;
import com.example.ecommerce.interfaces.CartOperations;
import com.example.ecommerce.utils.Utils;
import jdk.jshell.execution.Util;

import java.util.List;
import java.util.Optional;

public class EcommerceApp implements CartOperations {

    private final List<Cart> cartList;
    private final List<Product> productList;
    private static EcommerceApp instance;

    public EcommerceApp() {
        this.cartList = Utils.addBasicCart();
        this.productList = Utils.addProducts();
    }

    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        cartList.add(cart);
        System.out.println("cart inserted with id --> " + cart.getId());
        return cart;
    }

    @Override
    public Cart getCartById(long id) {
        Optional<Cart> optionalCart = cartList.stream()
                .filter(cart -> cart.getId() == id)
                .findFirst();
        return optionalCart.orElseThrow(() -> new EcommerceAppException(Utils.ERROR_CART_NOT_FOUND + id));
    }

    /**
     * Add products to cart
     * @param cartId
     * @param productId
     * @param quantity
     */
    @Override
    public void addProductToCart(long cartId, long productId, int quantity) {
        Cart cart = getCartById(cartId);
        Product product = getProductById(productId);

        if (product.getQuantityInStock() < quantity) {
            throw new EcommerceAppException(Utils.ERROR_PRODUCT_NOT_STOCK + product.getDescription());
        }

        Optional<CartItem> optionalCartItem = getCartItemByProductId(cart, productId);
        // If the product is already in the shopping cart, we will increase the quantity
        if (optionalCartItem.isPresent()) {
            CartItem cartItem = optionalCartItem.get();
            cartItem.setQuantity(quantity);
        } else {
            CartItem cartItem = new CartItem(product, quantity);
            cart.getCartItem().add(cartItem);
        }

        product.decrementQuantityInStock(quantity);

        System.out.println(Utils.NEW_PRODUCT + cart.getId());
    }

    /**
     * Get Product by ID
     * @param productId
     * @return
     */
    private Product getProductById(long productId) {
        return productList.stream()
                .filter(product -> product.getId() == productId)
                .findFirst()
                .orElseThrow(() -> new EcommerceAppException(Utils.ERROR_PRODUCT_NOT_FOUND + productId));
    }

    /**
     * Get products from cart by id
     * @param cart
     * @param productId
     * @return
     */
    private Optional<CartItem> getCartItemByProductId(Cart cart, long productId) {
        return cart.getCartItem().stream()
                .filter(cartItem -> cartItem.getProduct().getId() == productId)
                .findFirst();
    }

    /**
     * Delete Cart by ID
     * @param cartId
     */
    @Override
    public void deleteCart(long cartId) {
        Optional<Cart> optionalCart = cartList.stream()
                .filter(cart -> cart.getId() == cartId)
                .findFirst();
        Cart cart = optionalCart.orElseThrow(() -> new EcommerceAppException(Utils.ERROR_CART_NOT_FOUND + cartId));
        cartList.remove(cart);

    }

    /**
     * Get all carts from the list
     * @return
     */
    @Override
    public List<Cart> getCartList() {
        return cartList;
    }

    /**
     * Get all products from the list
     * @return
     */
    @Override
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * Get instance
     * @return
     */
    public static EcommerceApp getInstance() {
        if (instance == null) {
            instance = new EcommerceApp();
        }
        return instance;
    }
}