Feature: Add and Delete User Flow in OrangeHRM

  Scenario: Add a new user and delete it
    Given Admin logs in
    And navigates to Admin section
    When the user counts current records
    And adds a new user with username "MuhammadAtef.testuser"
    Then the record count should increase by 1
    When the user searches for "MuhammadAtef.testuser"
    And deletes the user "john.testuser"
    Then the record count should decrease by 1