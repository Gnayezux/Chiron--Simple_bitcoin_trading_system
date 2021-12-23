Feature: Update user feedback score
  As a system manager, I want to update a user's feedback score, so that I can provide reference to future dealers.

  Scenario Outline: Update a seller's feedback score. (Normal Flow)

    Given a trade is created with <trade_id>
    And the trade status of the trade <trade_id> is "done"
    When updates seller's <user_id> feedback score to <score>
    Then seller <user_id> now has feedback score <score>

    Examples:
      | trade_id | user_id   | score|
      | 001      | 011 |   10    |
      | 002      | 012 |      2   |
      | 003      | 013 |     5    |
  Scenario Outline: Update a buyer's feedback score. (Alternate Flow)

    Given a trade is created with <trade_id>
    And the trade status of the trade <trade_id> is "done"
    When updates buyer's <user_id> feedback score to <score>
    Then buyer <user_id> now has feedback score <score>

    Examples:
      | trade_id | user_id   | score|
      | 001      | 011 |   10    |
      | 002      | 012 |      2   |
      | 003      | 013 |     5    |
  Scenario Outline: Update a user's feedback score while the trade is not done. (Error Flow)

    Given a trade is created with <trade_id>
    And the trade status of the trade <trade_id> is "in progress"
    When updates seller's <user_id> feedback score to <score>
    Then the system indicates that the trade is not completed yet

    Examples:
      | trade_id | user_id   | score|
      | 001      | 011 |   10    |
      | 002      | 012 |      2   |
      | 003      | 013 |     5    |