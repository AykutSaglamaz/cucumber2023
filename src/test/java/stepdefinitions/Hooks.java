package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    // Cucumber'da hook class ne demektir
    // hooks Before ve After annotationlari sahiptir
    // hooks her bir Scenario'dn once (before) veya sonra (After) calisir
    // @After'da nelerin var?
    // Cucuber'da @after hooks'da report ve screenShot alirim
    //Hooks'u ben dizayn ederim ve test scenario basarisiz oldugunda screenShot alirim

     @Before
    public void setUp(){
         System.out.println("Bu bir hooks @Before methodudur");
     }

     @After
    public void tearDown(Scenario scenario){
         System.out.println("Bu bir hooks @After methodudur");
         //screen almak icin : getScreenshotAs () screenShot alacaktir
//
     final byte[]  screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//
//      /// screenShot'i scenario raporuna ekle
//
        if (scenario.isFailed()) {

             scenario.attach(screenshot, "image/png", "screenshot");
         }
        Driver.closeDriver();
//
     }


}
