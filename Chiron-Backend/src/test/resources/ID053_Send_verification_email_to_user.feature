Feature: Send verification email to user
  As a manager, I wish to send verification email to user.

  Background:
    Given BitCoin Trading system is running
    Given a manager with userId "Manager1" exist in system
    Given the follow user account with email exist in system:

      | user_name | role    | userstatus | email			 		|
      | Andrew    | Trader  | Normal     | 123@mcgill.com |
      | Benoit    | Trader  | Locked     | 123@mcgill.com |
      | Claude    | Trader  | Normal     | 123@mcgill.com |
      | David     | Trader  | Normal     | 123@mcgill.com |
      | Antoine   | Manager | Normal     | 123@mcgill.com |


  Scenario Outline: Manager successfully send verification email to user. (Normal Flow)
  	Given the user with username "<user_name>" is logged in
    Given the user with username "<manager_name>" is logged in
    When manager "<manager_name>" send verification email to user.
    Then user "<user_name>" shall received the email in "<email>".

    Examples:
      | user_name | manager_name       | email			 		|
      | Andrew    | Manager1           | 123@mcgill.com |
      

  Scenario Outline: User successfully send verification email to themselves. (Alternate Flow)
  	Given the user with username "<user_name>" is logged in
    When user "<user_name>"  send verification email to themselves.
    Then user "<user_name>" shall received the email in "<email>".

    Examples:
      | user_name | email			 		|
      | Andrew    | 123@mcgill.com |




      
      