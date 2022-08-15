Feature: Check Login Functionality

    @Regresion
  Scenario: Check login functinality with empty credentials
    Given user is on the login page
    When user clicks on Login 
    Then Appropriate Error message should come for the required fields

  @Regresion
  Scenario: Check login functinality with valid credentials
    Given user is on the login page   
    When user enters credentials
    When user clicks on Login
    Then user is on homepage
    
     @Regresion
  Scenario: Check login functinality with invalid credentials
    Given user is on the login page   
    When user enters invalid credentials
    When user clicks on Login
    Then appropriate error must appear