Feature: Restore full backup
  As a project manager, I want to restore a full backup of system.

  Scenario Outline: Manager backup system(Normal Flow)

    Given BitCoin Trading system is running 
    When Manager "<user_id>" is logged-in
    And the system has a backup
    Then The system indicates that the system is "<restored>"
    Examples:
      | user_id   |	backuped	| restored |
      | manager   |	true			|	true   	 |


  Scenario Outline: User installs new patch (Error Flow)

    Given BitCoin Trading system is running 
    When manager "<user_id>" is logged-in
    And the system has no backup
    Then The system indicates that the system is not "<restored>"
    Examples:
      | user_id   |	backuped	| restored |
      | manager  	| false			|	false		 |