Feature: Send bitcoins from website
  As a trader, I wish to send bitcoins to my private wallet from the website.

  Background:
    Given The server is running
    Given The following users exists in this system:
      | id     | name |
      | 823732 | Mark |
    And All users' status is normal

  Scenario Outline: Valid wall placement
    Given "<trader>" has <p_amount> bitcoin in the wallet
    When "<trader>" send <amount> bitcoin to "<address>"
    Then "<trader>" has <new_amount> bitcoin in the wallet

    Examples:
      | trader | p_amount | amount | new_amount | address                   |
      | Mark   | 0.5      | 0.1    | 0.4        | efuwh234ubv234U3242XIOC   |
      | Mark   | 1        | 0.1    | 0.9        | 43u5g345u34g43j35k4b2XIOC |


  Scenario Outline: Valid wall placement
    Given "<trader>" has <p_amount> bitcoin in the wallet
    When "<trader>" send <amount> bitcoin to "<address>"
    Then an error message with content "<error>" shall be raised
    Then "<trader>" has <new_amount> bitcoin in the wallet

    Examples:
      | trader | p_amount | amount | new_amount | error                                 | address                   |
     | Mark   | 0.5      | 1      | 0.5        | Do have enough bitcoin in your wallet | efuwh234ubv234U3242XIOC   |
      | Mark   | 0.9      | -1.0     | 0.9        | The amount should be bigger than 0    | 43u5g345u34g43j35k4b2XIOC |
				