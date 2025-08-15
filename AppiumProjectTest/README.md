# Test Cases - SwagLabs eCommerce
* SOURCE APP : https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk
* Link Record : https://drive.google.com/file/d/1ZxwMGW2PiySlV2oBY2xVduD2d0aKe0u4/view?usp=sharing

---

## TC-0010
**Nomor Test Case:** TC-0010
**Nama Fitur/Module:** Zoom Gesture Produk
**Deskripsi:** Memastikan gesture zoom menggunakan W3C PointerInput API dapat dilakukan pada gambar produk.
**Pre Condition:** Pengguna sudah login dan berada di halaman produk.
**Steps:**
1. Login dengan user valid.
2. Pilih salah satu produk untuk melihat detail.
3. Lakukan gesture zoom in pada gambar produk menggunakan W3C PointerInput API (multi-touch dengan 2 jari).
4. Lakukan gesture zoom out pada gambar produk menggunakan W3C PointerInput API.
5. Verifikasi gambar dapat di-zoom dan di-zoom out dengan smooth.
**Data Test:** Username: `standard_user`, Password: `secret_sauce`
**Expected:** Gesture zoom in dan zoom out berhasil dilakukan dengan W3C PointerInput API tanpa error.
**Actual:**
**Priority:** Medium
**Status:** Not Run

---

## Teknologi & Tools Testing

### Environment Setup
- **Virtual Device Manager:** Pixel 6
  - **OS:** Android 13.0 (Tiramisu)
  - **Architecture:** x86_64
  - **API Level:** 33

### Development & Testing Tools
- **Android Studio:** IDE utama untuk development dan debugging
- **Appium:** Server untuk mobile automation testing
- **Appium Inspector:** Tool untuk inspect element dan debugging locator strategies
- **TestNG:** Framework testing untuk Java
- **Maven:** Build automation tool

### Test Execution
- **Command:** `mvn clean test`
- **Test Configuration:** testng.xml
- **Test Reports:** Generated in target/surefire-reports/

### Dependencies (pom.xml)
- **Appium Java Client:** 8.6.0
- **Selenium Java:** 4.15.0
- **TestNG:** 7.8.0
- **WebDriverManager:** 5.6.2

### Testing Scope
- **Platform:** Android Native App
- **Test Type:** End-to-end mobile automation testing
- **Test Coverage:** Login, Inventory, Cart, Checkout flows
- **Device Testing:** Emulated Pixel 6 with Android 13
