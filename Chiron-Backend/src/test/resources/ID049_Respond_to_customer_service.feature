Feature: Respond to customer service
  As a manager, I wish to respond to customer service.

  Background:
    Given BitCoin Trading system is running
    Given a manager with userId "Manager1" exist in system
    Given the follow user account exist in system:

      | user_name | role    | userstatus | creditlevel |
      | Andrew    | Trader  | Normal     | Gold        |
      | Benoit    | Trader  | Locked     | Silver      |
      | Claude    | Trader  | Normal     | Bronze      |
      | David     | Trader  | Normal     | Iron        |
      | Antoine   | Manager | Normal     | -           |


  Scenario Outline: Manager successfully respond to customer service. (Normal Flow)
    Given the user with username "<user_name>" is logged in
    Given the user with username "<manager_name>" is logged in
    Given the the service with service id "<service_id>" exists.
    When manager "<manager_name>" respond to the service "<service_id>" in the system
    Then the service should be responsed

    Examples:
      | user_name | manager_name       | service_id |
      | Andrew    | Manager1           | 1          |


  Scenario Outline: Manager fail to respond to customer service. (Error Flow)
    Given the user with username "<user_name>" is logged in
    Given the user with username "<manager_name>" is logged in
    Given the the service with service id "<service_id>" exists.
    When manager "<manager_name>" respond to the service "<service_wrong_id>" in the system
    Then an error message with content "Service do not exist!" shall be raised

    Examples:
      | user_name | manager_name       | service_id | service_wrong_id |
      | Andrew    | Manager1           | 1          | 99							 |




      
      