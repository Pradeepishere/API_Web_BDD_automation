package Pages;

import Utilities.WebUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Map;

public class Login_SignUp_Page extends WebUtilities {
    WebDriver driver;
    @FindBy(xpath = "//a[@href='/login']")
    WebElement login_signUp_icon;
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

    @FindBy(xpath = "//h2[starts-with(text(),'Login to your account')]")
    WebElement login_text;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmail;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement loginPassword;
    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginbtn;
    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    WebElement incorrect_emailPwd_text;

    String registeredUsername; // To store the generated username
    String registeredEmail;

    public Login_SignUp_Page(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void click_on_LoginSignUP_Icon_button()
    {
        explicitwait().until(ExpectedConditions.elementToBeClickable(login_signUp_icon)).click();
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
    public void enter_name_email(String name, String email)
    {
        System.out.println("SignUp Name : "+ explicitwait().until(ExpectedConditions.visibilityOf(signupName)).isDisplayed());
        System.out.println("SignUp Email : "+explicitwait().until(ExpectedConditions.visibilityOf(signupEmail)).isDisplayed());
        explicitwait().until(ExpectedConditions.elementToBeClickable(signupName)).sendKeys(name);
        explicitwait().until(ExpectedConditions.visibilityOf(signupEmail)).sendKeys(email);
    }
    public void verify_email_Already_Exists()
    {
        System.out.println("Email Already Exists : "+explicitwait().until(ExpectedConditions.visibilityOf(email_Already_exists)).getText());
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

    public void Verify_LoginToAccount_visible()
    {
       // explicitwait().until(ExpectedConditions.visibilityOf(login_text));
        System.out.println(" Login to your account is Displayed : "+ login_text.isDisplayed());
        System.out.println(" Login to your account Text : "+ login_text.getText());
    }
    public void enter_Correct_email_Pwd(Map<String,String> details)
    {
        loginEmail.sendKeys( details.get("Email"));
        loginPassword.sendKeys( details.get("Password"));
    }
    public void enter_InCorrect_email_Pwd(String email, String password)
    {
        loginEmail.sendKeys( email );
        loginPassword.sendKeys( password );
    }
    public void verify_emailPassword_Incorrect()
    {
        Assert.assertTrue(explicitwait().until(ExpectedConditions.visibilityOf(incorrect_emailPwd_text)).isDisplayed());
        System.out.println(incorrect_emailPwd_text.getText());
    }

    public void click_on_Login_btn()
    {
        loginbtn.click();
    }

}
