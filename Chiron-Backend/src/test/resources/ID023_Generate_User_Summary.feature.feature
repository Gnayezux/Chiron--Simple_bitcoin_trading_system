Feature: Generate User Summary 
	As a manager, I want to see the total number of users.
	
    
           
Scenario Outline: Manager requests to view user summary. (Normal Flow)

		Given BitCoin Trading system is running
    Given the follow user account exist in system:
      | user_name | role   | userstatus | creditlevel |
      | Andrew    | Trader | Normal     | Gold        |
      | Benoit    | Trader | Locked     | Silver      |
      | Claude    | Trader | Normal     | Bronze      |
      | David     | Trader | Normal     | Iron        |
      | Edward    | Trader | Normal     | Diamond     |
    
     When Manager "<user_id>" is logged-in
    When manager "<user_id>" requests to generate user summary
    Then the total number of users is <amount>

     Examples:
      | user_id   | amount | 
      | manager |			5	|
      

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
    When user "<user_id>" requests to generate user summary
    Then The systems returns an error message "<error>" showing view user summary permission denied
   

    Examples:
      |user_id| error | 
      | user | permission denied    |
