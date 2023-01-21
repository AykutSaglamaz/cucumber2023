@excel_otomasyon
Feature: FE101_login_fonksiyonu
  @excel_admin
  Scenario: admin_login
  Given kullanici applicationa excel admin ile login yapar
  Then screenshot yap
  Then kullanici application kapatir

  @excel_manager
  Scenario: manajer_login
      Given kullanici applicationa excel manajer ile login yapar
      Then screenshot yap
      Then kullanici application kapatir

