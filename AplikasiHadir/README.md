# ✅ Aplikasi Hadir

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Java Version](https://img.shields.io/badge/java-11%2B-blue)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

Aplikasi Hadir adalah project automation testing berbasis web untuk sistem absensi online. Dibangun dengan pendekatan **BDD (Behavior Driven Development)** menggunakan Cucumber, Selenium WebDriver, dan TestNG, project ini bertujuan untuk memastikan kualitas aplikasi HADIR melalui skenario pengujian yang mudah dibaca dan dijalankan.

---

## 🚀 Cara Menjalankan Test

```bash
mvn clean test

---
🧰 Teknologi yang Digunakan : 
Teknologi	Fungsi
Java	    Bahasa pemrograman utama
Selenium    WebDriver Automasi browser untuk simulasi interaksi pengguna
Cucumber	Framework BDD untuk menulis skenario dalam format Gherkin
TestNG	    Test runner untuk mengelola eksekusi dan struktur test
Extent      Report Laporan hasil test dalam format HTML, PDF, dan screenshot

---
🖥️ Persiapan Environment Lokal

Sebelum menjalankan project, pastikan Anda memiliki:
✅ Java JDK 11 atau lebih tinggi
✅ Maven
✅ Firefox Browser
✅ IDE seperti VSCode atau IntelliJ IDEA
✅ Koneksi internet aktif

---
🔹 Dependencies
slf4j-simple: Logging ringan untuk debugging
testng: Framework test runner
cucumber-java & cucumber-testng: Integrasi Cucumber dengan Java dan TestNG
selenium-java: Automasi browser
extentreports: Membuat laporan test interaktif
extentreports-cucumber7-adapter: Integrasi laporan Extent dengan Cucumber v7

---
🔹 Plugins
maven-surefire-plugin: Menjalankan test suite XML
maven-javadoc-plugin: Membuat dokumentasi Java
maven-surefire-report-plugin: Membuat laporan hasil test
maven-project-info-reports-plugin: Menyediakan informasi proyek seperti dependensi dan konfigurasi build

📄 Laporan Test 
Setelah test dijalankan, laporan akan tersedia di folder target/ dalam format:

📄 HTML Report
📄 PDF Report
📸 Screenshot untuk skenario yang gagal

Laporan ini dihasilkan oleh Extent Report dan dapat digunakan untuk review hasil pengujian oleh tim QA maupun stakeholder.

