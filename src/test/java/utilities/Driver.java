package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    /*
    getDriver()
    1-setup driver
    2- driver olustur
    3- return driveri
    *** Driver.getDriver()
     */


    public static WebDriver getDriver(){


        if (driver==null) {// eger driver calismiyorsa, calistir
            switch (ConfigReader.getProperty("browser")) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;


    }

    public static void closeDriver(){
        if (driver!=null){// eger driver bir yeri isaret ediyor veya kullaniliyorsa
            driver.close();
            driver=null; // driver null yap cunku surucu yeniden baslatabilriz/calistirabilir
        }
    }

}