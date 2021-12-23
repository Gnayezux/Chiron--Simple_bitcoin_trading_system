Feature: Display bitcoin daily earning
  As a user, I wish to display daily earning.

  Background:
    Given BitCoin Trading system is running
    Given the follow user account exist in system:
      | user_name | role   | userstatus | creditlevel |
      | Andrew    | Trader | Normal     | Gold        |
      | Benoit    | Trader | Locked     | Silver      |
      | Claude    | Trader | Normal     | Bronze      |
      | David     | Trader | Normal     | Iron        |
      | Edward    | Trader | Normal     | Diamond     |
      | Frank     | Trader | Locked     | Diamond     |

  Scenario Outline: Successfully display bitcoin daily earning.
    Given the User with username "<user_id>" is logged in
		When "Andrew" display daily earning.
    Then the  bitcoin daily earning shall be displayed.
       
  Examples:
      | user_id  |
      | Andrew   |
				