Feature: Activate all selling advertisement
  As a user, I wish to activate all my selling advertisement
  So that I can sell bitcoins to anyone.


  Background:
    Given BitCoin Trading system is running
    And the following users are registered:
      | Andrew | andrew@id.com |


  Scenario Outline: The creater activates all selling advertisements in the system (Normal Flow)
    Given the Trader with username "Andrew" is logged in
    And the follow advertisement exist in system:
    | advertisementID | coinNumber | pricePerBit | currency | advertisementStatus | Creator
      | 1               | 0.02       | 200000      | RMB      | disabled            | andrew@id.com
      | 2               | 0.4        | 30000       | USD      | disabled            | bb@id.com
      | 3               | 0.013      | 30000       | USD      | disabled            | andrew@id.com
      | 4               | 0.03       | 200000      | RMB      | activated           | andrew@id.com
    When "Andrew" choose to activate all selling advertisements
    Then the status of the advertisement "<advertisementID>" should be "<advertisementStatusAfter>"

    Examples:
      | advertisementID | type    | advertisementStatusbefore | advertisementStatusAfter | Creater
      | 1               | selling | disabled                  | activated                | andrew@id.com
      | 2               | selling | disabled                  | activated                | bb@id.com
      | 3               | buying  | disabled                  | activated                | andrew@id.com
      | 4               | buying  | disabled                  | activated                | andrew@id.com


  Scenario Outline: The creater activates all selling advertisements when there is no disabled selling advertisement in the system(Error Flow)
    Given the Trader with username "Andrew" is logged in
    When "Andrew" choose to activate all selling advertisements
    Then an error message should be sent to the user indicating the advertisement status error

    Examples:
      | advertisementID | type    | advertisementStatusbefore | advertisementStatusAfter | Creater
      | 1               | selling | activated                 | activated                | andrew@id.com
      | 2               | selling | activated                 | activated                | bb@id.com
      | 3               | buying  | activated                 | activated                | andrew@id.com
      | 4               | buying  | activated                 | activated                | andrew@id.com
       
