Feature: Query user status
  As a website manager, I want to get a specific user's status in our platform, 
  so that I can check his/her account information.
  
 Background:
    Given I am a website manager
    And the following users exist:
      | user_full_name | account_id | status   | 
      | Archie Andrews | AA001      | "good"   |
      | Archie Bob 		 | BB001      | "locked" |

  Scenario: I successfully get a user's status(Normal Flow)
    When I request to get a user's status
    And I enter the following ID:
      | account_id |
      | AA001      |
    Then the following information of this user is generated:
      | account_id | status   |
      | AA001      | "good"   |
      
  Scenario: I successfully get a user's status(Alternate Flow)
    When I request to get a user's status
    And I enter the following ID:
      | account_id |
      | BB001      |
    Then the following information of this user is generated:
      | account_id | status   |
      | BB001      | "locked"   |
   
   Scenario: I failed to get a user's status(Error Flow)
    When I request to get a user's status
    And I enter the following ID:
      | account_id |
      | CC001      |
    Then the system warns me that I have entered an invalid account ID 