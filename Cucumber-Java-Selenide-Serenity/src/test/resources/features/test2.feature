Feature: Test with selenide

  Scenario: Go to site and check full name of Alpaca
    Given I navigate to website "https://www.alpacamundo.eu"
    When I click on menu item "Onze alpaca's"
    And I select the alpaca with name "Fei Lian"
    Then I see the full name of the alpaca "Alpacamundo Fei Lian"

