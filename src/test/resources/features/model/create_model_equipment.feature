@CreateEquipments
Feature: create equipment information for a model

  Background:
    Given Abad is logged in as gpasqa
    And he selects the model on CA for 2017 over Infiniti Cars with model Id as 12

  Scenario: create the equipments with descriptions
    When Abad wants to create equipments with basic information
      | isHeader | isSpec | isMostPopular | orderCode | optionKind | utf | flags    | filterRules |
      | N        | Y      | Y             | I-TEST    | 70         | 0   | DIN      |             |

    And he wants to create equipment descriptions for the model
      | descriptionType          | description      |
      | PON                      | Test Description |

    Then he should see the created equipments for the model

  Scenario: create the equipments with descriptions
    When Abad wants to create equipments with basic information
      | isHeader | isSpec | isMostPopular | orderCode | optionKind | utf | flags    | filterRules |
      | N        |        | Y             | I-091     | 0          | 0   | DIN      |             |

    And he wants to create equipment descriptions for the model
      | descriptionType          | description      |
      | PON                      | AM/FM/CD audio system with 5.8\" color touch-screen monitor |

    Then he should see the created equipments for the model

  Scenario: create the equipments with descriptions
    When Abad wants to create equipments with basic information
      | isHeader | isSpec | isMostPopular | orderCode | optionKind | utf | flags    | filterRules |
      | N        | Y      | Y             | I-090     | 0          | 0   | PIN      |             |

    And he wants to create equipment descriptions for the model
      | descriptionType          | description      |
      | Copy                     | Keep tabs on your technology through Sentra’s 5” color display. Get a read out from available features like Bluetooth® streaming audio, SiriusXM® Satellite Radio, and the Hands-free text messaging assistant, front and center. [2017_SENTRA_20,2017_SENTRA_49,2017_SENTRA_101,2017_SENTRA_110] |
      | PON                      | AM/FM/CD audio system with 5.0\" color display |

    Then he should see the created equipments for the model

  Scenario: create the equipments with descriptions
    When Abad wants to create equipments with basic information
      | isHeader | isSpec | isMostPopular | orderCode | optionKind | utf | flags    | filterRules |
      | Y        |        |               | HDR09     | 0          | 0   | PIN      |             |

    And he wants to create equipment descriptions for the model
      | descriptionType          | description      |
      | PON                      | Audio / Entertainment |

    Then he should see the created equipments for the model

  Scenario: create the equipments with descriptions
    When Abad wants to create equipments with basic information
      | isHeader | isSpec | isMostPopular | orderCode | optionKind | utf | flags    | filterRules |
      | N        |        |               | H01       | 0          | 0   | PIN      |             |

    And he wants to create equipment descriptions for the model
      | descriptionType          | description      |
      | Installation Disclaimer  | Installation Disclaimer |
      | PON                      | Technology Package |

    Then he should see the created equipments for the model

  Scenario: create the equipments with descriptions
    When Abad wants to create equipments with basic information
      | isHeader | isSpec | isMostPopular | orderCode | optionKind | utf | flags    | filterRules |
      | Y        |        |               | HDR06     | 0          | 0   | PIN      |             |

    And he wants to create equipment descriptions for the model
      | descriptionType          | description      |
      | Installation Disclaimer  | Installation Disclaimer - Packages |
      | Image Disclaimer         | Image Disclaimer - Packages |
      | PON                      | Packages |

    Then he should see the created equipments for the model

  Scenario: create the equipments with descriptions
    When Abad wants to create equipments with basic information
      | isHeader | isSpec | isMostPopular | orderCode | optionKind | utf | flags    | filterRules |
      | N        |        |               | I-EN1     | 6          | 0   | PIN      |             |

    And he wants to create equipment descriptions for the model
      | descriptionType          | description      |
      | Installation Disclaimer  | Installation Disclaimer |
      | PON                      | 3.5-liter V6 with Infiniti Direct Response Hybrid®, utilizing a lithium-ion battery and 50 kW electric motor |

    Then he should see the created equipments for the model

  Scenario: create the equipments with descriptions
    When Abad wants to create equipments with basic information
      | isHeader | isSpec | isMostPopular | orderCode | optionKind | utf | flags    | filterRules |
      | Y        |        |               | HDR001    | 0          | 0   | PIN      |             |

    And he wants to create equipment descriptions for the model
      | descriptionType          | description      |
      | Installation Disclaimer  | Installation Disclaimer - Power Engine |
      | Image Disclaimer         | Image Disclaimer - Power Engine |
      | PON                      | Power - Engine |

    Then he should see the created equipments for the model