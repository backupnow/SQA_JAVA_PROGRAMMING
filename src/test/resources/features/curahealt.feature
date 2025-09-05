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
    Given pengguna berada di halaman dashboard.
    When user memilih lokasi fasilitas kesehatan "Seoul CURA Healthcare Center"
    And user ceklis apply for hospital readmission dan ceklis Healthcare program Medicaid
    And user klik icon calender dan memilih tanggal "15/09/2025"
    And user mengisi keterangan "testaja"
    Then user klik tombol booking dan Appointment berhasil di lakukan "Appointment Confirmation"

Scenario: Log out from Aplikasi Cura Healthcare
    Given user berada di halaman dashboard
    When user menekan tombol menu samping
    And user menekan tombol logout
    Then user telah keluar dari halaman login

Scenario: Melakukan Scroll down
    Given user di bawa kehalaman dashboard
    When user melakukan Scroll kebawah dan keatas
    Then user berhasil melakukan Scroll

Scenario: User melakukan pemesanan tanpa isi from
      Given pengguna ada di halaman dashboard
      When pengguna melakukan Scroll pada halaman dashboard
      And user klik tombol booking tanpa mengisi data
      Then user melihat pesan error "Please fill out this field"