Feature: Create an advertisement
  As a manager, I wish to edit user credential, so that user recently creditlevel can be shown
  
# to fit the model, credit level are converted to feedback score
# diamond = 90 - 100
# gold = 70-90
# silver = 50-70
# bronze = 30-50
# iron <30. if in iron level, then the user can not post any advertisement
  Background:
    Given BitConin Trading system is running
    Given the follow user account exist in system:
      | user_name | role   | userstatus | creditlevel |
      | lxy       | Trader | Normal     | Gold        |

  Scenario Outline: Manager with legitimate status edits the creditlevel for an existing user(Normal Flow)
    When I request to change the creditlevel for a user with user id <user_id>
    And I enter the following creditlevel:
      | creditlevel |
      | sliver      |
    Then the system indicates that the creditlevel for a user with user id <user_id> has been successfully changed
    And follwoing information is generated
      | user_name | role   | userstatus | creditlevel |
      | lxy       | Trader | Normal     | sliver      |


  Scenario Outline: I don't successfully a user with user id <user_id> because I input an invalid creditlevel (Error Flow)
    When I request to change the creditlevel of a user with user id <user_id>
    And I enter invalid creditlevel
    Then the system warns me that I have entered an invalid creditlevel
    And a user with user id <user_id> does not change


  Scenario Outline: I don't successfully a user with user id <user_id> because I do not have access to do so(Error Flow)
    When I request to change the creditlevel of a user with user id <user_id>
    And I am a normal user
    Then the system warns me that I do not have access to do so
    And a user with user id <user_id> does not change