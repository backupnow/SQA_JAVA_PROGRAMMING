package com.juaracoding.producttest;


/*
IntelliJ IDEA 2025.1.2 (Community Edition)
Build #IC-251.26094.121, built on June 3, 2025
@Author HP Wildernes Dakhi
Java Developer
Created on 25/07/2025 1:08
*/

public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        try {
            if (price < 0) {
                throw new IllegalArgumentException("Harga produk tidak boleh negatif!");
            }
            this.id = id;
            this.name = name;
            this.price = price;
        } catch (IllegalArgumentException e) {
            System.err.println("Error saat membuat produk: " + e.getMessage());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        try {
            if (price < 0) {
                throw new IllegalArgumentException("Harga produk tidak valid.");
            }
            this.price = price;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
