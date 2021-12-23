#Author: gengyi.sun@mail.mcgill.ca
Feature: Install patch
  As a project manager, I want to add a new patch to the system.

  Scenario Outline: Manager installs new patch(Normal Flow)

    Given BitCoin Trading system is running
    And A patch is not installed 
    When Manager "<user_id>" is logged-in
    And A new patch is installed by "<user_id>"
    Then The system indicates that a new patch is "<installed>"
    Examples:
      | user_id   |	installed	|
      | manager   |	true			|


  Scenario Outline: User installs new patch (Error Flow)

    Given BitCoin Trading system is running
    And A patch is not installed
    When Ordinary user "<user_id>" is logged-in
    And A new patch is installed by "<user_id>"
    Then The system indicates that a new patch is "<installed>"
    Examples:
      | user_id   |	installed	|
      | user   		| false			|