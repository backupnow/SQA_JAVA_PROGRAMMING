Feature: Profile Healthcare

    Digunakan oleh pasien untuk melakukan pemesanan janji temu 
    dengan fasilitas kesehatan yang tersedia, termasuk memilih program layanan, 
    tanggal kunjungan, dan memberikan komentar tambahan.


Scenario: Navigasi ke halaman Profile
    Given saya dibawa ke halaman dashboard
    When saya menekan tombol menu di side bar
    And saya menekan tombol menu profile
    Then saya sudah berada di halaman profile