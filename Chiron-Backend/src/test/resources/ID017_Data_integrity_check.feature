Feature: Data integrity check
  As a project manager, I want to check integrity of data.

  Scenario Outline: Manager checks integrity(Normal Flow)

    Given BitCoin Trading system is running 
    When Manager "<user_id>" is logged-in
    Then The system indicates the integrity of the system is "<integrity>"
    Examples:
      | user_id   |	integrity	|
      | manager   |	true			|


  Scenario Outline: User checks integrity (Error Flow)

    Given BitCoin Trading system is running 
    When user "<user_id>" is logged-in
    Then the system display error message to warn the user 
    Examples:
      | user_id   |	integrity	|
      | user   		| false			|