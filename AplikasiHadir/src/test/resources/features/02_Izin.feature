Feature: Permit Feature

Scenario: Navigation to halaman izin in Aplikasi Hadir
    Given user berada pada halaman dashboard sebelum ke halaman izin.
    When user menekan icon izin.
    Then user dibawa ke halaman izin dengan url "https://magang.dikahadir.com/apps/absent/permit".

Scenario: User mengajukan izin terlambat tanpa isi data tanggal & keterangan
    Given pengguna berada di halaman izin
    When user klik menu izin
    And user klik tombol ajukan izin terlambat
    And user memilih jam 10 menit 30.
    And user klik tombol ajukan
    Then Muncul pesan error "Keterangan Harus diisi!" dan "Tanggal Harus diisi!"

Scenario: User mengajukan izin Pulang Cepat tanpa isi data tanggal & keterangan
    Given pengguna di bawa kehalaman izin
    When pengguna klik tombol Tab Pulang Cepat
    And pengguna klik tombol Ajukan Pulang Cepat
    And pengguna memilih jam 5 menit 30, lalu klik tombol Ajukan
    Then Muncul pesan error peringatan "Keterangan Harus diisi!" dan "Tanggal Harus diisi!"

Scenario: Navigation Tab Terlambat & Tab Pulang Cepat
    Given user masuk kehalaman izin
    When user menekan tombol tab terlambat dan tab pulang cepat
    And user menekan tombol kembali
    Then user kembali kehalaman dashboard dengan url "https://magang.dikahadir.com/apps/absent"

Scenario: Validation Total List Izin Pulang Cepat
    Given user masuk kehalaman menu izin
    When user mengklik tombol tab pulang cepat
    And user melihat List Pulang Cepat
    Then user telah melihat total list cepat

Scenario: Validation Total List Izin Terlambat
    Given pengguna masuk kehalaman menu izin
    When pengguna mengklik tombol tab terlambat
    And pengguna melihat List terlambat
    Then pengguna telah melihat total list terlambat

Scenario: User membatalkan input di Form pengajuan izin Pulang Cepat dengan tombol Reset
    Given user di bawa kehalaman menu izin
    When user menekan tombol Pengajuan
    And user klik icon calender, input tanggal "13"
    And user klik icon jam input jam 5 menit 30, dan input keterangan "test1234".
    Then lalu user menekan tombol Reset

Scenario: User membatalkan input di form pengajuan izin Terlambat dengan tombol Reset
    Given user di bawa kehalaman izin page
    When user menekan tombol pengajuan di form
    And user mengisi data : tanggal "13", jam 7 menit 30, keterangan "inputfield"
    Then user klik tombol reset dan form izin kosong

Scenario: Validation Pengajuan Izin Pulang Cepat Berhasil
    Given Pengguna di bawa kehalaman izin
    When pengguna menekan tombol pengajuan di form
    And pengguna memasukkan data : tanggal "13", jam 9 menit 30, keterangan "acarakeluarga"
    Then pengguna menekan tombol Ajukan, dan melihat isi catatan "acarakeluarga"

Scenario: Validation Pengajuan Izin Terlambat Berhasil
    Given pengguna menuju kehalaman izin
    When pengguna klik tombol pengajuan terlambat di form
    And pengguna input data : Tanggal "13", jam 10 menit 30, keterangan "motor rusak"
    Then pengguna melihat nilai dari label "Catatan" adalah "motor rusak"

Scenario: Negative Tombol Reset di Izin Pulang Cepat, Tanggal tidak benar2 kosong
    Given Pengguna berada di halaman Izin Page
    When Pengguna klik tombol pengajuan untuk menampilkan form
    And Pengguna menginput data berupa : tgl "13", jam 5 menit 20, keterangan "qwertytre".
    Then Pengguna menekan tombol reset, tanggal tidak kosong

Scenario: Negative Tombol Reset di Izin Terlambat, Tanggal tidak ke Reset
    Given Pengguna berada di halaman Izin.
    When Pengguna klik tombol pengajuan.
    And Pengguna mengisi data berupa : tgl "13", jam 4 menit 45, keterangan "qwertytre".
    Then Pengguna klik tombol reset, dan tanggal tidak kosong.