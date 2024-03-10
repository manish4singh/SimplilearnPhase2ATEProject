#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @Smoke
  Scenario Outline: Validate Pizzahut pizza order flow
    Given User launch Pizzahut application with "<phUrl>"
    When User wait for auto location black pop up screen
    Then User close the pop up screen
    And User see pop up for delivery asking for enter location
    Then User type address as "<Location>"
    And User select first auto populate drop down option
    When User navigate to deals page
    Then User validate vegetarian radio button flag is off
    And User clicks on Pizzas menu bar option
    When User select add button of any pizza from Recommended
    Then User see that the pizza is getting added under Your Basket
    And User validate pizza price plus Tax is checkout price
    Then User validate checkout button contains Item count
    And User validate checkout button contains total price count
    Then User clicks on Drinks option
    And User select Pepsi option to add into the Basket
    Then User see 2 items are showing under checkout button
    And User see total price is now more than before
    Then User remove the Pizza item from Basket
    And see Price tag got removed from the checkout button
    And User see 1 item showing in checkout button
    Then User Clicks on Checkout button
    And User see minimum order required pop up is getting displayed

    Examples: 
      | phUrl                       | Location |
      | https://www.pizzahut.co.in/ | Durgapur Junction Mall|
