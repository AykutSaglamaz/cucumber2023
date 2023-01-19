package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        // kosacak dosyanin adresi 'path" ==> @target/failedRerun.txt
        features = "@target/failedRerun.txt",
        glue = "stepdefinitions",
        tags = "@manager_login_test",
        dryRun = false
)
        public class FailedScenarioRunner {
}
