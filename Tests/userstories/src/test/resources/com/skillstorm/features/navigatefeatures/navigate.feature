Feature: Navigate

  Scenario Outline: Side Navigation
    Given I am on the "<current>" page
    When I click "<page>" in the side bar
    Then I should be redirected to "<page>"

    Examples:
      | current     | page      |
      | Warehouses  | Products  |
      | Items       | Inventory |


