package com.example.ecommerce.models;

public class Product {
    private final long id;
    private static long nextId;
    private String description;
    private int quantityInStock;

    // Constructor Product
    public Product(String description, int quantityInStock) {
        this.id = nextId();
        this.description = description;
        this.quantityInStock = quantityInStock;
    }

    // Method that iterates the Product id according to each new product created.
    private static long nextId() {
        nextId++;
        return nextId;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void incrementQuantityInStock(int quantity) {
        this.quantityInStock += quantity;
    }

    public void decrementQuantityInStock(int quantity) {
        this.quantityInStock -= quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}