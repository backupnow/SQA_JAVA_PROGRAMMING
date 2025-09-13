Feature: Reports Feature

Scenario: Navigation to Download Reports
    Given user di bawa kehalaman utama atau dashboard
    When user klik menu Download Reports
    Then user berada di halaman Download Reports

Scenario: Pengguna Melakukan Donwload Reports
    Given user dibawa ke halaman download reports
    When user memilih tipe Reports "<tipeReport>"
    And user menekan tombol Download Reports
    Then user berhasil melakukan Donwload Reports "<messageSucces>"

    Examples:
        | tipeReport | messageSucces            |
        | Bulanan    | Berhasil download report |
        | Mingguan   | Berhasil download report |
        | Harian     | Berhasil download report |

Scenario: Pengguna tidak memilih tipe Reports
    Given pengguna berada di halaman download Reports
    When pengguna tidak memilih tipe Reports, dan klik button download
    Then pengguna mendapat pesan, "Tipe report harus dipilih!"