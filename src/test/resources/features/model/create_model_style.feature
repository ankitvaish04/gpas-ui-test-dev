Feature: create style information for a model

  Background:
    Given Abad is logged in as gpasqa
    And he selects the model on CA for 2017 over Infiniti Cars with model Id as 13

  Scenario: create the model styles with marketing descriptions and pricing
    When Abad wants to create a model style with basic information
      | styleID | styleCode | mfrStyleCode | nCode | styleName | trim         | trimPlus   | versionName | styleSetName |
      | 1       | 91816     | 91816        |       | AWD       | Q50 S Hybrid | 3.5L A/T 7 | English     | BSE          |
    And he wants to create marketing descriptions for the model
      | descriptionTypeId | description          |
      | 1                 | Ext Desc Description |
    And he creates pricing data for the model
      | priceState | modelPricing | effectiveDate | nonEffectiveDate |
      | Actual     | 33730.00     | 07/18/2017    |                  |
    Then he should see the created styles for the model