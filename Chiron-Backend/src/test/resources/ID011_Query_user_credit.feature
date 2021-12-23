Feature: Query user credit

  As a website manager
  I want to be able to receive credits information of particular user
	This function is to facilitate the management of the website, allowing manager to take control over use's status


# to fit the model, credit level are converted to feedback score
# diamond = 90 - 100
# gold = 70-90
# silver = 50-70
# bronze = 30-50
# iron <30. if in iron level, then the user can not post any advertisement
  Background:
    Given a manager with userId "Manager1" exist in system
    Given the follow user account exist in system:
      | user_name | role   | userstatus | creditlevel |
      | lxy       | Trader | Normal     | Gold        |
      | David     | Trader | Normal     | Iron        |
      | Edward    | Trader | Normal     | Diamond     |
      | Frank     | Trader | Locked     | Diamond     |

  Scenario: Manager successfully queried the credit level of a particular user (normal flow)
    When manager queries the following user with <user_name>
    Then the following credit level <creditlevel> is returned
      | user_name | creditlevel |
      | lxy       | Gold        |
      | David     | Iron        |
      | Edward    | Diamond     |
      | Frank     | Diamond     |

  Scenario: Manager queried the credit level of a unexisting user (normal flow)
    When manager queries the following user with "not existing"
    Then an error message with content "User do not exist!" shall be raised