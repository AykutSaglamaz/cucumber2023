package stepdefinitions;

import io.cucumber.java.en.Then;
import utilities.ReusableMethods;

import java.io.IOException;

public class Day18_C8_Reusable_Step_Definitions {

    @Then("screenshot yap")
    public void screenshot_yap() throws IOException {
        ReusableMethods.getScreenshot("ScreenShot_almak");

    }
}
