Feature: Provide feedback for user's trade
  As a user, I want to comment on the trade I participated as a buyer or a seller, so that I can provide reference to future dealers.

  Scenario Outline: Seller comments on the completed trade with buyer. (Normal Flow)

    Given a trade is created with <trade_id>
    When the trade status of the trade <trade_id> is "done"
    When seller <suser_id> requests to comment on the trade <trade_id> with content <feedback>
    Then trade <trade_id> now has seller comment <feedback> for buyer <buser_id>

    Examples:
      | trade_id | suser_id   | feedback| buser_id |
      | 001      | 011 |    good     |   001   |
      | 002      | 012 |      bad   | 002     |
      | 003      | 013 |     soso    | 003     |
  Scenario Outline: Buyer comments on the completed trade with seller. (Alternate Flow)

    Given a trade is created with <trade_id>
    When the trade status of the trade <trade_id> is "done"
    When buyer <buser_id> requests to comment on the trade <trade_id> with content <feedback>
    Then trade <trade_id> now has seller comment <feedback> for buyer <suser_id>

    Examples:
      | trade_id | buser_id   | feedback| suser_id |
      | 001      | 011 |    good     |   001   |
      | 002      | 012 |      bad   | 002     |
      | 003      | 013 |     soso    | 003     |

  Scenario Outline: Seller comments on the on-going trade with buyer. (Error Flow)

    Given a trade is created with <trade_id>
    When the trade status of the trade <trade_id> is "in process"
    When seller <suser_id> requests to comment on the trade <trade_id> with content <feedback>
    Then the system indicates that the trade is not completed yet

    Examples:
      | trade_id | suser_id   | feedback|
      | 001      | 011 |    good     |
      | 002      | 012 |      bad   |
      | 003      | 013 |     soso    |