Feature: Open A Trade
  As a normal user, I wish to open a trade for an existing advertisement, so that other users can contact me
  to trade bitcoins.


  Scenario Outline: Open a new trade with existing advertisement (Normal flow)
    Given BitCoin Trading system is running
    Given user id <user_id> already exists
    Given buyer <user_id_buyer> already exists
    Given user id <user_id_buyer> wants to trade bitcoins
    And <user_id> created an advertisement <advertisement_id> with amount <amount>
    When <user_id> opens a trade
    Then a trade is created with <trade_id>
    And the start time is <start_time>
    And the amount of the trade <trade_id> is <amount>
    And the trade status of the trade <trade_id> is "in process"

    Examples:
      | user_id | user_id_buyer | advertisement_id | amount | start_time          |
      | name1   | test1         | ad1              | 10     |    12/01/2020       |
      | name2   | test2         | ad2              | 20     |     12/01/2020      |
 

  Scenario Outline: Open a new trade with zero amount (Error flow)
    Given BitCoin Trading system is running
    Given user id <user_id> already exists
    Given user id <user_id_buyer> wants to trade bitcoins
    And <user_id> created an advertisement <advertisement_id> with amount "0"
    When <user_id> opens a trade
    Then a trade cannot be created

    Examples:
      | user_id | user_id_buyer | advertisement_id | amount |
      | name1   | test1         | ad1              | 0      |

  Scenario Outline: Open a new trade with non existing user (Error flow)
    Given BitCoin Trading system is running
    Given user id <user_id> already exists
    Given user id <user_id_buyer> does not exist
    When <user_id> opens a trade
    Then a trade cannot be created

    Examples:
      | user_id | user_id_buyer |
      | name1   | test1         |

      