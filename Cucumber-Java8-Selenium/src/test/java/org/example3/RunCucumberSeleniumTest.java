package org.example3;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/",
        plugin = {"pretty"},
        strict = true,
        dryRun=false
        )

public class RunCucumberSeleniumTest {
}
