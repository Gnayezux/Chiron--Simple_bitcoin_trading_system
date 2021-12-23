Feature: Monotor bitcoin exchange rate
  As a manager, I wish to monitor exchange rate.

  Background:
    Given BitCoin Trading system is running



  Scenario Outline: Successfully monitor bitcoin exchange rate.
    Given the manager "<user_id>" account exist in system:
		When "Jack" monitor exchange rate.
    Then the  bitcoin exchange rate shall be displayed.
    
    Examples:
      | user_id  |
      | Jack     |