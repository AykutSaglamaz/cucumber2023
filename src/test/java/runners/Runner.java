package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

// calistirmak istegim feature file belirtiyorum
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        features = "src/test/resources", // ZORUNLU  => Feature dosyanin pathini girmemiz laim
        glue = "stepdefinitions", //ZORUNLU => Stepdefinition adresi ('path)'i
        tags = "@manager_login_test",// hangi feature file kosmali onu belirtiyoruz= > Eger tags kullanmaz isek Runner tum feature run eder
        dryRun = false // opsiyoneldir
)


public class Runner {
}
/*
Runner: feature file'lari calistirmak icin kullanilir
@RunWith : Cucumber.class'lari calistirmak icin kullanilir, kullanmadan Runner calismaz
@CucumberOptions() : feature path'i eklemek icin kullanilir , step deginition paht, tags, dryRun, report plugins icerir
 -feature : feature dosyasi path'ini verir, spesifik bir feature file isaret edilebilir
 -glue : step definition class'inda spesifik path'i isaret eder
 -tags : hangi feature yada senaryo kosacak bunu belirler. bu tag'i feature file ekliyoruz
 -dryRun : herhangi bir JAVA kod eksikligini kontol eder (step definition kullaniriz)
           : dryRun 2 value (deger) alir, true (head-less) veya false
           : dryRun = false => Herhangi bir JAVA kodunun eksik olup olmadigini kotrol ederken tarayicida testleri calistirir
           : dryRun = true =>  Herhangi bir JAVA kodunun eksik olup olmadigini kotrol ederken tarayici olmadan testleri calistirir
 */
