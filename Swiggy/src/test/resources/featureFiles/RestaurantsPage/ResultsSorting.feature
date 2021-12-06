@Regression
Feature: To test results sorting functionality.

Background:
Given User search for a valid location 
And have directed to restaurants page

Scenario:
Should have results sorting ability in restaurants page

Then should have the following sorting tab
When user clicked on Delivery Time tab
Then result should be sorted ascending by delivery time
When user clicked on Cost: High To Low tab
Then result should be sorted by cost from high to low