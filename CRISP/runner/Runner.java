package CRISP.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt" ,
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"
        },
        monochrome = true,
        features = "src/test/resources/featureFiles",
        glue = "CRISP/stepDefinitions",
        dryRun = false,
        tags = "@NTC2"


)

public class Runner {
}
