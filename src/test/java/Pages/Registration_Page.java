package Pages;

import Utilities.WebUtilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Map;

public class Registration_Page extends WebUtilities {
    WebDriver driver;

    @FindBy(css = "input#id_gender1")
    WebElement titlemr;
    @FindBy(css = "input#id_gender2")
    WebElement titlemrs;
    @FindBy(css = "input#password")
    WebElement password;
    @FindBy(css = "select#days")
    WebElement selectdays;
    @FindBy(css = "select#months")
    WebElement selectmonths;
    @FindBy(css = "select#years")
    WebElement selectyears;
    @FindBy(xpath = "//div[@class='grippy-host']")
    WebElement adremove;
    @FindBy(xpath = "(//div[@class='checkbox'])[1]/label")
    WebElement checkbox_newsletter;
    @FindBy(xpath = "//label[starts-with(text(),'Sign up for our newsletter!')]")
    WebElement newsletter;
    @FindBy(xpath = "(//div[@class='checkbox'])[2]/label")
    WebElement checkbox_specialoffers;

    @FindBy(css = "#first_name")
    WebElement firstname;
    @FindBy(css = "#last_name")
    WebElement lastname;
    @FindBy(css = "#company")
    WebElement company;
    @FindBy(css = "#address1")
    WebElement address1;
    @FindBy(css = "#address2")
    WebElement address2;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css = "input#state")
    WebElement state;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#zipcode")
    WebElement zipcode;
    @FindBy(css = "#mobile_number")
    WebElement mobilenum;

    @FindBy(xpath = "//button[text()='Create Account']")
    WebElement createaccount;


    public Registration_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillAccountDetails(Map<String, String> details)
    {
        String title = details.get("Title");
        if (title.equalsIgnoreCase("Mr.")) {
            titlemr.click();
        } else if (title.equalsIgnoreCase("Mrs.")) {
            titlemrs.click();
        }
        password.sendKeys(details.get("Password"));

        new Select(selectdays).selectByValue(details.get("Day"));
        new Select(selectmonths).selectByVisibleText(details.get("Month"));
        new Select(selectyears).selectByValue(details.get("Year"));
    }

    public void remove_Ad_and_FocusOn_WebElement() {

        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30))        // Maximum wait time
                    .pollingEvery(Duration.ofSeconds(2))        // Check every 2 seconds
                    .ignoring(NoSuchElementException.class);    // Ignore this exception during polling

            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(adremove));
            element.click();
            System.out.println("Ad Removed successfully!");
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

       // System.out.println("AD remove : "+explicitwait().until(ExpectedConditions.visibilityOf(adremove)).isDisplayed());
//        if  (adremove.isDisplayed() || explicitwait().until(ExpectedConditions.visibilityOf(adremove)).isDisplayed() )  // (explicitwait().until(ExpectedConditions.visibilityOf(adremove)).isDisplayed())
//             {
//            System.out.println("Ad present");
//            explicitwait().until(ExpectedConditions.elementToBeClickable(adremove)).click();
//            System.out.println("Ad closed successfully.");
//             // adremove.click();
//             }
//        else System.out.println("Ad not present");

        JavascriptExecutor jse = (JavascriptExecutor) driver;        //  as Newsletter checkbox showing Element not clickable as Ad is covering it
        jse.executeScript("arguments[0].scrollIntoView(true);", newsletter);        // therfore we Focus on to Webelement using javascript
    }

    public void checkBox_for_NewsLetter() {
        checkbox_newsletter.click();
    }

    public void checkbox_for_ReceiveSpecialOffers() {
        checkbox_specialoffers.click();
    }

    public void fill_Personel_Details(Map<String, String> details) {
        firstname.sendKeys(details.get("First_Name"));
        lastname.sendKeys(details.get("Last_Name"));
        company.sendKeys(details.get("Company"));
        address1.sendKeys(details.get("Address_1"));
        address2.sendKeys(details.get("Address_2"));
        country.sendKeys(details.get("Country"));
        state.sendKeys(details.get("State"));
        city.sendKeys(details.get("City"));
        zipcode.sendKeys(details.get("Zipcode"));
        mobilenum.sendKeys(details.get("Mobile_Number"));
    }

    public void click_on_CreateAccount() {
        createaccount.click();
    }


}
