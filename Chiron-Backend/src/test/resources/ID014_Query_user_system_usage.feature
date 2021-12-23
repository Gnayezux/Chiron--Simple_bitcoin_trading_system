
Feature: Query user system usage
  As a website manager, I want to get a specific user's system usage report
  so that I can check his/her account information.


 Background:
    Given I am a website manager
    And the following users exist:
      | user_full_name | account_id | User_summary   | 
      | Archie Andrews | AA001      | 		1234       |
      

  Scenario: I successfully get a user's system usage report(Normal Flow)
    When I request to get a user's system usage report
    And I enter the following ID:
      | account_id |
      | AA001      |
    Then the following information of this user is generated:
      | account_id | User_summary   |
      | AA001      | 			1234	    |
      
   
   Scenario: I failed to get a user's usage report(Error Flow)
    When I request to get a user's usage report
    And I enter the following ID:
      | account_id |
      | CC001      |
    Then the system warns me that I have entered an invalid account ID 