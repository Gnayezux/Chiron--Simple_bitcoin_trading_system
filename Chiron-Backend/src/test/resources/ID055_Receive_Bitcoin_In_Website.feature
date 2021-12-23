Feature: Receive bitcoin in website
  As a trader, I wish to deposit bitcoins in my wallat of the website.

  Background:
    Given The server is running
    Given The following users exist:
      | id     | name |
      | 823732 | Mark |
    And All users' status is normal

  Scenario Outline: Valid wall placement
    Given "<trader>" has <p_amount> bitcoin in the wallet
    When "<trader>" receive <amount> bitcoin
    Then "<trader>" has <new_amount> bitcoin in the wallet

    Examples:
      | trader | p_amount | amount | new_amount |
      | Mark   | 0.5      | 0.1    | 0.6        |
     # | Mark   | 0        | 1.1    | 1.1        |
       
				