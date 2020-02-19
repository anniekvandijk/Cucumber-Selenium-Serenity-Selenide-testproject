package org.example2;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/",
        glue = "org.example2",
        strict = true,
        dryRun=false
)
public class RunCucumberSelenideSerenityTest {
}