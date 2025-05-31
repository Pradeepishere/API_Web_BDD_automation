package stepDefinitions;

import Pages.*;
import Utilities.Test_Context_Setup;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class WebStepDefinitions
{
    Test_Context_Setup tcs;
    HomePage homePage;
    Login_SignUp_Page login_signUp_page;
    Registration_Page registration_page;
    Continue_Delete_Page continue_del_page;
    Products_Page products_page;
    Cart_Checkout_Page cart_checkout_page;

    public WebStepDefinitions(Test_Context_Setup tcs)
    {
        this.tcs = tcs;
        this.homePage = tcs.pageObject_manager.getHome_page();
        this.login_signUp_page = tcs.pageObject_manager.getLogin_signUp_page();
        this.registration_page = tcs.pageObject_manager.getRegistration_page();
        this.continue_del_page = tcs.pageObject_manager.getContinue_page();
        this.products_page = tcs.pageObject_manager.getProducts_page();
        this.cart_checkout_page = tcs.pageObject_manager.getCart_checkout_page();
    }
    @Given("launch chrome browser")
    public void launch_browser()
    {
        homePage.launch_max_browser();
    }
    @When("Navigate to {string}")
    public void navigate_to_URL(String url)  {
        homePage.go_to_URL(url);

      //  System.out.println(load_Resources.get_Excel_Property_name("filepath")
        //          +" ,***, "+ load_Resources.get_Excel_Property_name("sheet_Name"));


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
        else if (text.equalsIgnoreCase("Login to your account"))
        {
            login_signUp_page.Verify_LoginToAccount_visible();
        }
        else if (text.equalsIgnoreCase("Your email or password is incorrect!"))
        {
            login_signUp_page.verify_emailPassword_Incorrect();
        }
        else if (text.equalsIgnoreCase("Email Address already exist!"))
        {
            login_signUp_page.verify_email_Already_Exists();
        }
        else if (text.equalsIgnoreCase("All Products"))
        {
            products_page.Verify_AllPoducts_Visible();
        }
        else if (text.equalsIgnoreCase("Address Details"))
        {
            cart_checkout_page.verify_Address_details();
        }
        else if (text.equalsIgnoreCase("Congratulations! Your order has been confirmed!"))
        {
            cart_checkout_page.verify_order_Confirmation();
        }

    }
        // *************************************
    @When("Click on {string} button")
    public void click_on_button(String icon_button)
    {
        if(icon_button.equalsIgnoreCase("LoginSignUp_Icon"))
        {
            login_signUp_page.click_on_LoginSignUP_Icon_button();
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
        else if (icon_button.equalsIgnoreCase("login_btn"))
        {
            login_signUp_page.click_on_Login_btn();
        }
        else if (icon_button.equalsIgnoreCase("Products"))
        {
            homePage.click_on_Products_Icon();
        }
        else if (icon_button.equalsIgnoreCase("Cart"))
        {
            homePage.click_on_cart_Icon();
        }
        else if (icon_button.equalsIgnoreCase("Proceed To Checkout"))
        {
            cart_checkout_page.click_onProceed_to_checkout();
        }
        else if (icon_button.equalsIgnoreCase("Place Order"))
        {
            cart_checkout_page.click_on_place_Order();
        }
        else if (icon_button.equalsIgnoreCase("Pay and Confirm Order"))
        {
            cart_checkout_page.click_on_Confirm_payment();
        }
        else if (icon_button.equalsIgnoreCase("Download Invoice"))
        {
            cart_checkout_page.click_on_download_Invoice();
        }

        //  *********************
    }
    @When("Enter name & Email from Excel")
    public void enter_name_Address()
    {
        login_signUp_page.enter_name_address_From_EXCEL();
    }
    @When("Enter {string} and {string} for Already Registered user in signUp Page")
    public void enter_name_Email(String name, String email)
    {
        login_signUp_page.enter_name_email(name,email);
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

    @When("Enter correct Email and password")
    public void enter_Correct_Email_password(Map<String,String> dataTable)
    {
        login_signUp_page.enter_Correct_email_Pwd(dataTable);
    }
    @When("Enter Incorrect {string} and {string}")
    public void enter_InCorrect_Email_password(String email, String password)
    {
        login_signUp_page.enter_InCorrect_email_Pwd(email, password);
    }
    @When("Click on Search Product for {string} and search")
    public void search_product(String Tshirts)
    {
        products_page.search_product(Tshirts);
    }
    @When("Add {string} Product to cart")
    public void add_Product_to_Cart(String Tshirt_name)
    {
        products_page.add_product_to_cart(Tshirt_name);
    }
    @Then("Verify that {string} item is {int} and Quantity is {int}")
    public void Verify_Total_Product_and_Quantity(String Product, int itemN0, int quantity)
    {
        cart_checkout_page.verify_Product_item_quantity(Product, itemN0, quantity);
    }
    @When("Fill details: {string}, {long}, {int}, {int} and {int}")
    public void fill_payment_details( String name,long cardNo, int cvc, int expiry, int year)
    {
        cart_checkout_page.fill_Payment_details( name, String.valueOf(cardNo),
                                                String.valueOf(cvc), String.valueOf(expiry), String.valueOf(year));
    }




    @After
    public void tearDownScenario(Scenario scenario) {
        WebDriver driver = tcs.getWebdriver();
        if (scenario.isFailed()  && driver != null)
        {
            System.out.println("Scenario '" + scenario.getName() + "' failed! Capturing screenshot...");
            String scenario_name = scenario.getName();

            // tcs.utility.screenShot_Capture(driver, scenario_name);
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // Embed the screenshot into the Cucumber report
                scenario.attach(screenshot, "image/png", scenario.getName()+".png");
                System.out.println("Screenshot captured for failed scenario: " + scenario.getName());
            } catch (Exception e) {
                System.err.println("Failed to take screenshot: " + e.getMessage());
                scenario.attach("Error taking screenshot: " + e.getMessage(), "text/plain", "Screenshot_Error");
            }
        }
        else
            System.out.println("Finished scenario. Browser closed.");
            tcs.tearDown();

    }


    }

