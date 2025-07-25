// package com.juaracoding.ecom;

// import org.openqa.selenium.WebDriver;
// import org.testng.Assert;
// import org.testng.annotations.Listeners;
// import org.testng.annotations.Test;

// import com.juaracoding.ecom.pages.LoginPage;
// import com.juaracoding.ecom.utils.DriverManager;


// @Listeners(ListenerTest.class)
// public class InventoryAddToCartTest {

//     @Test
//     public void testAddToCartFunctionality() {
//         DriverManager driverManager = new DriverManager();
//         WebDriver driver = driverManager.getDriver();

//         driver.get("https://www.saucedemo.com/v1/index.html");

//         try {
//             Thread.sleep(3000); // delay 3 detik
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }

//         LoginPage loginPage = new LoginPage(driver);
//         loginPage.performLogin("standard_user", "secret_sauce");

//         // InventoryPage inventoryPage = new InventoryPage(driver);
//         // Klik tombol "Add to Cart" pada produk pertama
//         driver.findElement(org.openqa.selenium.By.cssSelector(".inventory_item:first-child button.btn_inventory")).click();

//         // Tambahkan delay untuk mengamati perubahan ikon keranjang dan teks tombol
//         try {
//             Thread.sleep(3000); // delay 3 detik
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         }

//         // Pastikan ikon keranjang menunjukkan angka 1
//         String cartCount = driver.findElement(org.openqa.selenium.By.className("shopping_cart_badge")).getText();
//         Assert.assertEquals(cartCount, "1", "Ikon keranjang harus menunjukkan 1 item");

//         // Cetak hasil aktual ke log
//         System.out.println("Actual cart count: " + cartCount);

//         // Pastikan teks tombol berubah menjadi "Remove"
//         String buttonText = driver.findElement(org.openqa.selenium.By.cssSelector(".inventory_item:first-child button.btn_inventory")).getText();
//         Assert.assertEquals(buttonText.toLowerCase(), "remove", "Teks tombol harus berubah menjadi 'Remove'");

//         // Cetak hasil aktual ke log
//         System.out.println("Actual button text: " + buttonText);

//         driverManager.quitDriver();
//     }
// }
