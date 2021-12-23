Feature: Disable  an advertisement
  As a normal user, I wish to disable an active advertisement I created, so that other users can know the advertisement is no longer activated.


  Background:
    Given BitCoin Trading system is running
    And the following users are registered:
      | Andrew | andrew@id.com |

    Given the follow advertisement exist in system:
      | advertisementID | coinNumber | pricePerBit | currency | advertisementStatus | Creater
      | 1               | 0.02       | 200000      | RMB      | activated           | andrew@id.com
      | 2               | 0.4        | 30000       | USD      | activated           | bb@id.com
      | 3               | 0.013      | 30000       | USD      | disabled            | andrew@id.com
      | 4               | 0.03       | 200000      | RMB      | disabled            | andrew@id.com


  Scenario Outline: The creater disables an activated advertisement in the system (Normal Flow)
    Given the Trader with username "Andrew" is logged in
    When "Andrew" choose to disable "<advertisementID>"
    Then the status of the advertisement "<advertisementID>" should be "<advertisementStatus>"


    Examples:
      | advertisementID | coinNumber | pricePerBit | currency | advertisementStatus | Creater
      | 1               | 0.02       | 200000      | RMB      | disabled            | andrew@id.com


  Scenario Outline: The creater disables an disabled advertisement in the system (Error Flow)
    Given the Trader with username "Andrew" is logged in
    When "Andrew" choose to disable "<advertisementID>"
    Then an error message should be sent to the user indicating the advertisement status error

    Examples:
      | advertisementID | coinNumber | pricePerBit | currency | advertisementStatus | Creater
      | 4               | 0.03       | 200000      | RMB      | disabled            | andrew@id.com

  Scenario Outline: The creater disables an advertisement created by another author in the system (Error Flow)
    Given the Trader with username "Andrew" is logged in
    When "Andrew" choose to disable "<advertisementID>"
    Then an error message should be sent to the user indicating the advertisement authorization error

    Examples:
      | advertisementID | coinNumber | pricePerBit | currency | advertisementStatus | Creater
      | 2               | 0.4        | 30000       | USD      | activated           | bb@id.com
       

