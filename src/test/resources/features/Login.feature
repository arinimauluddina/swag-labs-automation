Feature: Login Feature

  Scenario Outline: Successful Login
    Given user on the login page
    When user input <username> <password> as credentials
    Then user should be redirected to the main page
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Login with Invalid user
    Given user on the login page
    When user input <username> <password> as credentials
    Then Error Message should be displayed
    Examples:
      | username        | password     |
      | locked_out_user | secret_sauce |