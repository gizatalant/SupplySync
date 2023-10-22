@regression
Feature: Edit Company

  Scenario: As an admin i should be able to edit created companies

    Given the admin navigates to Supply Sync login page
    When the admin enters email, password and clicks login button
    When admin navigates to edit companies page
    When admin clicks the edit button of company to edit
    Then admin performs editing actions, saves and verifies the changes
