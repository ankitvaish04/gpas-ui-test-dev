@CheckCVC
Feature: check CVC for a model

  Background:
    Given Abad is logged in as gpasqa
    And he selects the model on CA for 2017 over Infiniti Cars with model Id as 12

  Scenario: check Option Kinds under CVC for a model
    When Abad wants to generate Option Kinds under CVC with information
      | 006,070  |

    Then he should see the required Option Kinds under CVC for the model