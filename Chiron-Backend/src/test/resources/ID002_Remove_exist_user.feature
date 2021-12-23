Feature: Remove existing user
  As a system manager, I want to remove an existing user on the system.

  Scenario Outline: Remove user by user name and user id(Normal Flow)

    Given BitCoin Trading system is running
    Given user <user_name> with user id <user_id> exists
    When removes user <user_name> with user id <user_id>
    Then user <user_name> with user id <user_id> is removed
    Examples:
      | user_name | user_id       |
      | Amy       | amy@id.com    |
      | Bob       | bod@id.com    |
      | Cooper    | cooper@id.com |

  Scenario Outline: Remove user by user id(Alternate Flow)

    Given BitCoin Trading system is running
    Given user with user id <user_id> exists
    When removes user with user id <user_id>
    Then user with user id <user_id> is removed
    Examples:
      | user_id       |
      | amy@id.com    |
      | bod@id.com    |
      | cooper@id.com |


  Scenario Outline: Remove non-existing user (Error Flow)

    Given BitCoin Trading system is running
    Given user <user_name> with user id <user_id> does not exist
    When removes user <user_name> with user id <user_id>
    Then the system returns error
    Examples:
      | user_name | user_id       |
      | Amy       | amy@id.com    |
      | Bob       | bod@id.com    |
      | Cooper    | cooper@id.com |
