Feature: Disable  all advertisement
  As a normal user, I wish to disable all active advertisements I created, so that other users can know the advertisements are no longer activated.


  Background:
    Given BitCoin Trading system is running
    And the following users are registered:
      | Andrew | andrew@id.com |

    Given the follow advertisement exist in system:
      | advertisementID | coinNumber | pricePerBit | currency | advertisementStatus | Creater
      | 1               | 0.02       | 200000      | RMB      | activated           | andrew@id.com
      | 2               | 0.4        | 30000       | USD      | activated           | bb@id.com
      | 3               | 0.013      | 30000       | USD      | activated           | andrew@id.com
      | 4               | 0.03       | 200000      | RMB      | disabled            | andrew@id.com


  Scenario Outline: The creater disables all activated advertisement in the system (Normal Flow)
    Given the Trader with username "Andrew" is logged in
    When "Andrew" choose to disable all activated advertisements
    Then the status of the advertisement "<advertisementID>" should be "<advertisementStatus>"


    Examples:
      | advertisementID | coinNumber | pricePerBit | currency | advertisementStatus | Creater
      | 1               | 0.02       | 200000      | RMB      | disabled            | andrew@id.com
      | 2               | 0.4        | 30000       | USD      | activated           | bb@id.com
      | 3               | 0.013      | 30000       | USD      | disabled            | andrew@id.com
      | 4               | 0.03       | 200000      | RMB      | disabled            | andrew@id.com


  Scenario Outline: The creater disables all activated advertisement when there is no activate advertisement in the system(Error Flow)
    Given the Trader with username "Andrew" is logged in
    When "Andrew" choose to disable all activated advertisements
    And  "Andrew" choose to disable all activated advertisements
    Then an error message should be sent to the user indicating the advertisement status error

    Examples:
      | advertisementID | coinNumber | pricePerBit | currency | advertisementStatus | Creater
      | 1               | 0.02       | 200000      | RMB      | disabled            | andrew@id.com
      | 2               | 0.4        | 30000       | USD      | activated           | bb@id.com
      | 3               | 0.013      | 30000       | USD      | disabled            | andrew@id.com
      | 4               | 0.03       | 200000      | RMB      | disabled            | andrew@id.com
       

