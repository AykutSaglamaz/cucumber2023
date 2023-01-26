package stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleException {

    @Test
    public void login (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-environment.resortsline.com/Account/Logon");

        try {
            driver.findElement(By.id("details-button")).click();
            driver.findElement(By.id("proceed-link")).click();
        }catch (Exception e) {
            System.out.println("link cikmadi");
        }
    WebElement userName = driver.findElement(By.id("UserName"));
    WebElement password = driver.findElement(By.id("Password"));
    WebElement loginButon = driver.findElement(By.id("btnSubmit"));

    driver.navigate().refresh();// sayfayi refresh edersek     driver.navigate().refresh();// sayfayi refresh edersek
        // DOM bagli bir sey yoktur

    try {
        userName.sendKeys("manager");
        password.sendKeys("Manager1!");
        loginButon.click();
    }catch (Exception e){

    }

    }
}
