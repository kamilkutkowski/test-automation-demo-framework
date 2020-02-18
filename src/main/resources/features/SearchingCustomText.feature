@EN
Feature: Find some random pictures
  In this feature as a Internet user I want to find some results of my searching phrase.

  Scenario: Find Warta Tower photos
    Given I am on the Wikipedia main page
    When I type Warta Tower keyword and submit
    Then I see the Warta Tower search result page
    And I can open first four available elements