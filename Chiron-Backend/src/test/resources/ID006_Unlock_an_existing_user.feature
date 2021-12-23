Feature: Unlock an existing user
  As a manager, I wish to unlock an user account to permit any transactional or business activities.
  This usually happens when a user restore a legit user pattern, or once a request associated with the user has been resolved.
  
# to fit the model, credit level are converted to feedback score
# diamond = 90 - 100
# gold = 70-90
# silver = 50-70
# bronze = 30-50
# iron <30. if in iron level, then the user can not post any advertisement
  Background:
    Given BitConin Trading system is running
    Given a manager with userId "Manager1" exist in system
    Given the follow user account exist in system:
      | user_name | role   | userstatus | creditlevel |
      | lxy       | Trader | Normal     | Gold        |
      | wyn       | Trader | Locked     | Gold        |

  Scenario Outline: Manager unlock a existing locked user(Normal Flow)
    When manager tries to unlock a user with id "wyn"
    Then user with id "lxy" should have the status changed to "Normal"

  Scenario Outline: Manager unlock a existing normal user(Normal Flow)
    When manager tries to unlock a user with id "lxy"
    Then user with id "wyn" should have the status changed to "Normal"

  Scenario Outline: Manager unlock a unexisting user (error flow)
 		When manager tries to unlock a user with id "notexisitng"
    Then an error message with content "User do not exist!" shall be raised
    