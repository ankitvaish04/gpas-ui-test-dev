@CreateEquipments
Feature: create equipment information for a model

  Background:
    Given Abad is logged in as gpasqa
    And he selects the model on CA for 2017 over Infiniti Cars with model Id as 12

  Scenario: create the equipments with descriptions
    When Abad wants to create equipments with basic information
      | isHeader | isSpec | isMostPopular | orderCode | optionKind | utf | flags    | filterRules |
      | false    | true   | true          | I-TEST    | 70         | 0   | DIN      |             |

    And he wants to create equipment descriptions for the model
      | descriptionType   | description      |
      | PON               | Test Description |

    Then he should see the created equipments for the model