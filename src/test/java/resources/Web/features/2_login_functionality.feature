Feature: User Login Functionality

  Background:
    Given launch chrome browser
    When Navigate to "https://automationexercise.com"
    Then Verify that "Home" is visible

    When Click on "LoginSignUp_Icon" button
    Then Verify that "Login to your account" is visible

  @login
  Scenario: Login User with correct email and password
    When Enter correct Email and password
        | Email     | masti123@gmail.com    |
        | Password  | mastizone123          |
    And Click on "login_btn" button
    Then Verify that "Logged in as username" is visible

  @login
  Scenario Outline: Login User with Incorrect email and password
    When Enter Incorrect "<Email>" and "<Password>"
    And Click on "login_btn" button
    Then Verify that "Your email or password is incorrect!" is visible

    Examples:
      | Email              | Password  |
      | masti123@gmail.com | abc123    |