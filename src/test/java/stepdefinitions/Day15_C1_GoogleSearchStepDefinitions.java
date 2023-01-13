package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

public class Day15_C1_GoogleSearchStepDefinitions {
    // Java kodlari nereye step definition kismina gelecek

    GooglePage googlePage = new GooglePage();

    @Given("kullanici google sayfasindadir")
    public void kullanici_google_sayfasindadir() {
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));
    }
    @Given("kullanici iPhone'u arar")
    public void kullanici_i_phone_u_arar() {
        googlePage.googleSearchBox.sendKeys("iPhone" + Keys.ENTER);
    }

    @Then("kullanici sonuclarda iPhone oldugunu verify eder")
    public void kullanici_sonuclarda_i_phone_oldugunu_verify_eder() {
      boolean title =  Driver.getDriver().getPageSource().contains("iPhone");
        Assert.assertTrue(title);
    }
    @Then("kullanici application kapatir")
    public void kullanici_application_kapatir() {
        Driver.closeDriver();
    }


    @Given("kullanici caydanlik'i arar")
    public void kullanici_caydanlik_i_arar() {
        googlePage.googleSearchBox.sendKeys("caydanlik"+ Keys.ENTER);
    }

    @Then("kullanici sonuclarda caydanlik oldugunu verify eder")
    public void kullanici_sonuclarda_caydanlik_oldugunu_verify_eder() {
       String title = Driver.getDriver().getTitle();
       Assert.assertTrue(title.contains("caydanlik"));
    }

    @Given("kullanici cicek'i arar")
    public void kullanici_cicek_i_arar() {
        googlePage.googleSearchBox.sendKeys("cicek"+Keys.ENTER);
    }
    @Then("kullanici sonuclarda cicek oldugunu verify eder")
    public void kullanici_sonuclarda_cicek_oldugunu_verify_eder() {
        Assert.assertTrue("Cicek", Driver.getDriver().getTitle().contains("cicek"));
    }

    @Given("kullanici volkswagen'i arar")
    public void kullanici_volkswagen_i_arar() {
        googlePage.googleSearchBox.sendKeys("volkswagen"+Keys.ENTER);

    }
    @Then("kullanici sonuclarda volkswagen oldugunu verify eder")
    public void kullanici_sonuclarda_volkswagen_oldugunu_verify_eder() {
        Assert.assertTrue("volkswagen", Driver.getDriver().getTitle().contains("volkswagen"));
    }


    //paramatirized kullanildi
    @Given("kullanici {string} arar")
    public void kullanici_arar(String string) {
        googlePage.googleSearchBox.sendKeys(string + Keys.ENTER);
    }

    @Then("kullanici sonuclarda {string} oldugunu verify eder")
    public void kullanici_sonuclarda_oldugunu_verify_eder(String string) {
       String title = Driver.getDriver().getTitle();
       Assert.assertTrue(title.contains(string));
    }

}
