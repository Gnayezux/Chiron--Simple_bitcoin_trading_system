Feature: Display bitcoin advertisement
  As a user, I wish to display advertisement.

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

  Scenario Outline: Successfully display bitcoin advertisement.
    Given the User with username "<user_id>" is logged in
		When "Andrew" display advertisement.
    Then the  bitcoin advertisement shall be displayed.
       
  Examples:
      | user_id  |
      | Andrew   |