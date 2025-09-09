Feature: Manajemen Sakit

  # Scenario: Navigation to halaman sakit in Aplikasi Hadir
  #   Given user berada pada halaman dashboard sebelum ke halaman sakit.
  #   When user menekan icon sakit.
  #   Then user dibawa ke halaman sakit dengan url "https://magang.dikahadir.com/apps/absent/sick".

    # Scenario: Pengajuan sakit berhasil
    #     Given user berada di halaman sakit
    #     When user klik tombol Ajukan Sakit
    #     When user klik icon calender sakit
    #     When user memilih tanggal mulai sakit "9"
    #     And user memilih tanggal selesai sakit "11"
    #     And user upload file bukti sakit "sakit.jpg"
    #     And user menekan tombol Ajukan
    #     Then user berhasil mengajukan sakit

    # Scenario: Negatif, Pengajuan izin sakit pada tanggal yang telah diajukan sebelumnya
    # Given pengguna berada di halaman pengajuan sakit
    # When pengguna menekan tombol Ajukan Sakit
    # And pengguna membuka kalender untuk memilih tanggal sakit
    # And pengguna memilih tanggal mulai sakit "9"
    # And pengguna memilih tanggal selesai sakit "11"
    # And pengguna mengupload bukti sakit "sakit.jpg"
    # And pengguna menekan tombol konfirmasi pengajuan
    # Then pengguna gagal ajukan dan muncul pesan "Anda sudah melakukan izin sakit di tanggal tersebut"

    # Scenario: Negatif, Pengajuan izin tanpa isi data
    # Given pengguna berada di halaman sakit
    # When pengguna klik tombol Ajukan Sakit
    # And pengguna klik tombol konfirmasi pengajuan
    # Then pengguna mendapat pesan "Incorrect datetime value: 'Invalid date' for column 'sick_request_date_from' at row 1"

    # Scenario: User melakukan reset di form pengajuan sakit
    #   Given user di bawa kehalaman sakit.
    #   When user menekan tombol pengajuan sakit
    #   And user memilih tanggal mulai "9" dan tanggal akhir "10"
    #   Then lalu user menekan tombol reset, maka form kosong 

    # Scenario: Validasi total List Request Sakit
    #   Given pengguna di bawa kehalaman sakit
    #   And user melihat total List Request sakit
    #   Then dan user telah mengetahui total request