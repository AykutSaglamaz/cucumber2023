@scenario_outline_1_google_arama

  Feature: Google_Arama_Fonksiyonu

    Scenario Outline:
      Given kullanici google sayfasindadir
      And kullanici "<urun>" arar
      Then kullanici sonuclarda "<urun>" oldugunu verify eder
      Then kullanici application kapatir

      Examples: Test Data
        | urun    |
        | iPhone  |
        | cicek   |
        | tesla   |
        | bmw     |
        | samsung |