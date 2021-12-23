Feature: Create an advertisement
  As a user, I wish to disable all my selling advertisement
  So that I wont sell bitcoins to anyone.


  Background:
    Given BitCoin Trading system is running
    And the following users are registered:
      | Andrew | andrew@id.com |


  Scenario Outline: The creater disables all selling advertisements in the system (Normal Flow)
    Given the Trader with username "Andrew" is logged in
    And the follow advertisement exist in system:
     | advertisementID | type    | advertisementStatusbefore | advertisementStatusAfter | Creater
      | 1               | selling | activated                 | disabled                 | andrew@id.com
      | 2               | selling | activated                 | disabled                 | bb@id.com
      | 3               | buying  | activated                 | activated                | andrew@id.com
      | 4               | buying  | activated                 | activated                | andrew@id.com

    
    When "Andrew" choose to disable all selling advertisements
    Then the status of the advertisement "<advertisementID>" should be "<advertisementStatusAfter>"

  
     
  Scenario Outline: The creater disables all selling advertisements when there is no activate selling advertisement in the system(Error Flow)
    Given the Trader with username "Andrew" is logged in
    When "Andrew" choose to disable all selling advertisements
    Then an error message should be sent to the user indicating the advertisement status error

    Examples:
      | advertisementID | type    | advertisementStatusbefore | advertisementStatusAfter | Creater
      | 1               | selling | disabled                  | disabled                 | andrew@id.com
      | 2               | selling | disabled                  | disabled                 | bb@id.com
      | 3               | buying  | activated                 | activated                | andrew@id.com
      | 4               | buying  | activated                 | activated                | andrew@id.com
       

