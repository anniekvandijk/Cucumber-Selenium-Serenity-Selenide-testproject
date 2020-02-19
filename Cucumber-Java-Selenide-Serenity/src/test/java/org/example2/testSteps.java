package org.example2;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.linkText;

public class testSteps {

        @Given("I navigate to website {string}")
        public void navigate(String url)
        {
            open(url);
        }

        @When("I click on menu item {string}")
        public void clickMenuItem(String menuItem) {
            $(By.className("region-primary-menu"))
                    .$(linkText(menuItem))
                    .click();
        }

        @When("I select the alpaca with name {string}")
        public void selectAlpaca(String name) {
            $$(".views-field-title > H2 > a")
                    .find(Condition.exactText(name))
                    .click();
        }

        @Then("I see the full name of the alpaca {string}")
        public void checkFullName(String fullName)
        {
                $(By.className("field--name-field-lange-naam"))
                    .shouldHave(exactText(fullName));
        }
}

