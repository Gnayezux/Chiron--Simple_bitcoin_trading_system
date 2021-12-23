Feature: Add new user
  As a project manager, I want to add a new user to the system.

  Scenario Outline: New user with user name, user passcode and user email(Normal Flow)

    Given BitCoin Trading system is running
    When user "<user_id>" with user passcode "<user_passcode>" and user email "<user_email>" registered
    Then new user "<user_id>" with user id "<user_passcode>" and user email "<user_email>" is created
    Examples:
      | user_id   | user_passcode | user_email       |
      | Gloria    | 1234567       | gloria@gmail.com |
      | lxy       | abcdefg       | lxy@gmail.com    |
      | liuyuelin | liuyuelin     | lyl@gmail.com    |


  Scenario Outline: New user with taken user id (Error Flow)

    Given BitCoin Trading system is running
    Given user id "<user_id>" already exists
    When user "<user_id>" with user email "<user_email>" registered
    Then new user "<user_id>" with user email "<user_email>" is not created
    And the system returns an error message "<error>" indicate "email already registered"
    Examples:
      | user_id | user_email | error                    |
      | Amy     | amy@id.com | email already registered |
      | Bob     | amy@id.com | email already registered |