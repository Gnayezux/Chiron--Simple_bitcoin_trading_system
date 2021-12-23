Feature: Disable all buying advertisements
  As a user, I wish to disable all my buying advertisements
  So that I wont buy bitcoins to anyone.


  Background:
    Given BitCoin Trading system is running
    And the following users are registered:
      | Andrew | andrew@id.com |


  Scenario Outline: The creater disables all buying advertisements in the system (Normal Flow)
    Given the Trader with username "Andrew" is logged in
    And the follow advertisement exist in system:
     	| advertisementID | type    | advertisementStatusbefore | advertisementStatusAfter | Creater
      | 1               | buying  | activated                 | disabled                 | andrew@id.com
      | 2               | buying  | activated                 | disabled                 | bb@id.com
      | 3               | selling | activated                 | activated                | andrew@id.com
      | 4               | selling | activated                 | activated                | andrew@id.com

    
    When "Andrew" choose to disable all buying advertisements
    Then the status of the advertisement "<advertisementID>" should be "<advertisementStatusAfter>"

     
  Scenario Outline: The creater disables all buying advertisements when there is no activate buying advertisement in the system(Error Flow)
    Given the Trader with username "Andrew" is logged in
    When "Andrew" choose to disable all buying advertisements
    Then an error message should be sent to the user indicating the advertisement status error

    Examples:
      | advertisementID | type    | advertisementStatusbefore | advertisementStatusAfter | Creater
      | 1               | buying  | disabled                  | disabled                 | andrew@id.com
      | 2               | buying  | disabled                  | disabled                 | bb@id.com
      | 3               | selling | disabled                  | activated                | andrew@id.com
      | 4               | selling | disabled                  | activated                | andrew@id.com
       

