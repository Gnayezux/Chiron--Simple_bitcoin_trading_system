Feature: change user credit

  As a website manager
	I want to make sure that the credit level of users are automatically updated or could be manually set


# to fit the model, credit level are converted to feedback score
# diamond = 90 - 100
# gold = 70-90
# silver = 50-70
# bronze = 30-50
# iron <30. if in iron level, then the user can not post any advertisement
  Background:
  Given a manager with userId "Manager1" exist in system
    Given the follow user account exist in system with exact credit score:
      | user_name | role   | userstatus | creditscore |  
      | lxy       | Trader | Normal     | 95          |
      | David     | Trader | Normal     | 70          |
      | Edward    | Trader | Normal     | 30          |
      | Frank     | Trader | Locked     | 30          |

  Scenario: After complete trade, the user's credit level increase (normal flow)
    When user "lxy" complete a trade
    Then the credit score of user "lxy" should be greater then "95"
      
  Scenario: After declining trade, the user's credit level decrease (normal flow)
    When user "lxy" decline a trade
    Then the credit score of user "lxy" should be less then "95"

  Scenario: Manager hard-reset a user's credit score to a arbitrary value (Alternate flow)
    When manager select user "frank" and set the credit to be "50"
    Then the credit score of user "lxy" should be equal to "50"
    
  Scenario: Manager set invalid value to user's credit (error flow)
    When manager select user <user_name> and set the credit to be <trial_credit_value>
    Then an error message with content <error> shall be raised 
      | user_name | trial_credit_value  | error      | 
      | David     | -2                  | "exceeding minimum of cradit score!"    |
      | Edward    | 2500                | "exceeding maximum of cradit score!"    |
      