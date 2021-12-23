Feature: Cancel a trade
  As a user, I want to cancel a trade, so that I can stop the trade.

  Scenario Outline: Seller cancels the trade with confirmation from the buyer. (Normal Flow)

    Given a trade is created with <trade_id> with buyer "<buyer_name>"
    And the trade status of the trade <trade_id> is "in process"
    When seller requests to cancel the trade <trade_id>
    And buyer confirms the trade <trade_id> can be cancelled
    Then trade <trade_id> now has trade status "<trade_status>"
    And the end time of the trade <trade_id> is <end_time>

    Examples:
      |buyer_name    | trade_id   | end_time     | trade_status      |
      |Andrew        | 001        | 12/01/2020   | canceled          |
      |Frank         | 002        | 12/01/2020   | canceled          |
      |Amy           | 003        | 12/01/2020   | canceled          |


  Scenario Outline: Buyer cancels a trade with confirmation from the seller. (Alternate Flow)

    Given a trade is created with <trade_id> with seller "<seller_name>"
    And the trade status of the trade <trade_id> is "in process"
    When buyer requests to cancel  trade <trade_id>
    And seller confirms the trade <trade_id> can be cancelled
    Then trade <trade_id> now has trade status "<trade_status>"
    And the end time of the trade <trade_id> is <end_time>
    Examples:
      |seller_name   | trade_id   | end_time   | trade_status     |
      |Andrew        | 001        | 12/01/2020 | canceled         |
      |Frank         | 002        | 12/01/2020 | canceled         |
      |Amy           | 003        | 12/01/2020 | canceled         |

  Scenario Outline: Buyer cancels the trade without confirmation from the seller. (Error Flow)

    Given a trade is created with <trade_id> with seller "<seller_name>"
    And the trade status of the trade <trade_id> is "in process"
    When buyer requests to cancel  trade <trade_id>
    And seller refuses the trade <trade_id> can be cancelled
    Then the system rejects the buyer from cancelling a trade
    And the system indicates that trade <trade_id> now has trade status "<trade_status>"
    Examples: 
      |seller_name   | trade_id   | end_time   | trade_status       |
      |Andrew        | 001        | 12/01/2020 | in process         |
      |Frank         | 002        | 12/01/2020 | in process         |
      |Amy           | 003        | 12/01/2020 | in process         |