package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.WebStepDefinitions;

import java.util.zip.Checksum;

public class PageObject_Manager {

    public HomePage home_page;
    public Login_SignUp_Page login_signUp_page;
    public Registration_Page registration_page;
    public Continue_Delete_Page continue_del_page;
    public Products_Page products_page;
    public Cart_Checkout_Page cart_checkout_page;
    public WebDriver driver;

    public PageObject_Manager(WebDriver driver)
    {
        this.driver = driver;
    }
    public HomePage getHome_page()
    {
        home_page = new HomePage(driver);
        return home_page;
    }
    public Login_SignUp_Page getLogin_signUp_page()
    {
        login_signUp_page = new Login_SignUp_Page(driver);
        return login_signUp_page;
    }
    public Registration_Page getRegistration_page()
    {
        registration_page = new Registration_Page(driver);
        return registration_page;
    }
    public Continue_Delete_Page getContinue_page()
    {
        Continue_Delete_Page continue_del_page = new Continue_Delete_Page(driver);
        return continue_del_page;
    }

    public Products_Page getProducts_page()
    {
        Products_Page products_page = new Products_Page(driver);
        return products_page;
    }
    public Cart_Checkout_Page getCart_checkout_page()
    {
        Cart_Checkout_Page cart_checkout_page =  new Cart_Checkout_Page(driver);
        return cart_checkout_page;
    }
}
