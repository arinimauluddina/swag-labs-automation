Feature: Logout Feature

  Scenario: User is able to logout
    Given user do login
    When user click menu bar
    And user click the logout button
    Then user should be logged out and redirected to the login page
