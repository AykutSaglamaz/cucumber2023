package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.DefaultPage;
import pages.LoginPage;
import pages.RoomRezervasyonPage;

import java.util.List;
import java.util.Map;

public class Day17_C7_Room_Rezervasyon_Step_Definitions {
    LoginPage loginPage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();
    RoomRezervasyonPage roomRezervasyonPage = new RoomRezervasyonPage();

    @Given("kullanici  manager kullanici bilgilerini girer")
    public void kullanici_manager_kullanici_bilgilerini_girer(DataTable kullaniciBilgileri) {
        /*
        List<String> menajerKullaniciBilgileri = kullaniciBilgileri.row(1);
        System.out.println(menajerKullaniciBilgileri);
        System.out.println(menajerKullaniciBilgileri.get(0));
        System.out.println(menajerKullaniciBilgileri.get(1));

        loginPage.username.sendKeys(menajerKullaniciBilgileri.get(0));
        loginPage.password.sendKeys(menajerKullaniciBilgileri.get(1));
    */

     // datayi  List<List<String>> olarak alma
        /*
        List<List<String>> manajerBilgileri2 = kullaniciBilgileri.asLists();

        System.out.println(manajerBilgileri2);//[[username, password], [manager, Manager1!]]
        for (List<String> herBirBilgi : manajerBilgileri2 ){
            System.out.println(herBirBilgi);
            System.out.println(herBirBilgi.get(0));
            System.out.println(herBirBilgi.get(1));

            if (!herBirBilgi.get(0).equals("username")) {
                loginPage.username.sendKeys(herBirBilgi.get(0));
                loginPage.password.sendKeys(herBirBilgi.get(1));
            }
        }

// datayi lambda ile alma
        List<List<String>> manajerBilgileri2 = kullaniciBilgileri.asLists();
        manajerBilgileri2.stream().filter(t -> !(t.get(0).equals("username"))).forEach(t -> {
            loginPage.username.sendKeys(t.get(0));
            loginPage.password.sendKeys(t.get(1));
        });
*/
// datayi List<Map<String, String>> alma
        List<Map<String, String>> manejerBilgi3 = kullaniciBilgileri.asMaps(String.class, String.class);
        System.out.println(manejerBilgi3);
        for (Map<String, String> herBirBilgi : manejerBilgi3){
            System.out.println(herBirBilgi);
            loginPage.username.sendKeys(herBirBilgi.get("username"));
            loginPage.password.sendKeys(herBirBilgi.get("password"));
        }


    }

    @Given("kullanıcı oda rezervasyon sayfasını yönlendirilir")
    public void kullanıcı_oda_rezervasyon_sayfasını_yönlendirilir() {
        defaultPage.hotelManagementLink.click();
        defaultPage.roomReservationsLink.click();
        roomRezervasyonPage.addRoomReservationButton.click();
    }

    @Given("kullanıcı tüm zorunlu alanları girer")
    public void kullanıcı_tüm_zorunlu_alanları_girer(DataTable roomData) {
        List<String> testData = roomData.row(1);
        System.out.println(testData);//[manager, Harrison, 700, 01/17/2023, 01/30/2023, 2, 4, test, (850) 258-2565, test@gmail.com, bu datatable ile ilk test]

        //idUser bir dropdown
        Select selectIdUser = new Select(roomRezervasyonPage.idUser);
        selectIdUser.selectByVisibleText(testData.get(0));

        //idHotel bir dropdown
        Select selectIdHotel = new Select(roomRezervasyonPage.idHotelRoom);
        selectIdHotel.selectByVisibleText(testData.get(1));

        roomRezervasyonPage.price.sendKeys(testData.get(2));

        roomRezervasyonPage.dateStart.sendKeys(testData.get(3));

        roomRezervasyonPage.dateEnd.sendKeys(testData.get(4));

        roomRezervasyonPage.adultAmount.sendKeys(testData.get(5));

        roomRezervasyonPage.childrenAmount.sendKeys(testData.get(6));

        roomRezervasyonPage.contactNameSurname.sendKeys(testData.get(7));

        roomRezervasyonPage.contactPhone.sendKeys(testData.get(8));

        roomRezervasyonPage.contactEmail.sendKeys(testData.get(9));

        roomRezervasyonPage.notes.sendKeys(testData.get(10));

    }
    @Given("kullanıcı approved checkbox’a click eder")
    public void kullanıcı_approved_checkbox_a_click_eder () {
        roomRezervasyonPage.isApproved.click();
    }
    @Given("kullanıcı paid check box’a click eder")
    public void kullanıcı_paid_check_box_a_click_eder () {
        roomRezervasyonPage.isPaid.click();
    }
    @Given("kullanıcı save button’una click eder")
    public void kullanici_save_button_una_click_eder () {
        roomRezervasyonPage.saveButton.click();

    }

    @Then("kullanıcı success mesajını verify eder")
    public void kullanıcı_success_mesajını_verify_eder() throws InterruptedException {
        Thread.sleep(2000);
        //   String succesMesaji =  roomRezervasyonPage.successMessage.getText();
        //   String beklenenMesaj  = "RoomReservation was inserted successfully";

        Assert.assertEquals("RoomReservation was inserted successfully",roomRezervasyonPage.successMessage.getText());
        roomRezervasyonPage.okButton.click();
    }


}
