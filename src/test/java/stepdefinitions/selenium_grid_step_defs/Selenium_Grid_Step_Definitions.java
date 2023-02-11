package stepdefinitions.selenium_grid_step_defs;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Selenium_Grid_Step_Definitions {
    WebDriver driver;

    @Given("user is on the application_login page with chrome")
    public void user_is_on_the_application_login_page_with_chrome() throws MalformedURLException {
 // 1. Desired Capabilities object olustur //browserlara farkli ozellikler eklemek kullaniriz, orn name, version
        DesiredCapabilities cap = new DesiredCapabilities();
 // 2. browser ve istetim sistemi belirlemek icin 'cap' object kullanilir
        cap.setBrowserName("chrome");
//        cap.setPlatform(Platform.WINDOWS);// windows icin
//        cap.setPlatform(Platform.MAC);// mac icin
        cap.setPlatform(Platform.ANY);// herhangi bir isletim sistemi icin (mac veya windows)
 //3. merge (birlestirme) chrome ile DesiredCapabilities
        ChromeOptions options = new ChromeOptions();
        options.merge(cap);
  //4. RemoteWebDriver kullanarak bir driver object olustur
        String hubUrl ="http://192.168.1.59:4444";

         driver = new RemoteWebDriver(new URL(hubUrl), options);
// bu noktadan sonra test codlarimiz icin standart yolu izleriz
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

  // kosturmak istedigimiz Java kodlarini buraya yazariz

     driver.get(ConfigReader.getProperty("app_url_login"));

     try {
         ReusableMethods.waitFor(1);
         driver.findElement(By.id("details-button")).click();
         driver.findElement(By.id("proceed-link")).click();
         ReusableMethods.waitFor(1);
     }catch (Exception e){
         System.out.println("private link istenmedi");
     }

     driver.findElement(By.id("UserName")).sendKeys("manager");
     driver.findElement(By.id("Password")).sendKeys("Manager1!");
     driver.findElement(By.id("btnSubmit")).click();

    }

    @Then("verify the title includes admin")
    public void verify_the_title_includes_admin() {
       String title = driver.getTitle();
        System.out.println("title = " + title);

        Assert.assertTrue(title.contains("Admin"));

        Driver.closeDriver();

    }
    @Given("user is on the application_login page with firefox")
    public void user_is_on_the_application_login_page_with_firefox() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("firefox");
        cap.setPlatform(Platform.ANY);
        FirefoxOptions options = new FirefoxOptions();
        options.merge(cap);

        String hubUrl ="http://192.168.1.59:4444";
        driver = new RemoteWebDriver(new URL(hubUrl), options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        // kosturmak istedigimiz Java kodlarini buraya yazariz

        driver.get(ConfigReader.getProperty("app_url_login"));

        try {
            ReusableMethods.waitFor(1);
            driver.findElement(By.id("details-button")).click();
            driver.findElement(By.id("proceed-link")).click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
            System.out.println("private link istenmedi");
        }

        driver.findElement(By.id("UserName")).sendKeys("manager");
        driver.findElement(By.id("Password")).sendKeys("Manager1!");
        driver.findElement(By.id("btnSubmit")).click();

    }


}
