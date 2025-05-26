package stepDefinitions;

import Pages.Continue_Delete_Page;
import Pages.HomePage;
import Pages.Login_SignUp_Page;
import Pages.Registration_Page;
import Utilities.Test_Context_Setup;
import Utilities.load_Resources;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class WebStepDefinitions
{
    Test_Context_Setup tcs;
    HomePage homePage;
    Login_SignUp_Page login_signUp_page;
    Registration_Page registration_page;
    Continue_Delete_Page continue_del_page;

    public WebStepDefinitions(Test_Context_Setup tcs)
    {
        this.tcs = tcs;
        this.homePage = tcs.pageObject_manager.getHome_page();
        this.login_signUp_page = tcs.pageObject_manager.getLogin_signUp_page();
        this.registration_page = tcs.pageObject_manager.getRegistration_page();
        this.continue_del_page = tcs.pageObject_manager.getContinue_page();
    }
    @Given("launch chrome browser")
    public void launch_browser()
    {
        homePage.launch_max_browser();
    }
    @When("Navigate to {string}")
    public void navigate_to_URL(String url)  {
        homePage.go_to_URL(url);

        System.out.println(load_Resources.get_Excel_Property_name("filepath")
                        +" ,***, "+ load_Resources.get_Excel_Property_name("sheet_Name"));


    }
    @Then("Verify that {string} is visible")
    public void verirfy_if_Text_is_Visible(String text)
    {
        if(text.equalsIgnoreCase("Home"))
        {
            homePage.homePage_visible();
        }
        else if (text.equalsIgnoreCase("New User Signup!"))
        {
            login_signUp_page.Verify_NewUserSignup_visible();
        }
        else if (text.equalsIgnoreCase("ENTER ACCOUNT INFORMATION"))
        {
            login_signUp_page.accountInfo_visible();
        }
        else if (text.equalsIgnoreCase("ACCOUNT CREATED!"))
        {
            continue_del_page.verify_AccountCreated_visible();
        }
        else if (text.equalsIgnoreCase("Logged in as username"))
        {
            homePage.LoggedInAs_UserName_visible();
        }
        else if (text.equalsIgnoreCase("ACCOUNT DELETED!"))
        {
            continue_del_page.verify_Account_Deleted();
        }
    }
        // *************************************
    @When("Click on {string} button")
    public void click_on_SignUp_Icon_button(String icon_button)
    {
        if(icon_button.equalsIgnoreCase("SignUp_Icon"))
        {
            login_signUp_page.click_onSignUP_Icon_button();
        }
        else if (icon_button.equalsIgnoreCase("SignUp_btn"))
        {
           login_signUp_page.click_on_SignUp_btn();
        }
        else if (icon_button.equalsIgnoreCase("Create Account"))
        {
            registration_page.click_on_CreateAccount();
        }
        else if (icon_button.equalsIgnoreCase("Continue"))
        {
            continue_del_page.click_on_Continue_btn();
        }
        else if ((icon_button.equalsIgnoreCase("Delete Account")))
        {
            homePage.delete_Account();
        }

        //  *********************
    }
    @When("Enter name & Email from Excel")
    public void enter_name_Address()
    {
        login_signUp_page.enter_name_address_From_EXCEL();
    }
    @When("Click on SignUp button")
    public void click_on_SignUp_button()
    {
        login_signUp_page.click_on_SignUp_btn();
    }
    //      ****************************

    @When("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_Account_Details(Map<String,String> dataTable)
    {
        registration_page.fillAccountDetails(dataTable);
    }
    @When("Select checkbox {string}")
    public void select_CheckBoxes(String checkbox_text)
    {
        registration_page.remove_Ad_and_FocusOn_WebElement();
        if(checkbox_text.equalsIgnoreCase("Sign up for our newsletter!"))
        {
            registration_page.checkBox_for_NewsLetter();
        }
        else if (checkbox_text.equalsIgnoreCase("Receive special offers from our partners!"))
        {
            registration_page.checkbox_for_ReceiveSpecialOffers();
        }
    }
    @When("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_Personel_Details(Map<String,String> data_Table)
    {
        registration_page.fill_Personel_Details(data_Table);
    }

    @After
    public void tearDown() {
            homePage.close_browser();
        }
    }

