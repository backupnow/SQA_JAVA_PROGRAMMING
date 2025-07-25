package com.juaracoding.producttest;

import org.testng.Assert;
import org.testng.annotations.*;

public class AppTest {

    // ThreadLocal
    private final ThreadLocal<Cart>
            cart = ThreadLocal.
            withInitial(Cart::new);
    private final ThreadLocal<Product>
            p1  = ThreadLocal.
            withInitial(() -> new Product("P001", "Headset", 200000));
    private final ThreadLocal<Product>
            p2  = ThreadLocal.
            withInitial(() -> new Product("P002", "Mousepad", 50000));

    @BeforeClass
    public void setupClass() {
        System.out.println("Mulai test...");
    }

    @BeforeMethod
    public void setupTest() {
        // ThreadLocal sudah siap pakai
    }

    @AfterMethod
    public void cleanupTest() {
        cart.remove();
        p1.remove();
        p2.remove();
        System.out.println("Test selesai, keranjang dibersihkan.");
    }

    @Test
    public void testTambahProdukKeKeranjang() {
        cart.get().addProduct(p1.get());
        double actual   = cart.get().totalHarga();
        double expected = 200000.0;
        Assert.assertEquals(actual, expected, "Harga total tidak sesuai!");
    }

    @Test
    public void testHapusProdukDariKeranjang() {
        cart.get().addProduct(p1.get());
        cart.get().addProduct(p2.get());
        cart.get().removeProduct("P001");
        double actual   = cart.get().totalHarga();
        double expected = 50000.0;
        Assert.assertEquals(actual, expected, "Produk gagal dihapus dengan benar!");
    }

    @Test
    public void testKeranjangKosong() {
        double actual   = cart.get().totalHarga();
        double expected = 0.0;
        Assert.assertEquals(actual, expected, "Keranjang harus kosong!");
    }

    @Test
    public void testSetPriceInvalid() {
        double before = p1.get().getPrice();
        p1.get().setPrice(-1000);
        Assert.assertEquals(p1.get().getPrice(), before, "Harga tidak boleh berubah saat set negatif");
    }

    @Test
    public void testHargaNegatif() {
        Product pInvalid = new Product("P003", "Broken Item", -5000);
        cart.get().addProduct(pInvalid);
        double actual   = cart.get().totalHarga();
        double expected = 0.0;
        Assert.assertEquals(actual, expected, "produk negatif tidak boleh ditambahkan");
    }
}
