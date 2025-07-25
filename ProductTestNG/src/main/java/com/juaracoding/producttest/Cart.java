package com.juaracoding.producttest;

import java.util.ArrayList;

import java.util.List;


/*
IntelliJ IDEA 2025.1.2 (Community Edition)
Build #IC-251.26094.121, built on June 3, 2025
@Author HP Wildernes Dakhi
Java Developer
Created on 25/07/2025 1:12
*/

public class Cart {

    private List<Product> cartItems = new ArrayList<>();

    public void addProduct(Product product) {
        if (product != null) {
            cartItems.add(product);
            System.out.println("Produk ditambahkan ke keranjang: " + product.getName());
        } else {
            System.out.println("Produk tidak valid, gagal ditambahkan.");
        }
    }

    public void removeProduct(String productId) {
        cartItems.removeIf(p -> p.getId().equals(productId));
        System.out.println("Produk dengan ID " + productId + " dihapus dari keranjang.");
    }

    public void showCart() {
        System.out.println("Isi keranjang:");
        if (cartItems.isEmpty()) {
            System.out.println("- Keranjang masih kosong");
        } else {
            for (Product p : cartItems) {
                System.out.println("- " + p.getName() + " (Harga: " + p.getPrice() + ")");
            }
        }
    }

    public double totalHarga() {
        double total = 0;
        for (Product p : cartItems) {
            total += p.getPrice();
        }
        return total;
    }
}
