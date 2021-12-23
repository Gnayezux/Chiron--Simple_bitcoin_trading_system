Feature: Query requests
  As a manager, I wish to query requests in the system.

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


  Scenario Outline: Manager successfully query requests. (Normal Flow)
    Given the user with username "<manager_name>" is logged in
    Given the the service with service id "<service_id>" exists.
    When manager "<manager_name>" query requests in the system.
    Then all the service shall be displayed.

    Examples:
      | user_name | manager_name       | service_id |
      | Andrew    | Manager1           | 1          |




      
      