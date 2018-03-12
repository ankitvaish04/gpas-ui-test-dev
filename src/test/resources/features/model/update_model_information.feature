Feature: update the basic information for a model

  Background:
    Given Abad is logged in as gpasqa
    And he select the model on CA for 2017 over Infiniti Cars

    @update_information
  Scenario: update the model information
    And Abad wants to update a model with basic information
      | effective_date | languages | currencies   | priceTypes  | modelLineCode | comment       |
      | 07/18/2017     | fr        | CAD          | Retail/MSRP | TXT           | Updated Model |
    When he has completed updating the model
    Then he should see the updated model
