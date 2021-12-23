Feature: Change user attributes

  User Story:
  As a normal user
  I want to be able to change my account attributes
  With new email and passcode So that I can update my new personal information

  Background:
    Given I am a normal user with user id <user_id>
    Given following user exist:
      | user_full_name | account_id | password | email           |
      | User1          | AA001      | 1234567  | user1@gmail.com |
    And I have new password and email:
      | phone number | email         |
      | 3456789      | lxy@gmail.com |

  Scenario: I successfully change my account attributes with my new password (Normal Flow)
    When I request to change a password in my account
    And I enter the following password:
      | password |
      | 3456789  |
    Then the system indicates that my account attribute has been successfully changed
    And following information is generated:
      | user_full_name | account_id | phone number | email           |
      | User1          | AA001      | 3456789      | user1@gmail.com |

  Scenario:  I successfully change my account attributes with my new email (alternate Flow)
    When I request to change a email in my account
    And I enter the following email:
      | email         |
      | lxy@gmail.com |
    Then the system indicates that my account attribute has been successfully changed
    And following information is generated:
      | user_full_name | account_id | phone number | email         |
      | User1          | AA001      | 1234567      | lxy@gmail.com |

  Scenario: I don't successfully change my account attributes because I input an invalid password (Error Flow)
    When I request to change a password in my account
    And I enter invalid password
    Then the system warns me that I have entered an invalid password
    And my account password does not change

  Scenario: I don't successfully change my account attributes because I input an invalid email (Error Flow)
    When I request to change a email in my account
    And I enter invalid email address
    Then the system warns me that I have entered an invalid email address
    And my account does not change