Feature:  CURA HEALTHCARE 

      Digunakan oleh pasien untuk melakukan pemesanan janji temu 
      dengan fasilitas kesehatan yang tersedia, termasuk memilih program layanan, 
      tanggal kunjungan, dan memberikan komentar tambahan.

Scenario: Sign to Aplikasi Cura HEALTHCARE
    Given pengguna masuk ke halaman login.
    When user klik button make appointment
    And user melakukan login dengan username dan password
    Then user di bawa kehalaman dengan url "https://katalon-demo-cura.herokuapp.com/#appointment"

Scenario: Validasi Melakukan Pemesanan Janji Temu
    Given pengguna berada di halaman dashboard
    When user memilih lokasi fasilitas kesehatan "Seoul CURA Healthcare Center"
    And user ceklis apply for hospital readmission dan ceklis Healthcare program Medicaid
    And user klik icon calender dan memilih tanggal "15/09/2025"
    And user mengisi keterangan "testaja"
    Then user klik tombol booking dan Appointment berhasil di lakukan "Appointment Confirmation"
