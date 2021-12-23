Feature: Query account balance
  As a website manager, I want to get a specific account's balance in our platform, 
  so that I can check his/her account information.
  
 Background:
    Given I am a website manager
    And the following users exist:
      | user_full_name | account_id | balance   | 
      | Archie Andrews | AA001      | 1000.0    | 
      | Archie Bob 		 | BB001      | 0.0       |

  Scenario: I successfully get an account's balance(Normal Flow)
    When I request to get an account's balance
    And I enter the following ID:
      | account_id |
      | AA001      |
    Then the following information of this account is generated:
      | account_id | balance   |
      | AA001      | 1000.0    |
      
  Scenario: I successfully get an account's balance(Alternate Flow)
    When I request to get an account's balance
    And I enter the following ID:
      | account_id |
      | BB001      |
    Then the following information of this account is generated:
      | account_id | balance   |
      | BB001      | 0.0       |
   
   Scenario: I failed to get an account's balance(Error Flow)
    When I request to get an account's balance
    And I enter the following ID:
      | account_id |
      | CC001      |
    Then the system warns me that I have entered an invalid account ID 