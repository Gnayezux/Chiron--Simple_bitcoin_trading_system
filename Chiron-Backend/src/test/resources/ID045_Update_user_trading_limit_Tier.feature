Feature: Update user trading limit Tier
  As a system manager, I want to set a trading volume limit for each user so that I can eliminate the chance of great frauds occuring.

  Scenario Outline: Update a user's trading volume with high score. (Normal Flow)
    Given user with user id <user_id> exists
    And the user <user_id> has feedback score greater than 90
    When update the user <user_id> trading volume to <tier> times
    Then the user <user_id> now has trading volume <tier>

    Examples:
      | user_id | tier   |
      | 001      | 10 |

  Scenario Outline: Update a user's trading volume with high score. (Error Flow)
    Given user with user id <user_id> does not exist
    And the user <user_id> has feedback score greater than 90
    When update the user <user_id> trading volume to <tier> times
    Then the system indicates that the user does not exist

    Examples:
      | user_id | tier   |
      | 001      | 10 |