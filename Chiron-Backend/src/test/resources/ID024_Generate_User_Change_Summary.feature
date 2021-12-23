Feature: Generate User Change Summary 
	As a manager, I want to see the total number of users before and after an operation.
	
    
           
Scenario Outline: Manager requests to see the user change summary after removing a single user . (Normal Flow)

		Given BitCoin Trading system is running
    Given the follow user account exist in system:
      | user_name | role   | userstatus | creditlevel |
      | Andrew    | Trader | Normal     | Gold        |
      | Benoit    | Trader | Locked     | Silver      |
      | Claude    | Trader | Normal     | Bronze      |
      | David     | Trader | Normal     | Iron        |
      | Edward    | Trader | Normal     | Diamond     |
      | Frank     | Trader | Locked     | Diamond     |
   When Manager "<user_id>" is logged-in
		When user "manager" requests to generate user change summary   
    When the current total number of users is <before_amount>
    And the user with username "<username>" is removed
    Then the total number of users is <after_amount>
    And the number of user affected is <number>
    
    Examples:
      | before_amount | username	| after_amount	| number	|
      |		6		|	Frank	| 5 |	1	|
      

Scenario Outline: Manager requests to view user summary. (Normal Flow)

		Given BitCoin Trading system is running
    Given the follow user account exist in system:
      | user_name | role   | userstatus | creditlevel |
      | Andrew    | Trader | Normal     | Gold        |
      | Benoit    | Trader | Locked     | Silver      |
      | Claude    | Trader | Normal     | Bronze      |
      | David     | Trader | Normal     | Iron        |
      | Edward    | Trader | Normal     | Diamond     |
      | Frank     | Trader | Locked     | Diamond     |
    When Ordinary user "<user_id>" is logged-in
    When user "user" requests to generate user change summary
    Then The systems returns an error message "<error>" showing that generate user change summary permission denied
   

    Examples:
      | error | 
      | permission denied     |
