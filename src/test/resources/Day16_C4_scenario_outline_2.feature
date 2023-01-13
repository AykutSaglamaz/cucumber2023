
@scenario_outline_2_google_arama

Feature: Google_Arama_Fonksiyonu

  Scenario Outline:
    Given kullanici google sayfasindadir
    And kullanici "<baskent>" arar
    Then kullanici sonuclarda "<baskent>" oldugunu verify eder
    Then kullanici application kapatir

    Examples: Test Data
      | baskent |
      | London  |
      | Paris   |
      | Vienna  |
      | Vienna  |
      | Berlin  |
      | Madrid  |