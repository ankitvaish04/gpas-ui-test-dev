Feature: create new model

  In order to create the model versions, equipments, pricing, eim and disclaimers for a model
  Create the model for a given country, year, division and the subdivision

  Background:
    Given Abad is logged in as gpasqa

  Scenario: create a model with basic model information
    And Abad wants to create a model with basic information
      | country | modelYear | subdivision   | modelName             | modelId |
      | CA      | 2017      | Infiniti Cars | Model from Serenity 1 | 21      |
    When he has completed creating the model
    Then he should see the created model
