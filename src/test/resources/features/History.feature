Feature:  History menu

        Untuk melihat hasil History dari submit yang telah di Appointment

Scenario: Navigasi ke Halaman History
    Given user dibawa ke halaman history
    Then user melihat halaman history "History".

Scenario: Navigasi From History go to Home Page
        Given user berada di halaman History
        When user menekan tombol Go To Homepage
        Then user sudah berada di halaman Home

Scenario: Negative : User melihat tidak ada form data Appointment di History
        Given user berada di halaman dashboard.
        When user klik tombol menu samping
        And user klik menu History
        Then user berada di halaman history tanpa data Appointment "No appointment."

Scenario: Validasi Menampilkan Riwayat Pengajuan di Halaman History by Date
        Given pengguna berada di halaman dashboard
        When pengguna melakukan submit data "<facility>" dan "<keterangan>" serta "<tanggal>"
        And user klik tombol booking Appoinment
        And user klik menu History di side bar
        Then user berada di halaman History dan data history tersedia "<dataHistory>"

        Examples:
      | facility                        | keterangan | tanggal          | dataHistory   |
      | Hongkong CURA Healthcare Center | dadada     | 30/09/2025       | 30/09/2025    |
      | Tokyo CURA Healthcare Center    | test123    | 20/10/2025       | 20/10/2025    |
      | Seoul CURA Healthcare Center    | kwkwkwk    | 18/11/2025       | 18/11/2025    |
      
Scenario Outline: Validasi Riwayat History dengan labels dan value
        Given pengguna ada di halaman dashboard.
        When pengguna mengisi form data, facility "Hongkong CURA Healthcare Center", tgl "10/10/2025", keterangan "labels_value".
        And pengguna menekan tombol booking Appoinment
        And pengguna menekan menu History di side bar
        Then pengguna berada di halaman History dan melihat data "<labels>" dengan nilai "<value>" tersedia.

        Examples:
      | labels                          | value                             |
      | Facility                        | Hongkong CURA Healthcare Center   |
      | Apply for hospital readmission  | Yes                               |
      | Healthcare Program              | Medicare                          |
      | Comment                         | labels_value                      |
 