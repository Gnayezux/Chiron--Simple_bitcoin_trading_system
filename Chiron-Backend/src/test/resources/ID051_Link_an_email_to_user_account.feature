Feature: Link an email to user account
  As a user, I want to link my email address to my account, so that I may retrieve password if forgot.

  Scenario Outline: Seller comments on the completed trade with buyer. (Normal Flow)

    Given BitCoin Trading system is running
    Given user with user id <user_id> exists
    When link an email address <email> to the user <user_id>
    Then the user <user_id> account is not linked to the email address <email>

    Examples:
      | user_id | email   |
      | 001      | 011@gmail.com |
      | 002      | 012@gmail.com |
      | 003      | 013@gmail.com |
  Scenario Outline: Seller comments on the completed trade with buyer. (Error Flow)

    Given BitCoin Trading system is running
    Given user with user id <user_id> does not exist
    When link an email address <email> to the user <user_id>
    Then the system indicates that the user does not exist

    Examples:
      | user_id | email   |
      | 001      | 011@gmail.com |
      | 002      | 012@gmail.com |
      | 003      | 013@gmail.com |

