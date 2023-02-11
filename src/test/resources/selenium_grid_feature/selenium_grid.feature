@selenium_grid
Feature: verify_application_title
  @grid_chrome
  Scenario: verify_title_on_chrome
    Given user is on the application_login page with chrome
    Then verify the title includes admin



  @grid_firefox
  Scenario: verify_title_on_firefox
    Given user is on the application_login page with firefox
    Then verify the title includes admin


#  selenium Grid ne demektir
# Selenium Grid uzaktan (remote) test kosturmak icin kullanilir
#  Parallel testing icin Selenium Grid kullanilir

# Ne yapariz : cross Browser Test (coklu browser da test)
# Nicin yapariz : fonksiyonlarin veya applicationin ozellliklerinin farkli browserlarda calisip calismadigiini test ederiz

# DesiredCapabilities ne demektir?
#   Browserlar icin farkli name, version, platform gibi ozellikleri eklemek  icin DesiredCapabilities kullaniriz

#  Remote Driver (uzaktan Driver) ne demektir. Nicin kullaniriz?
#   Remote driveri remote platforma baglanmak icin kullaniriz
#  Node baglanmak icin remote driver kullaniriz

#  selenium Grid'in faydasi nedir?
#   parallel testin yapmak ve zamandan kazanmak icin kullaniriz, butun test framework'leri calistirabilir

#  hub ne demektir?
# Farkli bilgisayarlarda (makine) parallel testleri kosturdugumuz server'a hub denir

#  Node ne demek ?
#  hub'lara kaydolmak icin kullanilan server makinelerine Node denir. selenium Grid coklu Node ile calisabilir

#  selenium Gride  testleri nasil kosturursunuz?
#   Hub'a kaydolurum , cunku onu server olarak kullanirim. Ardindan Node'a kaydolurum, ardindan test caseleri olusturur ve testleri kostururum.

#  Driver'i nasil guncel tutarsiniz?
#   en iyi kode calisan kod, eger driver calisiyorsa kullanmaya devam et. eger driverla alakali hata veriyorsa bu durumda guncelleme yapabiliriz



