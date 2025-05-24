Feature: Registering user

	@register
	Scenario: Launch browser and verify Home page
		Given launch chrome browser
		When Navigate to "https://automationexercise.com"
		Then Verify that "Home" is visible
	
	Scenario: Click on Sign Up and Verify New User SignUp page
		When Click on "Sign up" button
		Then Verify that "New User Signup!" is visible
		
	Scenario: Fill name & Address in signUp page
		When Enter name & Address
		And Click on "SignUp" button
		Then Verify that "ENTER ACCOUNT INFORMATION" is visible
		
	Scenario: Fill all the information for Registering and Verify Account is Created
		When Fill details: Title, Name, Email, Password, Date of birth
		And Select checkbox "Sign up for our newsletter!"
		And Select checkbox "Receive special offers from our partners!"
		And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
		And Click on "Create Account button"
		Then Verify that "ACCOUNT CREATED!" is visible
		
	Scenario: Verify UserName is Logged in
		When Clck on "Continue" button
		Then Verify that "Logged in as username" is visible
		
	Scenario: Verify Account deleted
		When Click on "Delete Account" button
		Then Verify that "ACCOUNT DELETED!" is visible
		And Click on "Continue" button