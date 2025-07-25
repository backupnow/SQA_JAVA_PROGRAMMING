package com.juaracoding.producttest;


/*
IntelliJ IDEA 2025.1.2 (Community Edition)
Build #IC-251.26094.121, built on June 3, 2025
@Author HP Wildernes Dakhi
Java Developer
Created on 25/07/2025 1:17
*/

import java.util.Scanner;

public class App {

    public static void main(String[] args){
        // Inisialisasi produk
        Product p1 = new Product("P001", "Keyboard Gaming", 250000);
        Product p2 = new Product("P002", "Mouse Wireless", 150000);
        Product p3 = new Product("P003", "Monitor 24\"", 1750000);

        // Inisialisasi keranjang
        Cart cart = new Cart();

        // Interaksi melalui console (sederhana)
        Scanner scanner = new Scanner(System.in);
        boolean lanjut = true;


        while (lanjut) {
            System.out.println("\n=== MENU TOKO ===");
            System.out.println("1. Tampilkan Produk");
            System.out.println("2. Tambah Produk ke Keranjang");
            System.out.println("3. Tampilkan Keranjang");
            System.out.println("4. Hapus Produk dari Keranjang");
            System.out.println("5. Total Harga");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = Integer.parseInt(scanner.nextLine());
                switch (pilihan) {
                    case 1:
                        // Menampilkan produk yang tersedia
                        System.out.println("Produk Tersedia:");
                        System.out.println("- " + p1.getId() + ": " + p1.getName() + " - Rp " + p1.getPrice());
                        System.out.println("- " + p2.getId() + ": " + p2.getName() + " - Rp " + p2.getPrice());
                        System.out.println("- " + p3.getId() + ": " + p3.getName() + " - Rp " + p3.getPrice());
                        break;
                    case 2:
                        // Menambahkan produk ke keranjang berdasarkan ID
                        System.out.print("Masukkan ID produk: ");
                        String idInput = scanner.nextLine();
                        if (idInput.equalsIgnoreCase(p1.getId())) {
                            cart.addProduct(p1);
                        } else if (idInput.equalsIgnoreCase(p2.getId())) {
                            cart.addProduct(p2);
                        } else if (idInput.equalsIgnoreCase(p3.getId())) {
                            cart.addProduct(p3);
                        } else {
                            System.out.println("Produk tidak ditemukan.");
                        }
                        break;
                    case 3:
                        // Menampilkan isi keranjang
                        cart.showCart();
                        break;
                    case 4:
                        // Hapus produk dari keranjang
                        System.out.print("Masukkan ID produk yang ingin dihapus: ");
                        String removeId = scanner.nextLine();
                        cart.removeProduct(removeId);
                        break;
                    case 5:
                        // Menampilkan total harga
                        double total = cart.totalHarga();
                        System.out.println("Total belanja: Rp " + total);
                        break;
                    case 0:
                        // Keluar dari aplikasi
                        lanjut = false;
                        System.out.println("Terima kasih telah berbelanja!");
                        break;
                    default:
                        System.out.println("Menu tidak tersedia.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harus berupa angka!");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }

        scanner.close();





    }


}
