package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.DefaultPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Day16_C6_LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();

    @Given("kullanici application sayfasindadir")
    public void kullanici_application_sayfasindadir() {
        Driver.getDriver().get(ConfigReader.getProperty("qa_url_login"));
        try{
            Thread.sleep(1000);
            loginPage.advancedLink.click();
            Thread.sleep(1000);
            loginPage.proceedLink.click();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Advanced Link and Proceed Link is not displayed");
        }

    }
    @Given("kullanici manager id {string} girer")
    public void kullanici_manager_id_girer(String string) {
        loginPage.username.sendKeys(string);

    }
    @Given("kullanici manager sifre {string} girer")
    public void kullanici_manager_sifre_girer(String string) {
        loginPage.password.sendKeys(string);

    }
    @Then("kullanici login buttonuna click eder")
    public void kullanici_login_buttonuna_click_eder() {
        loginPage.loginButton.click();

    }
    @Then("kullanici {string} oldugunu very eder")
    public void kullanici_oldugunu_very_eder(String string) {
        Assert.assertEquals(defaultPage.hotelManagementLink.getText(), string);


    }
}
