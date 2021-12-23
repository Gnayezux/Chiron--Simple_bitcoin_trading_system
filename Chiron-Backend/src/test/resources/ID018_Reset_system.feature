Feature: Reset system
  As a project manager, I want to reset system.

  Scenario Outline: Manager resets system(Normal Flow)

    Given BitCoin Trading system is running 
    When Manager "<user_id>" is logged-in
    Then The system indicates that it is "<resetted>"
    Examples:
      | user_id   |	resseted	|
      | manager   |	true			|


  Scenario Outline: User resets system (Error Flow)

    Given BitCoin Trading system is running 
    When user "<user_id>" is logged-in
    Then The system indicates that it is "<resetted>"
    Examples:
      | user_id   |	resetted	|
      | user   		| false			|