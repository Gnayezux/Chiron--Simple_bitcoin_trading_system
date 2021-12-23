Feature: Query on-going features
  As a website manager, I want to get all on-going trades in our platform, 
  so that I can check trades' information.


  Scenario Outline: Manager successfully query all on-going trades (Normal Flow)
    Given I am a website manager
    And the following trades exist:
      |user_name     | trade_id   | end_time     | trade_status        |
      |Andrew        | 001        | 12/01/2020   | done                |
      |Frank         | 002        | 12/01/2020   | in process          |
      |Amy           | 003        | 12/01/2020   | canceled            |
    When manager requests all on-going trades
    Then the following trades should be displayed
      |user_name     | trade_id   | end_time     | trade_status        |
      |Frank         | 002        | 12/01/2020   | in process          |
      

  Scenario Outline: Manager failed to query all on-going trades (Error Flow)
	Given I am a website manager
    And the following trades exist:
      |user_name     | trade_id   | end_time     | trade_status        |
      |Andrew        | 001        | 12/01/2020   | done                |
      |Frank         | 002        | 12/01/2020   | done                |
      |Amy           | 003        | 12/01/2020   | canceled            |
    When manager requests all on-going trades
    Then an error message should be displayed for failing to query all on-going trades