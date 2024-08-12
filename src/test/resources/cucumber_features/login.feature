Feature: Login application

  Scenario Outline: login application with valid Inputdata and Invalid Inputdata
    Given user on the login page
    When user enter "<username>" and "<password>"
    Then click submit button
    And user the login success message

    Examples:  
      | username    | password     |
      | student     | Password123  |  
      | student     | Password@123 |
      | student@123 | Password     |
      | sudent@123  | Password@123 |
