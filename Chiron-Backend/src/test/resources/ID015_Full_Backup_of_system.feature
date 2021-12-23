Feature: Full backup of system
  As a project manager, I want to get a full backup of system.

  Scenario Outline: Manager backup system(Normal Flow)

    Given BitCoin Trading system is running 
    When Manager "<user_id>" is logged-in
    And A backup is created by "<user_id>"
    Then The system indicates that a new patch is "<backuped>"
    Examples:
      | user_id   |	backuped	|
      | manager   |	true			|


  Scenario Outline: User backup system (Error Flow)

    Given BitCoin Trading system is running 
    When user "<user_id>" is logged-in
    And A backup is created by "<user_id>"
    Then The system indicates that a new patch is "<backuped>"
    Examples:
      | user_id   |	backuped	|
      | user   		| false			|