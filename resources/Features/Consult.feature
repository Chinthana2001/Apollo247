@Services1

Feature: To check the search functionality

  Background: 
    Given User is on Apollo homepage

  @Invalid
  Scenario: To validate call functionality
    When user is on consult page1
    Then user clicks on call option

  @Search
  Scenario: To search doctors by specialty
    When user is on search by specialty page
    And clicks on Clinical nutrition and dietetics
    And click on the doctor
    Then user should able to see specialty doctor

  @ProHealth
  Scenario Outline: To book proHealth program
    When user is on proHealth page
    And user should click on lets go option
    And user clicks on health packages
    And user enters <name>
    And selects city from dropdown
    And Enter <number>
    Then user should be able to get otp

    Examples: 
      | name  | number     |
      | Chint | 8296382860 |

  @Appointments
  Scenario: To view active appointments
    When user is on consult page
    And clicks on active appointments
    Then list of appointments is shown

  @Share
  Scenario: To validate share functionality
    When user is on All doctors list
    And clicks on a doctor name
    And clicks the share icon
    Then it should get a message
