Feature: Monotor bitcoin storage
  As a manager, I wish to monitor bitcoin storage.

  Background:
    Given BitCoin Trading system is running



  Scenario Outline: Successfully monitor bitcoin bitcoin storage.
    Given the manager "<user_id>" account exist in system:
		When "Jack" monitor bitcoin storage.
    Then the  bitcoin storage shall be displayed.
       
				    Examples:
      | user_id  |
      | Jack     |