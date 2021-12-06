@Regression
Feature: To test location searchbar functionality.

  Background: 
    Given User at main menu page

  Scenario Outline: 
    For the search to show suggestion, user are required to enter valid location with a minimum of 3 words.
    if user click on clear button, text in the searchbar should be cleared

    And User enter first few word of "<location>"
    Then search bar should have "<suggestion>"
    And User clicked on clear button
    Then text in the searchbar should be cleared

    Examples: 
      | location | suggestion |
      | New      | true       |
      | gurga    | true       |
      | mumb     | true       |
      | ban      | true       |
      | rthdfg   | false      |
      | as       | false      |
      | zx       | false      |
      | ab       | false      |

  Scenario: 
    when clicked on the suggested location, user should be directed to url https://www.swiggy.com/restaurants

    And User enter "New Delhi" in the searchbar
    And User click on the suggested location
    Then User should be directed to url "https://www.swiggy.com/restaurants"

  Scenario: 
    If FIND FOOD button is clicked without searching and clicking on any suggested location, there should be a message to
    inform user to Enter your delivery location

    And User click on FIND FOOD button without searching or clicking on any suggested location
    Then There should be a message prompt "Enter your delivery location"
