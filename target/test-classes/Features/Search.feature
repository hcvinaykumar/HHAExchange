Feature: Check Search Functionality

@Regresion
  Scenario: verify the  functionality of patient search
    Given user is on the login page
    #When user reset app
    When user enters credentials
    When user clicks on Login
    Then user is on homepage
    When user clicks on Patients
    When user enters patient name which is not in the list
    Then the page should contain patient is not in list
    When user enters proper patient name
    Then the result should contains patient name
    
    