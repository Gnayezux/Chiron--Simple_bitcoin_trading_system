Feature: Query User List

  As a system manager
  I would like to receive a list of BitCoin Trading System users
  So I that I can adminstrate usage for individuals

  Scenario: List of All Users (Normal Flow)

    Given BitCoin Trading system is running
    And the following users are registered:
      | user_name | user_id       |
      | Ame       | ame@id.com    |
      | Bob       | bod@id.com    |
      | Cooper    | cooper@id.com |
    When system manager requests a list of users
    Then the following list of users is generated:
      | user_name | user_id       |
      | Ame       | ame@id.com    |
      | Bob       | bod@id.com    |
      | Cooper    | cooper@id.com |


  Scenario: Confirm list of users after deleting a user (Alternate Flow)

    Given BitCoin Trading system is running
    And the following users are registered:
      | user_name | user_id       |
      | Amy       | amy@id.com    |
      | Bob       | bod@id.com    |
      | Cooper    | cooper@id.com |
    And user: "Amy" is deleted
    When system manager requests a list of users
    Then the following list of users is generated:
      | user_name | user_id       |
      | Bob       | bod@id.com    |
      | Cooper    | cooper@id.com |


  Scenario: Not System Manager Requests List of Users (Error Flow)

    Given BitCoin Trading system is running
    When not system manager requests a list of users
    Then system returns error