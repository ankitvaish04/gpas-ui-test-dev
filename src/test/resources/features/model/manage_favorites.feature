@ManageFavorites
Feature: manage My Favorites

  In order to manage My Favorites, user should be able to view the specific models in Edit mode and Remove them

  Background:
    Given Abad is logged in as gpasqa

  Scenario: Edit a favorite model
    When Abad wants to open a favorite model for editing with basic information
     | ymmId | country | modelYear | subDivision   | modelName             |
     | 28315 | US      | 2017      | Infiniti Cars | Q70L 2017             |

    Then he should see the selected model open in edit model with correct information

  Scenario: Remove a favorite model
    When Abad wants to remove a favorite model with basic information
     | ymmId | country | modelYear | subDivision   | modelName             |
     | 30646 | CA      | 2017      | Infiniti Cars | Model from Serenity 2 |

    Then he should see the selected model removed from the My Favorites list