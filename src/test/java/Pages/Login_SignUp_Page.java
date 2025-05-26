package Pages;

import Utilities.WebUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login_SignUp_Page extends WebUtilities {
    WebDriver driver;
    @FindBy(xpath = "//a[@href='/login']")
    WebElement signuploginIicon;
    @FindBy(xpath = "//h2[.='New User Signup!']")
    WebElement newusersignup;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    WebElement signupName;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signupEmail;
    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signupbtn;
    @FindBy(xpath = "//p[.='Email Address already exist!']")
    WebElement email_Already_exists;
    @FindBy(xpath = "//b[.='Enter Account Information']")
    WebElement accountinfo;
    String registeredUsername; // To store the generated username
    String registeredEmail;

    public Login_SignUp_Page(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void click_onSignUP_Icon_button()
    {
        explicitwait().until(ExpectedConditions.elementToBeClickable(signuploginIicon)).click();
      //  signuploginIicon.click();
    }
    public void Verify_NewUserSignup_visible()
    {
        System.out.println(" New User Signup! is Displayed : "+ newusersignup.isDisplayed());
        System.out.println(" New User Signup! Text : "+ newusersignup.getText());
    }
    public void enter_name_address_From_EXCEL()
    {
//        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
//        registeredUsername = "TestUser" + timestamp;
//        registeredEmail = "testuser" + timestamp + "@example.com";

        registeredUsername = access_Excel_Data().get("Name");
        registeredEmail = access_Excel_Data().get("Email");

        System.out.println("UserName : "+registeredUsername +"  &   Email : "+registeredEmail);
        signupName.sendKeys(registeredUsername);
        signupEmail.sendKeys(registeredEmail);
    }
    public void click_on_SignUp_btn()
    {
        signupbtn.click();
    }
    public void accountInfo_visible()
    {
        System.out.println("Enter Accout info is Displayed : "+ accountinfo.isDisplayed());
        System.out.println("Enter Account info Text : "+ accountinfo.getText());
    }

}
