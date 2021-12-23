Feature: Cancel an advertisement
  As a normal user, I wish to cancel advertisement about some potential Bitcoin Trades, so that other users cannot contact me
  to create new Trades.


  Scenario Outline: cancel an existing advertisement (Normal flow)
    Given BitCoin Trading system is running
    Given user id <user_id> already exists
    And <user_id> created an advertisement <advertisement_id>
    When <user_id> wants to cancel this advertisement
    Then <advertisment_id> is deleted
    And the related trades are also canceled in this system
    
    Examples:
      | user_id | advertisment_id |
      | name1   | ad1             |
      | name2   | ad2             |

  Scenario Outline: cancel a non-existing advertisement (Error flow)
    Given BitCoin Trading system is running
    Given user id <user_id> already exists
    And <advertisement_id> does not exist
    When <user_id> wants to cancel this advertisement 
    Then there is nothing to delete, the system should generate a warning
    
    Examples:
      | user_id | advertisement_id |
      | name1   | testid           |
