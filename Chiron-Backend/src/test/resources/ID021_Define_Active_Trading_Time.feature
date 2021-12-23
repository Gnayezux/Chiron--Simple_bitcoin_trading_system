Feature: Define active trading time
  As a project manager, I want to define an active trading time for the system.

  Scenario Outline: Manager defines an active trading time (Normal Flow)

    Given BitCoin Trading system is running
    When Manager "<user_id>" is logged-in
    And A time period "<time>" is defined by "<user_id>"
    Then The systems trading time is now "<time>"
    #time format: 03:00PM5, where 03:00PM is the start time and 5 id the duration in hours 
    Examples:
      | user_id   | time			|
      | manager   | 03:00PM5 	|	
      | manager   | 01:00PM7	|	
      | manager   | 09:00AM3 	|	



  Scenario Outline: User defines an active trading time (Error Flow)

    Given BitCoin Trading system is running
    When Ordinary user "<user_id>" is logged-in
    And A time period "<time>" is defined by "<user_id>"
    Then The systems returns an error message "<error>" showing permission denied
    #time format: 03:00PM5, where 03:00PM is the start time and 5 id the duration in hours 
    Examples:
      | user_id   | time			| error 						|
      | user   		| 03:00PM5 	|	permission denied |
      | user   		| 01:00PM7	|	permission denied |
      | user   		| 09:00AM3 	|	permission denied |