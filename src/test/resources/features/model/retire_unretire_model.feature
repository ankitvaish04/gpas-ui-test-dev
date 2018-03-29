@RetireUnretireModel
Feature: Retire/Unretire a model

  In order to retire/unretire a model, user should be able to select and retire/unretire it from GPAS Home page

  Background:
    Given Abad is logged in as gpasqa

  Scenario: retire a model with basic model information
    When Abad selects a model to retire with basic information
    | country | modelYear | subdivision   | modelName             | modelPermId |
    | CA      | 2017      | Infiniti Cars | Imported Model 1      | 18          |

    And he retires the selected model

    Then he should see the model as retired

  @Pending
  Scenario: unretire a model with basic model information
      When Abad selects a model to unretire with basic information
      | country | modelYear | subdivision   | modelName             | modelPermId |
      | CA      | 2017      | Infiniti Cars | Imported Model 1      | 18          |

      And he unretires the selected model

      Then he should see the model as unretired