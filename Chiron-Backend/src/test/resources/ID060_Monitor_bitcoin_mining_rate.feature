Feature: Monotor bitcoin mining rate
  As a manager, I wish to monitor mining rate.

  Background:
    Given BitCoin Trading system is running



  Scenario Outline: Successfully monitor bitcoin mining rate.
    Given the manager "<user_id>" account exist in system:
		When "Jack" monitor mining rate.
    Then the  bitcoin mining rate shall be displayed.
       
				    Examples:
      | user_id  |
      | Jack     |