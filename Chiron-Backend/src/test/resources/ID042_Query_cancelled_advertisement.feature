Feature: Query cancelled advertisement

  User Story:
  As a web site manager
  I want to be able to query all disabled advertisements
  So that I can check all previous advertisements information


  Scenario: Web site manager query all disabled advertisement successfully (Normal flow)
    Given I am website manager
    And the following advertisements exist in the system:
      | advertisementID | advertisementStatus |
      | 1               |  activated          |
      | 2               |  disabled           |
    When I request all disabled advertisements
    Then the following advertisements should be displayed:
      | advertisementID | advertisementStatus |
      | 2               |  disabled           |

  Scenario: Web site manager fails to query all disabled advertisement (error flow)
    Given I am website manager
    And the following advertisements exist in the system:
      | advertisementID | advertisementStatus |
      | 1               |  activated          |
      | 2               |  activated          |
      | 3               |  activated          |
      | 4               |  activated          |
    When I request all disabled advertisements
    Then I will receive an error message that fail to query all disabled advertisement