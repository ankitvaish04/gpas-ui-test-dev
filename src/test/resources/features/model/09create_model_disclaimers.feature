@CreateDisclaimers
Feature: create disclaimers for a model

  Background:
    Given Abad is logged in as gpasqa
    And he selects the model on CA for 2017 over Infiniti Cars with model Id as 25

  Scenario: create disclaimers for a model
    When Abad wants to create disclaimers with basic information
      | refCode | shortName | description       |
      | 1       | TEST1     | Test Disclaimer 1 |
      | 2       | TEST2 ®® Ⓐ € ©© ™™ ££ ¥¥ ① ② ③ ④ ⑤ ⑥ ⑦ ⑧ ⑨ ⑩ | ®® Test Disclaimer 2 Ⓐ € ©© ™™ ££ ¥¥ ① ② ③ ④ ⑤ ⑥ ⑦ ⑧ ⑨ ⑩ |
      | 3       | TEST3     | Test Disclaimer 3 |

    Then he should see the created disclaimers for the model