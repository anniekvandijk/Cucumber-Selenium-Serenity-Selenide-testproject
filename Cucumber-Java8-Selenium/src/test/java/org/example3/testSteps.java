package org.example3;

import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("Convert2MethodRef")
public class testSteps implements En {

    private WebDriver driver;

    public testSteps() {

        Before(() -> {
            Path root = Paths.get(".").normalize().toAbsolutePath();
            System.setProperty("webdriver.chrome.driver", root + "/Cucumber-Java8-Selenium/src/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            driver = new ChromeDriver(options);
            }
        );

        After(() -> {
            driver.close();
            }
        );

        Given("I navigate to website {string}", (String url) -> {
              driver.get(url);
        });

        When("I click on menu item {string}", (String menuItem) ->
                driver.findElement(By.className("region-primary-menu"))
                        .findElement(By.linkText(menuItem))
                        .click()
        );

        When("I select the alpaca with name {string}", (String name) -> {
                driver.findElement(By.xpath("*//H2/A[text()='"+name+"']"))
                      .click();
            }
        );

        Then("I see the full name of the alpaca {string}", (String expectedFullName) -> {
            String fullName = driver.findElement(By.className("field--name-field-lange-naam")).getText();
            Assert.assertEquals(expectedFullName, fullName, String.format("Expected %s but was %s", expectedFullName, fullName));
            }
        );

    }
}

