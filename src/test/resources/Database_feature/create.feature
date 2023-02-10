@oda_rezervasyonu1
  Feature: create_new_hotel
    Scenario: TC01_Create_New_Hotel_Test
      Given user connects to the database
      When user creates a new hotel with this values "'3000','Royal King Star 5 Hotel','LA Downtown','88899','dbtest@testemail.com','2023-4-02 19:40:47.597', 4"
      Then verify the creation is successful
