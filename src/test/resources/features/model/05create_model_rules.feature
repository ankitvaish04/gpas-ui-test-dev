@CreateRules
Feature: create rules for a model

  Background:
    Given Abad is logged in as gpasqa
    And he selects the model on CA for 2017 over Infiniti Cars with model Id as 25

  Scenario: create rules for a model
    When Abad wants to create rules with basic information
      | orderCode | operator | operand |
      | H01       | R        | R10     |
      | I-090     | R        | H01     |
      | I-091     | R        | H02     |
      | I-092     | R        | H03     |
      | I-093     | R        | H04     |
      | I-094     | R        | H05     |
      | I-095     | R        | H06     |
      | I-096     | R        | H07     |

    Then he should see the created rules for the model