Feature: Staff Feature

Scenario: Navigation to Staff
    Given user di bawa kehalaman utama
    When user klik menu Staff
    Then user berada di halaman Staff

Scenario: Navigation button back from staff Page
    Given user berada di halaman staff Page
    When user klik tombol kembali
    Then user berada di halaman utama, "https://magang.dikahadir.com/apps/absent"