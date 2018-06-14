@UpdateModel
Feature: update the basic information for a model

  Background:
    Given Abad is logged in as gpasqa
    And he selects the model on CA for 2017 over Infiniti Cars with model Id as 25

  Scenario: update the model information
    When Abad wants to update a model with basic information
      | effectiveDate | languages | currencies   | priceTypes  | modelKind | modelLineCode | program | commercialKind | clientType | phase | comment       | tarrif | modelName             |
      | 07/18/2017    | fr        | CAD          | Retail/MSRP | Test      | TXT5          | Test    | Test           | Test       | 1     | Updated Model | 1      | Model from Serenity 2 |
    Then he should see the updated model