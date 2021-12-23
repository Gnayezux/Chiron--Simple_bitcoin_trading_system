Feature: Query completed features
  As a website manager, I want to get all completed trades in our platform, 
  so that I can check trades' information.


  Scenario Outline: Manager successfully query all completed trades (Normal Flow)
	Given I am a website manager
    And the following trades exist:
      |user_name     | trade_id   | end_time     | trade_status        |
      |Andrew        | 001        | 12/01/2020   | done                |
      |Frank         | 002        | 12/01/2020   | in process          |
      |Amy           | 003        | 12/01/2020   | canceled            |
    When manager requests all completed trades.
    Then the following trades should be displayed 
      |user_name     | trade_id   | end_time     | trade_status        |
      |Andrew        | 001        | 12/01/2020   | done                |
  Scenario Outline: Manager failed to query all completed trades. (Error Flow)
		Given I am a website manager
    And the following trades exist:
      And the following trades exist:
      |user_name    | trade_id    | end_time      | trade_status       |
      |Andrew        | 001        | 12/01/2020   | in process          |
      |Frank         | 002        | 12/01/2020   | in process          |
      |Amy           | 003        | 12/01/2020   | canceled            |
    When manager requests all completed trades
   
    Then an error message should be displayed for failing to query all completed trades