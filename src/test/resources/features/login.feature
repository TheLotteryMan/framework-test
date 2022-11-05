Feature: Verify login feature


  Scenario: Verify login with valid credentials
    Given user on the login page of Trycloud

  @verifylogin
  Scenario Outline:
    Given user on the login page of Trycloud
    When user use username "<username>" and passcode "<password>"
    Then verify the user should be at the dashboard page

    Examples:
      | username | password    |
      | User13   | Userpass123 |
      | User43   | Userpass123 |
      | User73   | Userpass123 |
      | User103  | Userpass123 |
