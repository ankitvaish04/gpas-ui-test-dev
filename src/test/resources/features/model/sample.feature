Feature: post a model to nna webservice

  In order to query relevant model information such as, EIMs, Versions, Equipments, Disclaimers and Descriptions
  Post a model in JSON to NNA Inbound Webservice

  Scenario: add a model to nna webservices
    When I add a model to nna datastore
      | ymmid      |
      | 28243.json |
    Then the model is added to the datastore
