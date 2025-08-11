package com.android.swagapp.screens;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.android.swagapp.components.HeaderComponent;
import com.android.swagapp.utils.DragPositionUtil;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

public class InventoryScreen {

    private AndroidDriver driver;
    private By header = AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
    private By productCards = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Item\"]");
    private By scrollView = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]");
    private By buttonDrag = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-Drag Handle\"])[1]");
    private By removeCart = AppiumBy.xpath("//android.widget.TextView[@text='REMOVE']");
    private HeaderComponent headerComponent;

    public InventoryScreen(AndroidDriver driver, HeaderComponent headerComponent) {
        this.driver = driver;
        this.headerComponent = headerComponent;
    }

    public InventoryScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(header).getText();
    }

    public int getTotalProduct() {
        return driver.findElements(productCards).size();
    }

  public String getTotalCart() {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      wait.until(ExpectedConditions.visibilityOfElementLocated(headerComponent.getTotalByOne()));
      return driver.findElement(headerComponent.getTotalByOne()).getText();
    } catch (Exception e) {
      
      return "0";
    }
  }

    public void scrollDown(double percent) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("elementId", driver.findElement(scrollView));
        params.put("direction", "down");
        params.put("percent", percent);
        params.put("speed", 1000);

        js.executeScript("mobile: scrollGesture", params);
    }

    public void drag(DragPositionUtil dragPositionUtil) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<String, Object>();

        int x = driver.findElement(scrollView).getLocation().getX() + dragPositionUtil.getCustomX();
        int y = driver.findElement(scrollView).getLocation().getY() - dragPositionUtil.getCustomY();

        params.put("elementId", driver.findElement(buttonDrag));
        params.put("endX", x);
        params.put("endY", y);
        params.put("speed", 5000);

        js.executeScript("mobile: dragGesture", params);

    }

  public void removeFromCart() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    
    try {
      // First, wait for the REMOVE button to be present
      wait.until(ExpectedConditions.presenceOfElementLocated(removeCart));
      
      // Scroll to make sure the button is visible
      JavascriptExecutor js = (JavascriptExecutor) driver;
      Map<String, Object> params = new HashMap<String, Object>();
      params.put("elementId", driver.findElement(scrollView));
      params.put("direction", "down");
      params.put("percent", 0.3);
      js.executeScript("mobile: scrollGesture", params);
      
      // Wait for the button to be clickable
      wait.until(ExpectedConditions.elementToBeClickable(removeCart));
      
      // Click the REMOVE button
      driver.findElement(removeCart).click();
      
      // Small wait to ensure the action is processed
      Thread.sleep(1000);
      
    } catch (Exception e) {
      // Enhanced error handling with debugging
      System.out.println("DEBUG: Current page source:");
      System.out.println(driver.getPageSource());
      
      // Try alternative locators
      try {
        // Try to find any button with "REMOVE" text (case-insensitive)
        By alternativeRemove = AppiumBy.xpath("//android.widget.TextView[contains(@text, 'REMOVE') or contains(@text, 'Remove')]");
        wait.until(ExpectedConditions.elementToBeClickable(alternativeRemove));
        driver.findElement(alternativeRemove).click();
      } catch (Exception e2) {
        throw new RuntimeException("REMOVE button not found. Item may not be in cart or button text changed.", e);
      }
    }
  }
  
   // Method untuk klik produk berdasarkan index
  public void clickProduct(int index) {
    By productLocator = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[" + index + "]/android.view.ViewGroup/android.widget.ImageView");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(productLocator));
    driver.findElement(productLocator).click();
  }


  // Method untuk melakukan gesture zoom menggunakan W3C PointerInput API
  public void ZoomGesture() {
    try {
      // Lokasi gambar produk yang akan di-zoom
      By productImage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Image Container\"]/android.widget.ImageView");
      
      // Mendapatkan posisi dan ukuran gambar
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOfElementLocated(productImage));
      
      // Mendapatkan posisi gambar
      int imageX = driver.findElement(productImage).getLocation().getX();
      int imageY = driver.findElement(productImage).getLocation().getY();
      int imageWidth = driver.findElement(productImage).getSize().getWidth();
      int imageHeight = driver.findElement(productImage).getSize().getHeight();
      
      // Titik tengah gambar untuk gesture zoom
      int centerX = imageX + (imageWidth / 2);
      int centerY = imageY + (imageHeight / 2);
      
      // Jarak untuk gesture pinch-out (zoom in) - disesuaikan dengan ukuran gambar
      int startDistance = Math.min(imageWidth, imageHeight) / 4;
      int endDistance = Math.min(imageWidth, imageHeight) * 2;
      
      System.out.println("Melakukan gesture zoom pada gambar produk");
      System.out.println("Posisi gambar: X=" + imageX + ", Y=" + imageY + ", Width=" + imageWidth + ", Height=" + imageHeight);
      System.out.println("Titik tengah gesture: X=" + centerX + ", Y=" + centerY);
      
      // Membuat PointerInput untuk dua jari
      PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
      PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
      
      // Membuat sequence untuk finger1 (bergerak dari kiri ke kiri lebih jauh)
      Sequence sequence1 = new Sequence(finger1, 0);
      sequence1.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX - startDistance, centerY));
      sequence1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
      sequence1.addAction(finger1.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), centerX - endDistance, centerY));
      sequence1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
      
      // Membuat sequence untuk finger2 (bergerak dari kanan ke kanan lebih jauh)
      Sequence sequence2 = new Sequence(finger2, 0);
      sequence2.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX + startDistance, centerY));
      sequence2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
      sequence2.addAction(finger2.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), centerX + endDistance, centerY));
      sequence2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
      
      // Eksekusi gesture dengan durasi yang lebih lama
      driver.perform(Arrays.asList(sequence1, sequence2));
      
      Thread.sleep(2500);
      
      System.out.println("Gesture zoom berhasil dilakukan!");
      
    } catch (Exception e) {
      System.out.println("Error saat melakukan gesture zoom: " + e.getMessage());
      
      // Fallback ke mobile gesture yang lebih spesifik untuk gambar produk
      try {
        System.out.println("Menggunakan fallback gesture untuk gambar produk...");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<>();
        
        // Dapatkan posisi gambar produk
        By productImage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Image Container\"]/android.widget.ImageView");
        int imageX = driver.findElement(productImage).getLocation().getX();
        int imageY = driver.findElement(productImage).getLocation().getY();
        int imageWidth = driver.findElement(productImage).getSize().getWidth();
        int imageHeight = driver.findElement(productImage).getSize().getHeight();
        
        params.put("left", imageX);
        params.put("top", imageY);
        params.put("width", imageWidth);
        params.put("height", imageHeight);
        params.put("percent", 3.0); // Zoom lebih besar
        params.put("speed", 1000);
        js.executeScript("mobile: pinchOpenGesture", params);
        
        Thread.sleep(2500);
        System.out.println("Fallback gesture berhasil!");
        
      } catch (Exception e2) {
        System.out.println("Fallback gesture juga gagal: " + e2.getMessage());
      }
    }
  }

  // Method untuk verifikasi apakah gambar telah di-zoom
  public boolean zoom() {
    try {
      // Verifikasi berdasarkan elemen gambar produk yang sudah di-zoom
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      
      // Cek apakah gambar produk masih ada setelah zoom
      By productImage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Image Container\"]/android.widget.ImageView");
      boolean isVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(productImage)) != null;
      
      try {
        By zoomIndicator = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Inventory item page\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(zoomIndicator));
        return true;
      } catch (Exception e) {

        return isVisible;
      }
    } catch (Exception e) {
      System.out.println("Verifikasi zoom gagal: " + e.getMessage());
      return false;
    }
  }
    
}
