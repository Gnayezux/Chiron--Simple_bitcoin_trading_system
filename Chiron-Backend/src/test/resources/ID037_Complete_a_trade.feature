Feature: Complete a trade
  As a user, I want to complete a trade, so that I can receive my bitcoin or money.

  Scenario Outline: Seller confirms that the trade is complete with confirmation from the buyer. (Normal Flow)

    Given a trade is created with <trade_id> with buyer "<buyer_name>"
    And the trade status of the trade <trade_id> is "in process"
    When seller requests to completes  trade <trade_id>
    And buyer confirms the trade <trade_id> can be completed
    Then trade <trade_id> now has trade status "<trade_status>"
    And the end time of the trade <trade_id> is <end_time>

    Examples:
      |buyer_name    | trade_id   | end_time     | trade_statu   |
      |Andrew        | 001        | 12/01/2020   | done          |
      |Frank         | 002        | 12/01/2020   | done          |
      |Amy           | 003        | 12/01/2020   | done          |

  Scenario Outline: Buyer confirms that the trade is complete with confirmation from the seller. (Alternate Flow)

    Given a trade is created with <trade_id> with seller "<seller_name>"
    And the trade status of the trade <trade_id> is "in process"
    When seller requests to completes  trade <trade_id>
    And seller confirms the trade <trade_id> can be completed
    Then trade <trade_id> now has trade status "<trade_status>"
    And the end time of the trade <trade_id> is <end_time>

    Examples:
      |seller_name   | trade_id   | end_time   | trade_status  |
      |Andrew        | 001        | 12/01/2020 | done          |
      |Frank         | 002        | 12/01/2020 | done          |
      |Amy           | 003        | 12/01/2020 | done          |

  Scenario Outline: Buyer confirms that the trade is complete without confirmation from the seller. (Error Flow)

    Given a trade is created with <trade_id> with seller "<seller_name>"
    And the trade status of the trade <trade_id> is "in process"
    When buyer requests to completes  trade <trade_id>
    And seller refuses the trade <trade_id> can be completed
    Then the system refuses the buyer from completing a trade
    And the system indicates that trade <trade_id> now has trade status "<trade_status>"
    Examples:
      | trade_id   | end_time    | trade_status  |
      | 001        | 12/01/2020  | in process    |
      | 002        | 12/01/2020  | in process    |
      | 003        | 12/01/2020  | in process    |