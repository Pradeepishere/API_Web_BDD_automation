Feature: Registering user

	@HomePage
	Scenario: Launch browser and verify Home page
		Given launch chrome browser
		When Navigate to "https://automationexercise.com"
		Then Verify that "Home" is visible

		When Click on "SignUp_Icon" button
		Then Verify that "New User Signup!" is visible

		When Enter name & Email from Excel
		And Click on "SignUp_btn" button
		Then Verify that "ENTER ACCOUNT INFORMATION" is visible

		When Fill details: Title, Name, Email, Password, Date of birth
			| Title      | Mr.         |
			| Password   | Masti123    |
			| Day        | 10          |
			| Month      | January     |
			| Year       | 2000        |
		And Select checkbox "Sign up for our newsletter!"
		And Select checkbox "Receive special offers from our partners!"
		And Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
			| First_Name    | Ram   	    |
			| Last_Name     | Lakhan    	|
			| Company       | Dell Corp  	|
			| Address_1     | 123 Main St 	|
			| Address_2     | Apt 123       |
			| Country       | India			|
			| State         | Delhi		  	|
			| City          | New Delhi  	|
			| Zipcode       | 12345       	|
			| Mobile_Number | 1234567890  	|
		And Click on "Create Account" button
		Then Verify that "ACCOUNT CREATED!" is visible

		When Click on "Continue" button
		Then Verify that "Logged in as username" is visible

		When Click on "Delete Account" button
		Then Verify that "ACCOUNT DELETED!" is visible
		And Click on "Continue" button