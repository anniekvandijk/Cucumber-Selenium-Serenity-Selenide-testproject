package org.example1;

import com.codeborne.selenide.Condition;
import io.cucumber.java8.En;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.linkText;

@SuppressWarnings("Convert2MethodRef")
public class testSteps implements En {

    public testSteps() {

        Given("I navigate to website {string}", (String url) ->
                open(url));

        When("I click on menu item {string}", (String menuItem) ->
                $(By.className("region-primary-menu"))
                    .$(linkText(menuItem))
                    .click());

        When("I select the alpaca with name {string}", (String name) ->
                $$(".views-field-title > H2 > a")
                    .find(Condition.exactText(name))
                    .click());

        Then("I see the full name of the alpaca {string}", (String fullName) ->
                $(By.className("field--name-field-lange-naam"))
                    .shouldHave(exactText(fullName)));

    }
}

