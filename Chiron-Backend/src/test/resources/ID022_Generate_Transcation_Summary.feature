Feature: Generate Transcation Summary
  As a normal user, I wish to see my transcation summary.

# to fit the model, credit level are converted to feedback score
# diamond = 90 - 100
# gold = 70-90
# silver = 50-70
# bronze = 30-50
# iron <30. if in iron level, then the user can not post any advertisement

  Background:
    Given BitCoin Trading system is running
    Given the follow transcations exist in system:

      | transc_id | amount   | user_id1 |	user_id2	|
      | 001    | 100 | Andrew	|	Benoit	|
      | 002    | 200 | Andrew	|	Benoit	|
      | 003    | 300 | Andrew	|	Andrew	|
      | 004    | 400 | Andrew	|	Andrew	|
      | 005    | 500 | Benoit	|	Andrew	|
      | 006    | 600 | Benoit	|	Andrew	|



  Scenario Outline: User view their total number of transcations and the total amount.  (Normal Flow)
    Given the Trader with username "Andrew" is logged in
    When "Andrew" requests to view the transcation report of "Andrew"
    Then the total number of transcations is <number>
    Then the total amount of transcations is <amount>

    Examples:
      | number | amount | 
      | 6      | 2100   | 
      
  Scenario Outline: User view their total number of transcations and the total amount.  (Alternate Flow)
    Given the Trader with username "Benoit" is logged in
    When "Benoit" requests to view the transcation report of "Benoit"
    Then the total number of transcations is <number>
    Then the total amount of transcations is <amount>

    Examples:
      | number | amount | 
      | 6      | 2100   | 
	
	Scenario Outline: User view not their total number of transcations and the total amount.  (Error Flow)
    Given the Trader with username "Frank" is logged in
    When "Frank" requests to view the transcation report of "Benoit"
   Then The systems returns an error message "<error>" showing that viewing others transcation report permission denied
   

    Examples:
      | error | 
      | permission denied     |


