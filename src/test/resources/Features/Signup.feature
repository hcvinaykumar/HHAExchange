Feature: Check Signup Functionality

@Regresion
Scenario: verify the  functionality of Sign_Up_Here button
    Given user is on the login page
    When Verify Sign_Up_Here is visible
    When user clicks on Sign_Up_Here button
    Then User should land on Sign_Up form
    
@Regresion
Scenario: validation of input fields in Sign_Up form
    Given user is on the login page
    When user clicks on Sign_Up_Here button
    When user enters Email Address
    When user enters different Password on Confirm Password field
    When user clicks on Signup button
    Then appropriate error message should appear
    
@Regresion
Scenario: verify the  functionality of Email button for verification
    Given user is on the login page
    When user clicks on Sign_Up_Here button
    When user fills Email Address Password Confirm Password Fields
    When user clicks on Signup button
    Then the page should contain Email button for verification
    
     @Regresion
Scenario: verify the  functionality of Registration form       
    Given user is on the login page
    When user clicks on Sign_Up_Here button
    When user fills Email Address Password Confirm Password Fields
    When user clicks on Signup button
    When user clicks on Email button for verification
    When user selects Perfom EVV option
    When user enters verification code and click submit code
    Then user should land on Registration form 
      
   