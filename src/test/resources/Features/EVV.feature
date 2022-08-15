Feature: Check Clockin and Clockout EVV Functionality

  @Regresion
  Scenario: verify the  functionality of clock in and out procedure
    Given user is on the login page
    When user enters credentials
    When user clicks on Login
    Then user is on homepage
    When user Click on the patient details
    When user Click on the Clock In button
    And Click on continue
    When User Do the signature and Click on Submit
    When User Do the patient signature and Click on Submit
    When User Do the caregiver signature and Click on Submit
    When User Record patient voice and click on stop recording
    And Click on done
    When User Fill the mandatory fields as well as value
    Then click on Clock out