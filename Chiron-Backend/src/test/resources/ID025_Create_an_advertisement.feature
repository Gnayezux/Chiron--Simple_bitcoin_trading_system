Feature: Create an advertisement
  As a normal user, I wish to post advertisement about some potential Bitcoin Trades, so that other users can contact me
  to create new Trades.

# to fit the model, credit level are converted to feedback score
# diamond = 90 - 100
# gold = 70-90
# silver = 50-70
# bronze = 30-50
# iron <30. if in iron level, then the user can not post any advertisement
  Background:
    Given BitCoin Trading system is running
    Given the follow user account exist in system:

      | user_name | role   | userstatus | creditlevel |
      | Andrew    | Trader | Normal     | Gold        |
      | Benoit    | Trader | Locked     | Silver      |
      | Claude    | Trader | Normal     | Bronze      |
      | David     | Trader | Normal     | Iron        |
      | Edward    | Trader | Normal     | Diamond     |
      | Frank     | Trader | Locked     | Diamond     |
      #| Antoine    |  Manager|     Normal |   -         |


  Scenario Outline: Trader with legitimate status and an adequate credit level create and post an advertisement (Normal Flow)
    Given the Trader with username "Andrew" is logged in
    When "Andrew" posts the advertisement "<advertisementID>" with Bitcoin <coinNumber> and desired price per bit <pricePerBit> with currency "<currency>"
    Then the ID of the advertisement with username "Andrew" should be "<advertisementID>"
    Then the number of advertisements in the system shall be "3"

    Examples:
      | advertisementID | coinNumber | pricePerBit | currency |
      | 1               | 0.02       | 200000.0      | RMB      |
      | 2               | 0.4        | 30000.0       | USD      |
      | 3               | 0.013      | 30000.0       | USD      |


  Scenario Outline: Trader with legitimate status and an adequate credit level create and post an advertisement with bad coin number or price (Error Flow)
    Given the Trader with username "Edward" is logged in
    When "Andrew" posts the advertisement "<advertisementID>" with Bitcoin <coinNumber> and desired price per bit <pricePerBit> with currency "<currency>"
    Then an error message with content "<error>" shall be raised
    Then the number of advertisements in the system shall be "0"

    Examples:
      | advertisementID | coinNumber | pricePerBit | currency | error                                                                     |
      | 4 							| 0.0          | 200000.0      | RMB      | Coin number must be larger then zero                                      |
      | 5 							| -1.0         | 30000.0      | USD      | Coin number must be larger then zero                                      |
      | 6 							| 0.2        | -50000.0      | CAD      | Price of the bitcoin should be positive and close to current system price |


  Scenario Outline: Trader with legitimate status and an adequate credit level create and post an advertisement with unverified currency (Error Flow)
    Given the Trader with username "Andrew" is logged in
    When "Andrew" posts the advertisement "<advertisementID>" with Bitcoin <coinNumber> and desired price per bit <pricePerBit> with currency "<currency>"
    Then an error message with content "<error>" shall be raised
    Then the number of advertisements in the system shall be "0"

    Examples:
      | advertisementID | coinNumber | pricePerBit | currency | error                     |
      | 7 							| 0.02       | 20000000.0    | ABCD     | Unverified currency type! |


  Scenario Outline: Trader without legitimate status or without an adequate credit level create and post an advertisement (Error Flow)
    Given the Trader with username "<username>" is logged in
    When "Andrew" posts the advertisement "<advertisementID>" with Bitcoin <coinNumber> and desired price per bit <pricePerBit> with currency "<currency>"
    Then an error message with content "<error>" shall be raised
    Then the number of advertisements in the system shall be "0"

    Examples:
      | advertisementID | username | coinNumber | pricePerBit | currency | error                                                                |
      | 8 							| Frank    | 0.04       | 200000.0      | RMB      | User with locked account status can not post advertisement!          |
      | 9 							| David    | 0.2        | 30000.0       | USD      | User with credit level lower then BRONZE can not post advertisement! |
      