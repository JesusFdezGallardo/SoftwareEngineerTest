package com.example.ecommerce.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Cart {
    private final long id;
    private static long nextId;
    private List<CartItem> cartItems;
    private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    // Constructor Cart
    public Cart() {
        this.id = nextId();
        this.cartItems = new ArrayList<>();
        executor.schedule(this::deleteCart, 10, TimeUnit.MINUTES);
    }

    // Method that iterates the Cart id according to each new cart created.
    private static long nextId() {
        nextId++;
        return nextId;
    }

    public long getId() {
        return id;
    }

    public List<CartItem> getCartItem() {
        return cartItems;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartItems=" + cartItems +
                '}';
    }

    private void deleteCart() {
        System.out.println("Cart " + id + " deleted.");
        EcommerceApp.getInstance().deleteCart(id);
    }

}
