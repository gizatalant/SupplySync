@regression
Feature: As an admin I should be able to edit "Masters" field

  Scenario: Admin should be able to edit "Masters" field
  Given admin locates Masters field
  When locates the section with the three dots and clicks on them
  When from the dropdown menu clicks on the Edit button
  Then makes some changes to the required fields
  And clicks on the Save button
  Then admin verifies that the changes were successfully saved

  Scenario: Editing a location in the Masters field should allow number and symbols
    Given admin locates Masters field
    When locates the section with the three dots and clicks on them
    When from the dropdown menu clicks on the Edit button
    Then makes some changes to the location field with numbers and symbols
    And clicks on the Save button
    Then numbers and symbols should be allowed

  Scenario: Masters field should be edited to uppercase or lowercase
    Given admin locates Masters field
    When locates the section with the three dots and clicks on them
    When from the dropdown menu clicks on the Edit button
    Then makes some changes to the required fields in uppercase and lowercase
    And clicks on the Save button
    Then uppercase and lowercase should be allowed


    Scenario: Admin should be able to block masters
      Given admin locates Masters field
      When locates the section with the three dots
      Then from the dropdown menu clicks on the Block button
      And verifies the master is locked

  Scenario: Admin should be able to unlock masters
    Given admin locates Masters field
    When locates the section with the three dots and clicks
    Then from the dropdown menu clicks on the Unlock button
    And verifies the master is unlocked













