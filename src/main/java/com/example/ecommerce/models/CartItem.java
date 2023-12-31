package com.example.ecommerce.models;

public class CartItem {
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int amount){
        this.quantity = quantity + amount;
    }
    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product.getDescription() +
                ", quantity=" + quantity +
                '}';
    }
}
