package Pages;

import Utilities.WebUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Continue_Delete_Page extends WebUtilities {
    WebDriver driver;

    @FindBy(xpath = "//h2/b[.='Account Created!']")
    WebElement accountcreated;
    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continue_btn;
    @FindBy(xpath = "//h2[contains(.,'Account Deleted!')]")
    WebElement accountdeleted;

    public Continue_Delete_Page(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verify_AccountCreated_visible()
    {
        System.out.println("ACCOUNT CREATED! is Displayed : "+ accountcreated.isDisplayed());
        System.out.println("ACCOUNT CREATED! Text : "+ accountcreated.getText());
    }
    public void click_on_Continue_btn()
    {
        continue_btn.click();
    }
    public void verify_Account_Deleted()
    {
        System.out.println("ACCOUNT DELETED! is Displayed : "+ accountdeleted.isDisplayed());
        System.out.println("ACCOUNT DELETED! Text : "+ accountdeleted.getText());
    }
}
