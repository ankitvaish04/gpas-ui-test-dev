@CreateEIM
Feature: create EIMs for a model

  Background:
    Given Abad is logged in as gpasqa
    And he selects the model on CA for 2017 over Infiniti Cars with model Id as 12

  Scenario: create EIMs for a model
    When Abad wants to create EIMs with basic information
      | position | character | condition |
      | 18       | -         |           |
      | 17       | B         |           |
      | 16       | -         |           |
      | 15       | -         |           |
      | 14       | -         |           |
      | 13       | A         |           |
      | 11       | H         |           |
      | 8        | V37       |           |
      | 7        | L         |           |
      | 6        | V         |           |
      | 5        | L         |           |
      | 4        | N         |           |
      | 2        | LT        | I-EN1     |
      | 1        | B         |           |

    Then he should see the created EIMs for the model