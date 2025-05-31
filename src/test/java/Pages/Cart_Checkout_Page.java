package Pages;

import Utilities.WebUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class Cart_Checkout_Page extends WebUtilities {
    WebDriver driver;

    @FindBy(css = ".container div span p")
    WebElement cart_Is_Empty;

    @FindBy(xpath = "(//tbody/tr)")
    List<WebElement> items_in_cart;
    @FindBy(xpath = "(//tbody//td/h4/a)")
    WebElement item_name;
    @FindBy(xpath = "(//tbody//td/button)")
    WebElement item_quantity;

    @FindBy(xpath = "//div/a[text()='Proceed To Checkout']")
    WebElement proceed_to_Chekout;
    @FindBy(xpath = "//div/h2[contains(.,'Address Details')]")
    WebElement address_Details;
    @FindBy(xpath = "//ul/li/h3[text()='Your delivery address']")
    WebElement deliver_Address;
    @FindBy(xpath = ".container div span p")
    WebElement total_Amount_text;
    @FindBy(xpath = "//div[@class='container']//a[text()='Place Order']")
    WebElement place_Order_btn;
    @FindBy(xpath = "//div/h2[.='Payment']")

    WebElement payment_text;
    @FindBy(name = "name_on_card")
    WebElement name_on_Card;
    @FindBy(name = "card_number")
    WebElement card_Number;
    @FindBy(name = "cvc")
    WebElement CVC;
    @FindBy(name = "expiry_month")
    WebElement expiration;
    @FindBy(name = "expiry_year")
    WebElement expiry_year;
    @FindBy(css = "#submit")
    WebElement pay_Confirm_order;
    @FindBy(xpath = "//div/p[text()='Congratulations! Your order has been confirmed!']")
    WebElement order_Successfully_text;
    @FindBy(xpath = "//div/h2[contains(.,'Order Placed!')]")
    WebElement order_placed_text;
    @FindBy(xpath = "//div/a[.='Download Invoice']")
    WebElement download_Invoice;

    public Cart_Checkout_Page(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void verify_Product_item_quantity(String product_Name, int item_No, int quantity)
    {
        System.out.println("items In Cart : " + items_in_cart.size() +", Item No : " +item_No+
                            " and item_quantity : " + item_quantity.getText() +" & quantity is StepDefinition : "+ quantity);
        if ( (items_in_cart.size() == item_No && item_quantity.getText().equals(String.valueOf(quantity))) )
        {
            System.out.println("items In Cart : " +items_in_cart.size());
            System.out.println("item Name : " +explicitwait().until(ExpectedConditions.visibilityOf(item_name)).getText());
            Assert.assertEquals( item_name.getText(), product_Name);

            System.out.println("item Quantity : "+
                                    explicitwait().until(ExpectedConditions.visibilityOf(item_quantity)).getText());
        }
    }
    public void click_onProceed_to_checkout()
    {
        proceed_to_Chekout.click();
    }
    public void verify_Address_details()
    {
        address_Details = explicitwait().until(ExpectedConditions.visibilityOf(address_Details));
        System.out.println(address_Details.getText() +" : is Visible : "+ address_Details.isDisplayed());
        deliver_Address = explicitwait().until(ExpectedConditions.visibilityOf(deliver_Address));
        System.out.println(deliver_Address.getText() +" : is Visible : " + deliver_Address.isDisplayed());
    }
    public void click_on_place_Order()
    {
        System.out.println("palce Order visible : "+explicitwait().until(ExpectedConditions.visibilityOf(place_Order_btn)).isDisplayed());
        javaScriptExec(driver).executeScript("arguments[0].scrollIntoView(true);", place_Order_btn);
        explicitwait().until(ExpectedConditions.elementToBeClickable(place_Order_btn)).click();
    }
    public void fill_Payment_details(String name, String cardNo, String cvc, String expiry, String year)
    {
        System.out.println("Payment text : "+ explicitwait().until(ExpectedConditions.visibilityOf(payment_text)).getText());
        name_on_Card.sendKeys(name);
        card_Number.sendKeys(cardNo);
        CVC.sendKeys(cvc);
        expiration.sendKeys(expiry);
        expiry_year.sendKeys(year);
    }
    public void click_on_Confirm_payment()
    {
        javaScriptExec(driver).executeScript("arguments[0].scrollIntoView(true);", pay_Confirm_order);
        explicitwait().until(ExpectedConditions.elementToBeClickable(pay_Confirm_order)).click();
    }
    public void verify_order_Confirmation()
    {
        explicitwait().until(ExpectedConditions.visibilityOf(order_Successfully_text));
        System.out.println(order_Successfully_text.getText() + " is Visible : " + order_Successfully_text.isDisplayed());
        System.out.println("Order Placed : "+explicitwait().until(ExpectedConditions.visibilityOf(order_placed_text)).getText());
    }
    public void click_on_download_Invoice()
    {
        Assert.assertTrue(explicitwait().until(ExpectedConditions.visibilityOf(download_Invoice)).isDisplayed());
        download_Invoice.click();
    }


}
