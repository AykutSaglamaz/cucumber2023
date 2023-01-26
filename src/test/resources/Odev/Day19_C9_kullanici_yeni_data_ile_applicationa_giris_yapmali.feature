@data_tables_hw
Feature: scenario_outline
  @scenario_outline_data_tables
  Scenario Outline: TC01_Testing_the_data_tables_web_page
    Given kullanici datatables sayfasindadir
    And kullanici new buttona tiklar
    When kullanici firstname "<firstname>" girer
    And kullanici lastname "<lastname>" girer
    And kullanici position "<position>" girer
    When kullanici office "<office>" girer
    When kullanici extension "<extension>" girer
    When kullanici startdate "<start_date>" girer
    When kullanici salary "<salary>" girer
    And kullanici create button tiklar
    And kullanici firstname "<firstname>" arar
    Then kullanici cikan isimlerin arasinda firstname "<firstname>" verify eder
    Then kullanici application kapatir

    Examples: test data for the data table test
      | firstname | lastname | position | office        | extension | start_date  | salary     |
      | john      | walker   | doctor   | LA            | 456       | 2022-10-10 | 78900       |
      | ihsan     | kim      | nurse    | TX            | 899       | 2022-10-11 | 789000009  |
      | Jim       | cam      | qa       | AR            | 23462     | 2022-10-12 | 789000006  |
      | Betty     | york     | lawyer   | NY            | 5613      | 2022-10-13 | 6100000    |
      | Sue       | Lui      | dev      | CA            | 400       | 2022-10-14 | 10000000   |

 @excel_data_tables
 Scenario: tabloyu excel kullanarak olusturma
   Given kullanici datatables sayfasindadir
   And kullanici tum zorunlu alanlari "data_tables_sheet" alarak girer
