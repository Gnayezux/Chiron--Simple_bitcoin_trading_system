Feature: Create customer service request
  As a normal trader, I would like to create a service request to the web management system, indicating the recent trouble I encountered and
  expecting the system managers could provide solution.

  Background:
    Given BitCoin Trading system is running
    Given a manager with userId "Manager1" exist in system
    Given the follow user account exist in system:

      | user_name | role    | userstatus | creditlevel |
      | Andrew    | Trader  | Normal     | Gold        |
      | Benoit    | Trader  | Locked     | Silver      |
      | Claude    | Trader  | Normal     | Bronze      |
      | David     | Trader  | Normal     | Iron        |
      | Antoine   | Manager | Normal     | -           |


  Scenario Outline: Trader with legitimate status send to the system with service request (Normal Flow)
    Given the Trader with username "<user_name>" is logged in
    When "<user_name>" posts the request with "<content>" in the system
    Then the ID of the request should be "<requestID>"

    Examples:
      | user_name | content                            | requestID |
      | Andrew    | May I change my password           | 1         |
      | Claude    | How can I get refund on last trade | 2         |
      | David     | I met a scam                       | 3         |


  Scenario Outline: Trader without legitimate status send to the system with service request (error Flow)
    Given the Trader with username "<user_name>" is logged in
    When "<user_name>" posts the request with "<content>" in the system
    Then an error message with content "<error>" shall be raised
    Then the number of new requests in the system shall be "0"

    Examples:
      | user_name | content                  | error                                         |
      | Benoit    | May I change my password | A locked account can not send service request |


  Scenario Outline: Trader with legitimate status send a bad request with no content (error Flow)
    Given the Trader with username "<user_name>" is logged in
    When "<user_name>" posts the request with "<content>" in the system
    Then an error message with content "<error>" shall be raised
    Then the number of new requests in the system shall be "0"

    Examples:
      | user_name | content | error                                       |
      | Andrew    |         | The content of the request can not be NULL! |
      
      
# this scenario is deprecated.    
#  Scenario Outline: A manager want to send a service request (error Flow)
#    Given the Manager with username "<user_name>" is logged in
#    When "<user_name>" posts the request with content "<content>" 
#    Then an error message with content "<error>" shall be raised
#    Then the number of requests in the system shall be "0"
#
#    Examples: 
#      |  user_name  | content                              |     error                                             |
#      |  Antoine    | " I met a scam "                     |     A manager cannot send a service request           |


      
      