@manager_login_test
  Feature: Login_manager_kullanici_bilgileriyle_deneme
    Scenario Outline:
      Given kullanici application sayfasindadir
      And kullanici manager id "<kullaniciadi>" girer
      And kullanici manager sifre "<kullanicisifre>" girer
      Then kullanici login buttonuna click eder
      Then kullanici "<default_page>" oldugunu very eder
      Then kullanici application kapatir

      Examples: Test Data
        | kullaniciadi | kullanicisifre | default_page |
        | manager      | Manager1!      | Hotel Management |
        | manager2     | Manager2!      | Hotel Management |
        | manager3    | Manager3!     | Hotel Management |