Feature: As a user, I should be able to log in.

  @faillogin
  Scenario Outline: Verify user login fail with invalid credentials
    Given user on the login page of Trycloud
    When user enter invalid "<username>" and "<password>"
    Then verify "<message>" message should be displayed

    Examples:
      | username | password |
      | Lance    | Griggs   |
      | Inna     | Osadcha  |
      | invalid  | invalid  |
      | Pumak    | Skoom    |