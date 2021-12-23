Feature: Query completed advertisement

  User Story:
  As a web site manager
  I want to be able to query all completed advertisements
  So that I can check advertisements information


  Scenario: Web site manager query all completed advertisement successfully (Normal flow)
    Given I am website manager
    And the following advertisements exist in the system:
      | advertisementID | advertisementStatus | bitNumber |
      | 1               |  activated          | 10        |
      | 2               |  activated          | 10        |
    And the following trades exist in the system :
      | tradeID | advertisementID | amount | status    |
      | 1001    |          1      |   8    | completed |
      | 1002    |          1      |   2    | completed |
      | 2001    |          2      |   5    | completed |
      | 2002    |          2      |   4    | ongoing   |
      | 2003    |          2      |   1    | cancelled |
    When I request all completed advertisements
    Then the following advertisements should be displayed:
      | advertisementID | advertisementStatus  | bitNumber |
      | 1               |  activated           | 10        |

  Scenario: Web site manager fails to query all completed advertisement (error flow)
    Given I am website manager
    And the following advertisements exist in the system:
      | advertisementID | advertisementStatus | bitNumber |
      | 1               |  activated          | 10        |
      | 2               |  activated          | 10        |
    And the following trades exist in the system :
      | tradeID | advertisementID | amount | status    |
      | 1001    |          1      |   8    | ongoing   |
      | 1002    |          1      |   2    | cancelled |
      | 2001    |          2      |   5    | ongoing   |
      | 2002    |          2      |   4    | completed |
      | 2003    |          2      |   1    | ongoing   |
    When I request all completed advertisements
    Then I will receive an error message that fail to query all completed advertisement