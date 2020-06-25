# new feature
# Tags: optional

Feature: Search in ebay page
  how a user automation, i want to search shoes in ebay and show a example with cucumber

  Background:
    Given I have access to ebay page
    When I enter the search Zapatos

  Scenario: Select a PUMA
    And I clic on checkbox PUMA
    Then I see the result shoes number

  Scenario: Select Nuevo con defectos
    And I clic on checkbox PUMA
    Then I see the result shoes number

  Scenario: Order by
    And I clic on checkbox PUMA
    And I select order by Price highest
    Then I see the result shoes number




