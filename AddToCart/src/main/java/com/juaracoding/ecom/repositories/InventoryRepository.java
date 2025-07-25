package com.juaracoding.ecom.repositories;


import org.openqa.selenium.By;

public class InventoryRepository {
    public static By inventoryItem = By.xpath("//div[@class='inventory_item']");
    public static By inventoryItemName = By.xpath("//div[@class='inventory_item_name']");
    public static By productSortContainer = By.xpath("//select[@class='product_sort_container']");

    // Tambahkan elemen untuk tombol "Add to Cart" dan badge keranjang
    public static By addToCartButton = By.cssSelector(".btn_inventory");
    public static By cartBadge = By.className("shopping_cart_badge");
    
}
