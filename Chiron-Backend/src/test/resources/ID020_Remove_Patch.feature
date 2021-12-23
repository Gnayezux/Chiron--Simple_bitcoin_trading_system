Feature: Remove patch
  As a project manager, I want to remove a patch from the system.

  Scenario Outline: Manager removes patch(Normal Flow)

    Given BitCoin Trading system is running
    And A patch in already installed
    When Manager "<user_id>" is logged-in
    And A new patch is removed by "<user_id>"
    Then The system indicates that a new patch is "<installed>"
    Examples:
      | user_id   | installed	|
      | manager   | false			|


  Scenario Outline: User removes patch (Error Flow)

    Given BitCoin Trading system is running
    And A patch in already installed
    When Ordinary user "<user_id>" is logged-in
    And A new patch is removed by "<user_id>"
    Then The system indicates that a new patch is "<installed>"
    Examples:
      | user_id   |	installed	|
      | user   		| true			|
