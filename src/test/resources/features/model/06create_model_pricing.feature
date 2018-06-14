@CreatePricing
Feature: create pricing for a model

  Background:
    Given Abad is logged in as gpasqa
    And he selects the model on CA for 2017 over Infiniti Cars with model Id as 25

  Scenario: create pricing for a model
    When Abad wants to create pricing with basic information
      | orderCode | priceState | retailFleetStatus | condition | pricing | effectiveDate | nonEffectiveDate |
      | I-091     | Actual     | R                 |           | 440.00  | 07/18/2017    |                  |
      | H01       | Actual     | R                 |           | 1850.00 | 07/18/2017    |                  |
      | I-EN1     | Actual     | R                 |           | 0.00    | 07/18/2017    |                  |

    Then he should see the created pricing for the model