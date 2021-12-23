Feature: Manage user email contact
  As a user, I want to add multiple email addresses so that I can contact them.

  Scenario Outline: User adds one email address to its contact. (Normal Flow)

    Given BitCoin Trading system is running
    Given user with user id <user_id> exists
    When adds an email address <email> to the user <user_id>
    Then the user <user_id> account now has the contact email address <email>

    Examples:
      | user_id | email   |
      | 001      | 011@gmail.com |
      | 002      | 012@gmail.com |
      | 003      | 013@gmail.com |

  Scenario Outline: User adds two email addresses to its contact. (Alternate Flow)

    Given BitCoin Trading system is running
    Given user with user id <user_id> exists
    When adds an email address <email1> to the user <user_id>
    And adds an email address <email2> to the user <user_id>
    Then the user <user_id> account now has the contact email address <email1> and <email2>

    Examples:
      | user_id | email1   |email2   |
      | 001      | 011@gmail.com | aaa@gmail.com |
      | 002      | 012@gmail.com | bbb@gmail.com |
      | 003      | 013@gmail.com | ccc@gmail.com |

  Scenario Outline: User adds one email addresses to its contact. (Error Flow)

    Given BitCoin Trading system is running
    Given user with user id <user_id> does not exist
    When adds an email address <email> to the user <user_id>
    Then the system indicates that the user does not exist

    Examples:
      | user_id | email   |
      | 001      | 011@gmail.com |
      | 002      | 012@gmail.com |
      | 003      | 013@gmail.com |