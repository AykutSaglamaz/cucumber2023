package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.DataTablesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Day19_C10_DataTablesStepDefinitions {
    DataTablesPage dataTablesPage = new DataTablesPage();

    @Given("kullanici datatables sayfasindadir")
    public void kullanici_datatables_sayfasindadir() {
        Driver.getDriver().get(ConfigReader.getProperty("data_olusturma_url"));

    }
    @Given("kullanici new buttona tiklar")
    public void kullanici_new_buttona_tiklar() {
        dataTablesPage.newEnteryButton.click();


    }
    @When("kullanici firstname {string} girer")
    public void kullanici_firstname_girer(String firstname) {
        dataTablesPage.firstName.sendKeys(firstname);

    }
    @When("kullanici lastname {string} girer")
    public void kullanici_lastname_girer(String lastname) {
        dataTablesPage.lastName.sendKeys(lastname);

    }
    @When("kullanici position {string} girer")
    public void kullanici_position_girer(String position) {
        dataTablesPage.position.sendKeys(position);

    }
    @When("kullanici office {string} girer")
    public void kullanici_office_girer(String office) {
        dataTablesPage.office.sendKeys(office);

    }
    @When("kullanici extension {string} girer")
    public void kullanici_extension_girer(String extension) {
        dataTablesPage.extension.sendKeys(extension);

    }
    @When("kullanici startdate {string} girer")
    public void kullanici_startdate_girer(String startdate) {
        dataTablesPage.startDate.sendKeys(startdate);

    }
    @When("kullanici salary {string} girer")
    public void kullanici_salary_girer(String salary) {
        dataTablesPage.salary.sendKeys(salary);

    }
    @When("kullanici create button tiklar")
    public void kullanici_create_button_tiklar() {
        dataTablesPage.createButton.click();

    }
    @When("kullanici firstname {string} arar")
    public void kullanici_firstname_arar(String firstname) {
        dataTablesPage.search.sendKeys(firstname);

    }
    @Then("kullanici cikan isimlerin arasinda firstname {string} verify eder")
    public void kullanici_cikan_isimlerin_arasinda_firstname_verify_eder(String firstname) {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(dataTablesPage.searchResult.getText().contains(firstname));

    }
// Datayi excel den alma
    @Given("kullanici tum zorunlu alanlari {string} alarak girer")
    public void kullanici_tum_zorunlu_alanlari_alarak_girer(String SheetName) {
        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/testdata/data_tables_workbook.xlsx", SheetName);
       List<Map<String, String>> testData=  excelUtil.getDataList();
       for (Map<String, String> herBirData : testData){
           Driver.getDriver().get(ConfigReader.getProperty("data_olusturma_url"));
           dataTablesPage.newEnteryButton.click();
           dataTablesPage.firstName.sendKeys(herBirData.get("firstname"));
           dataTablesPage.lastName.sendKeys(herBirData.get("lastname"));
           dataTablesPage.position.sendKeys(herBirData.get("position"));
           dataTablesPage.office.sendKeys(herBirData.get("office"));
           dataTablesPage.extension.sendKeys(herBirData.get("extension"));
           ReusableMethods.waitFor(1);
//           dataTablesPage.startDate.sendKeys(herBirData.get("startdate"));
           dataTablesPage.startDate.click();
           ReusableMethods.waitFor(1);
           dataTablesPage.tarihSecme.click();

           ReusableMethods.waitFor(1);
           dataTablesPage.salary.sendKeys(herBirData.get("salary"));
           dataTablesPage.createButton.click();
           ReusableMethods.waitFor(1);
           dataTablesPage.search.sendKeys(herBirData.get("firstname"));
           ReusableMethods.waitFor(1);

           Assert.assertTrue(dataTablesPage.searchResult.getText().contains(herBirData.get("firstname")));
       }


    }



}
