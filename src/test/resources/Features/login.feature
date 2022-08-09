Feature: Check Login Functionality

    

  @Regresion
  Scenario: Check login credentials
    Given user is on the login page
    # When user reset app
    When user enters credentials
    When user clicks on Login
    Then user is on homepage
    
    
