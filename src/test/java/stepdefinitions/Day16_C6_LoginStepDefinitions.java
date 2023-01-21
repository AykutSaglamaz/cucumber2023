package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.DefaultPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

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

    ExcelUtil excelUtil;
    List<Map<String, String>> testData;

    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("qa_url_login"));
        loginPage = new LoginPage();
        Thread.sleep(1000);
        try{
            Thread.sleep(1000);
            loginPage.advancedLink.click();
            Thread.sleep(1000);
            loginPage.proceedLink.click();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Advanced Link ve Proceed Link gorunmedi");
        }
    }

    @Given("kullanici applicationa excel admin ile login yapar")
    public void kullanici_applicationa_excel_admin_ile_login_yapar() throws InterruptedException {
        String path ="./src/test/resources/testdata/smoketestdata.xlsx";
        String sheetName="admin_login_info";
        excelUtil= new ExcelUtil(path,sheetName);

        testData=excelUtil.getDataList();
        System.out.println(testData);//[{password=Arcane123!, username=admin1}]

        for(Map<String,String> eachData : testData ){//eachData represent each username-password pairs
            setUp();//login in each loop
            loginPage.username.sendKeys(eachData.get("username"));//admin1
            loginPage.password.sendKeys(eachData.get("password"));//Arcane123!
            loginPage.loginButton.click();
        }

    }
    @Given("kullanici applicationa excel manajer ile login yapar")
    public void kullanici_applicationa_excel_manajer_ile_login_yapar() throws InterruptedException {
        String path ="./src/test/resources/testdata/smoketestdata.xlsx";
        String sheetName="manager_login_info";
        excelUtil= new ExcelUtil(path,sheetName);

        testData=excelUtil.getDataList();
        System.out.println(testData);// [{password=Manager1!, username=manager}, {password=Manager5!, username=manager5}, {password=Manager12!, username=manager12}]

        for(Map<String,String> eachData : testData ){//eachData represent each username-password pairs
            setUp();//login in each loop
            loginPage.username.sendKeys(eachData.get("username"));
            loginPage.password.sendKeys(eachData.get("password"));
            loginPage.loginButton.click();
        }

    }


}
