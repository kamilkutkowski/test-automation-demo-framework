Feature: Find some random pictures on Wikipedia

  Scenario: Find Warta Tower photos
    Given I am on the Wikipedia main page
    When I type Warta Tower keyword and submit
    Then I see the Warta Tower wiki page
    And I can open every single available photo