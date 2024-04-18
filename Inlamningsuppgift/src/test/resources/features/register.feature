Feature: Register

  Scenario Outline: I want to register for an account

    Given I have used "<browser>"
    Given I am on the registration page
    Given I have entered date of birth "13/05/1979"
    Given I have entered first name "Marina"
    Given I have entered "<lastName>"
    Given I have entered and confirmed my "<email>"
    Given I have chosen a password "123456"
    Given I have confirmed my "<password>"
    Given I have <status> and agreed to the terms and conditions
    Given I have marked the checkbox that i am over 18
    Given I have marked the checkbox for code of ethics and conduct
    When I click on confirm and join
    Then I should see that <message>

    Examples:

      | lastName | email  | password | status      | browser | message                              |
      | Ekdahl   | random | 123456   | checked     | Chrome  | I am registered                      |
      |          | random | 123456   | checked     | Edge    | last name is missing                 |
      | Ekdahl   | random | 1234567  | checked     | Chrome  | password did not match               |
      | Ekdahl   | random | 123456   | not checked | Edge    | terms and conditions are not checked |
