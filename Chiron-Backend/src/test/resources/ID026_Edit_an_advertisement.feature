Feature: Edit an advertisement
  As a normal user, I wish to edit my advertisement about BitCoin trade, so that the new changes can be updated to my advertisement
  
# to fit the model, credit level are converted to feedback score
# diamond = 90 - 100
# gold = 70-90
# silver = 50-70
# bronze = 30-50
# iron <30. if in iron level, then the user can not post any advertisement
  Background:
    Given BitCoin Trading system is running
    Given the follow user and advertisement exist in the system:
      | user_name | role   | userstatus | creditlevel | advertisementID | coinNumber | pricePerBit | currency |
      | lxy       | Trader | Normal     | Gold        | 1               | 0.02       | 200000      | RMB      |

  Scenario Outline: Trader with legitimate status and an adequate credit level edits an existing advertisement with my new coinNumber(Normal Flow)
    When I request to change the coinNumber for an advertisement with advertisement ID "<advertisementID>"
    And I enter the following "<coinNumber>"
    Then the system indicates that an advertisement with advertisement ID <advertisementID> has been successfully changed with the following "<coinNumber>"
    Examples:
      | advertisementID | coinNumber | pricePerBit | currency |
      | 1               | 0.1        | 200000      | RMB      |

  Scenario Outline: Trader with legitimate status and an adequate credit level edits an existing advertisement with my new pricePerBit(Alternative Flow)
    When I request to change the pricePerBit for an advertisement with advertisement ID "<advertisementID>"
    And I enter the following "<pricePerBit>"
    Then the system indicates that an advertisement with advertisement ID "<advertisementID>" has been successfully changed to "<pricePerBit>"
    Examples:
      | advertisementID | coinNumber | pricePerBit | currency |
      | 1               | 0.02       | 10000       | RMB      |

  Scenario Outline: Trader with legitimate status and an adequate credit level edits an existing advertisement with currency(Alternative Flow)
    When I request to change the currency for an advertisement with advertisement ID "<advertisementID>"
    And I enter the following <currency>
    Then the system indicates that an advertisement with advertisement ID "<advertisement_id>" has been successfully changed
    Examples:
      | advertisementID | coinNumber | pricePerBit | currency |
      | 1               | 0.02       | 200000      | USD      |