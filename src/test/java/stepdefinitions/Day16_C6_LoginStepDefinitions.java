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
            System.out.println("Advanced Link ve Proceed Link istenmedi");
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

    @Then("kullanici {string} oldugunu verify eder")
    public void kullanici_oldugunu_very_eder(String string) {
        Assert.assertEquals(defaultPage.hotelManagementLink.getText(), string);

    }

    @Given("kullanici admin id {string} girer")
    public void kullanici_admin_id_girer(String kullaniciadi) {
        loginPage.username.sendKeys(kullaniciadi);
    }
    @Given("kullanici admin sifre {string} girer")
    public void kullanici_admin_sifre_girer(String sifre) {
        loginPage.password.sendKeys(sifre);

    }
    @When("kullanici login button’una click eder")
    public void kullanici_login_button_una_click_eder() throws InterruptedException {

            Thread.sleep(2000);

        loginPage.loginButton.click();

    }
    @Then("default page’in displayed oldugunu verify eder")
    public void default_page_in_displayed_oldugunu_verify_eder() {

    }

}
