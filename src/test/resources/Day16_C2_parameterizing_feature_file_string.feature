
@parameterize_google_arama
Feature: Google_Search_Functionality

  Scenario: TC01_iPhone_search
    Given kullanici google sayfasindadir
    And kullanici "iPhone" arar
    Then kullanici sonuclarda "iPhone" oldugunu verify eder
    Then kullanici application kapatir


  Scenario: TC02_caydanlik_search
    Given kullanici google sayfasindadir
    And kullanici "caydanlik" arar
    Then kullanici sonuclarda "caydanlik" oldugunu verify eder
    Then kullanici application kapatir

  Scenario: TC03_cicek_search
    Given kullanici google sayfasindadir
    And kullanici "cicek" arar
    Then kullanici sonuclarda "cicek" oldugunu verify eder
    Then kullanici application kapatir

  Scenario: TC04_volkswagen_search
    Given kullanici google sayfasindadir
    And kullanici "volkswagen" arar
    Then kullanici sonuclarda "volkswagen" oldugunu verify eder
    Then kullanici application kapatir

  Scenario: TC05_tesla_search
    Given kullanici google sayfasindadir
    And kullanici "tesla" arar
    Then kullanici sonuclarda "tesla" oldugunu verify eder
    Then kullanici application kapatir

  Scenario: TC06_bmw_search
    Given kullanici google sayfasindadir
    And kullanici "bmw" arar
    Then kullanici sonuclarda "bmw" oldugunu verify eder
    Then kullanici application kapatir