
#see https://cucumber.io/docs/gherkin/reference/
@tag
Feature:  BDD Scenarios of Tag API

  Background:
    Given table tag contains data:
      | id | name |
#      | 17a281a6-0882-4460-9d95-9c28f5852db1 | Development | 
#      | 18a81a6-0882-4460-9d95-9c28f5852db1 | Testing |

  Scenario: Add tag should return 201
    And the following tag to add:
      | name        |
      | Development |
    When call add tag
    Then the http status is 201
    And the returned tag has following properties:
      | name        |
      | Development |

  Scenario Outline: Add tag with name not matching size constraints should return 400
    And the following tag to add:
      | name   |
      | <name> |
    When call add tag
    Then the http status is 400
    And the returned error body looks like:
      | system_id                            | system_name | type       | status | message                                        |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TODOS    | VALIDATION | 400    | name: name must be between 2 and 50 characters |
    Examples:
      | name                                                   |
      | t                                                      |
      | This is a very long tag name that exceeds the maximum allowed length for tag names in the system |

  Scenario: Add tag with null name should return 400
    And the following tag to add:
      | name |
      | null |
    When call add tag
    Then the http status is 400
    And the returned error body looks like:
      | system_id                            | system_name | type       | status | message                |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TODOS    | VALIDATION | 400    | name: name is required |

  Scenario: Add tag with blank name should return 400
    And the following tag to add:
      | name |
      |      |
    When call add tag
    Then the http status is 400
    And the returned error body looks like:
      | system_id                            | system_name | type       | status | message                |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TODOS    | VALIDATION | 400    | name: name is required |

  Scenario: Find all tags should return 200
    Given table tag contains data:
      | id                                   | name        |
      | 17a281a6-0882-4460-9d95-9c28f5852db1 | Development |
      | 18a81a6-0882-4460-9d95-9c28f5852db1  | Testing     |
    When call find all tags with page=0, size=10 and sort=name,asc
    Then the http status is 200
    And the returned page has following tag content:
      | name        |
      | Development |
      | Testing     |

  Scenario: Find all tags with pagination should return 200
    Given table tag contains data:
      | id                                   | name        |
      | 17a281a6-0882-4460-9d95-9c28f5852db1 | Development |
      | 18a81a6-0882-4460-9d95-9c28f5852db1  | Testing     |
      | 19a281a6-0882-4460-9d95-9c28f5852db1 | Production  |
    When call find all tags with page=0, size=2 and sort=name,asc
    Then the http status is 200
    And the returned page has following tag content:
      | name        |
      | Development |
      | Production  |

  Scenario: Find tag by id should return 200
    Given table tag contains data:
      | id                                   | name        |
      | 17a281a6-0882-4460-9d95-9c28f5852db1 | Development |
    When call find tag by id with id="17a281a6-0882-4460-9d95-9c28f5852db1"
    Then the http status is 200
    And the returned tag has following properties:
      | name        |
      | Development |

  Scenario: Find tag by non-existing id should return 404
    When call find tag by id with id="99999999-9999-9999-9999-999999999999"
    Then the http status is 404
    And the returned error body looks like:
      | system_id                            | system_name | type      | status | message                                                      |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TODOS    | NOT_FOUND | 404    | Item with id=99999999-9999-9999-9999-999999999999 not found |

  Scenario: Find tag by invalid id format should return 400
    When call find tag by id with id="invalid-id"
    Then the http status is 400

  Scenario: Update tag should return 202
    Given table tag contains data:
      | id                                   | name        |
      | 17a281a6-0882-4460-9d95-9c28f5852db1 | Development |
    And the following tag to update:
      | name    |
      | DevOps  |
    When call update tag with id="17a281a6-0882-4460-9d95-9c28f5852db1"
    Then the http status is 202
    And the returned tag has following properties:
      | name   |
      | DevOps |

  Scenario: Update tag with non-existing id should return 404
    And the following tag to update:
      | name    |
      | DevOps  |
    When call update tag with id="99999999-9999-9999-9999-999999999999"
    Then the http status is 404
    And the returned error body looks like:
      | system_id                            | system_name | type      | status | message                                                      |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TODOS    | NOT_FOUND | 404    | Item with id=99999999-9999-9999-9999-999999999999 not found |

  Scenario Outline: Update tag with invalid name should return 400
    Given table tag contains data:
      | id                                   | name        |
      | 17a281a6-0882-4460-9d95-9c28f5852db1 | Development |
    And the following tag to update:
      | name   |
      | <name> |
    When call update tag with id="17a281a6-0882-4460-9d95-9c28f5852db1"
    Then the http status is 400
    And the returned error body looks like:
      | system_id                            | system_name | type       | status | message                                        |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TODOS    | VALIDATION | 400    | name: name must be between 2 and 50 characters |
    Examples:
      | name                                                   |
      | t                                                      |
      | This is a very long tag name that exceeds the maximum allowed length for tag names in the system |

  Scenario: Delete tag should return 204
    Given table tag contains data:
      | id                                   | name        |
      | 17a281a6-0882-4460-9d95-9c28f5852db1 | Development |
    When call delete tag with id="17a281a6-0882-4460-9d95-9c28f5852db1"
    Then the http status is 204

  Scenario: Delete tag with non-existing id should return 404
    When call delete tag with id="99999999-9999-9999-9999-999999999999"
    Then the http status is 404
    And the returned error body looks like:
      | system_id                            | system_name | type      | status | message                                                      |
      | be7e84a8-9f56-405b-a15a-2646a8012c89 | MS-TODOS    | NOT_FOUND | 404    | Item with id=99999999-9999-9999-9999-999999999999 not found |

  Scenario: Delete tag with invalid id format should return 400
    When call delete tag with id="invalid-id"
    Then the http status is 400