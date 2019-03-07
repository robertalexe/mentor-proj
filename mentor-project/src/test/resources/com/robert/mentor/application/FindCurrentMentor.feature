@Mentor
Feature: Retrieving current logged in mentor details

  As a Mentor of the Mentor App
  In order to heck if my profile details are up to date
  I want to be able to retrieve my profile details

  Background:
    Given I am logged in by email "test@test.com"

    Scenario: 01 - Retrieving profile information for logged in mentor
      Given there is an already signedUp mentor with the following details:
        | email       | test@test.com         |
        | password    | pass                  |
        | firstName   | First                 |
        | lastName    | Last                  |
        | contactNo   | +0000                 |
        | zoneId      | Australia/Darwin      |
        | workingTimes| MONDAY                |
        | linkedInUrl | http://linkedin.com   |
        | yearsOfExp  | 5                     |
      When I consult my profile details
      Then I can see the following information:
        | email       | test@test.com         |
        | password    | pass                  |
        | firstName   | First                 |
        | lastName    | Last                  |
        | contactNo   | +0000                 |
        | zoneId      | Australia/Darwin      |
        | workingTimes| MONDAY 10 12          |
        | linkedInUrl | http://linkedin.com   |
        | yearsOfExp  | 5                     |

  Scenario: 02 - Retrieving profile information for non-existent mentor
    Given there is no user with email "abc@abc.com"
    When I consult the profile details for "abc@abc.com"
    Then I receive an exception