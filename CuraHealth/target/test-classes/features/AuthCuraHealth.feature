Feature: Cura Healthcare

    Digunakan oleh pasien untuk melakukan pemesanan janji temu 
    dengan fasilitas kesehatan yang tersedia, termasuk memilih program layanan, 
    tanggal kunjungan, dan memberikan komentar tambahan.

 Scenario Outline: Negative Sign In Aplikasi Cura Healthcare
    Given user masuk ke halaman login.
    When pengguna memasukkan username "<username>".
    And pengguna memasukkan password "<password>".
    And pengguna menekan tombol masuk.
    Then pengguna akan melihat pesan kesalahan "<errorMessage>".

    Examples:
      | username               | password           | errorMessage                                                      |
      | John Doe               | ThisIsYesAPassword | Login failed! Please ensure the username and password are valid.  |
      | John Lade              | 123ijii            | Login failed! Please ensure the username and password are valid.  |
      |                        | ThisIsNotAPassword | Login failed! Please ensure the username and password are valid.  |
      | John Doe               |                    | Login failed! Please ensure the username and password are valid.  |
      |                        |                    | Login failed! Please ensure the username and password are valid.  |