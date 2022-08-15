Feature: Check Search Functionality
    
  
    @Regresion
  Scenario: verify the  functionality of patient search for invalid patientname
    Given user is on the login page
    When user enters credentials
    When user clicks on Login
    Then user is on homepage
    When user clicks on Patients
    When user enters invalid patient name 
    Then Error message should be displayed accordingly
       
     @Regresion
  Scenario: verify the  functionality of patient search for valid patientname
    Given user is on the login page
    When user enters credentials
    When user clicks on Login
    Then user is on homepage
    When user clicks on Patients
    When user enters valid patient name
    Then result should match with search criteria