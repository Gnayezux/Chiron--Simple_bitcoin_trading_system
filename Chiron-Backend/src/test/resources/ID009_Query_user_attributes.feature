Feature: Query user attributes

  User Story:
  As a website manager
  I want to be able to receive users' attributes
  With user's account ID and Driver License ID
  So that I can check his account information

  Background:
    Given I am a website manager
    And the following users exist:
      | user_full_name | account_id | phone number | driver license ID |
      | Archie Andrews | AA001      | 13709088888  | 1234211241        |

  Scenario: I successfully get a user's attribute with his account ID(Normal Flow)
    When I request to get a user's attribute
    And I enter the following ID:
      | account_id |
      | AA001      |
    Then the following information of this user is generated:
      | user_full_name | account_id | phone number | driver license ID |
      | Archie Andrews | AA001      | 13709088888  | 1234211241        |

  Scenario:  I successfully get a user's attributes with his driver license ID (alternate Flow)
    When I request to get a user's attribute
    And I enter the following driver license ID:
      | driver license ID |
      | 1234211241        |
    Then the following information of this user is generated:
      | user_full_name | account_id | phone number | driver license ID |
      | Archie Andrews | AA001      | 13709088888  | 1234211241        |

  Scenario: I don't get a user's attributes when I input an invalid account ID (Error Flow)
    When I request to get a user's attribute
    And I enter invalid account ID
    Then the system warns me that I have entered an invalid account ID
      