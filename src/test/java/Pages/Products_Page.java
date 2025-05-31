package Pages;

import Utilities.WebUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Products_Page extends WebUtilities {
    WebDriver driver;

    @FindBy(xpath = "//h2[text()='All Products']")
    WebElement all_products_text;
    @FindBy(css = "#search_product")
    WebElement search_product;
    @FindBy(css = "#submit_search")
    WebElement search_submit_btn;

    @FindBy(xpath = "(//div[@class='features_items']//div[@class='product-image-wrapper'])")
    List<WebElement> all_Tshirt_products;
    String tshirt_name =  "(//div/div/img//following-sibling::p)";
    String dataid = "(//div[@class='features_items']//div/a)";

    @FindBy(css = ".modal-content h4")
    WebElement product_Added;
    @FindBy(xpath = "//div[@id='cartModal']//button[contains(text(), 'Continue Shopping')]")          //button[text()='Continue Shopping']
    WebElement continue_Shopping;

    public Products_Page(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Verify_AllPoducts_Visible()
    {
        //Assert.assertTrue( explicitwait().until(ExpectedConditions.visibilityOf(all_products_text)).isDisplayed());
        System.out.println(all_products_text.getText() +" is Displayed : " + all_products_text.isDisplayed());
    }
    public void search_product(String Tshirts)
    {
        search_product.sendKeys(Tshirts);
        search_submit_btn.click();
    }
    public void add_product_to_cart(String Tshirt_name)
    {
        System.out.println("ALL Products , total Tshirts : "+ all_Tshirt_products.size());
        for (int i=0; i < all_Tshirt_products.size(); i++)
        {
            WebElement ele = all_Tshirt_products.get(i);
          //  System.out.println(ele.getText());
            //System.out.println("---------");
            int j = i+1;

            String shirt_name = ele.findElement(By.xpath(tshirt_name + "["+j+"]") ).getText();
            //System.out.println(shirt_name);
          //  System.out.println("***********");

            if (shirt_name.equalsIgnoreCase(Tshirt_name))
            {
                int k = j*2;
                WebElement data_prod_id = ele.findElement(By.xpath(dataid + "[" +k+ "]" ));
                String id = data_prod_id.getDomAttribute("data-product-id");
                System.out.println(" Product data id : " +data_prod_id.getDomAttribute("data-product-id"));

                String add_to_cart_id = "//div[@class='features_items']//a[@data-product-id='"+id+"']";
                System.out.println("X-path : " +add_to_cart_id);
                WebElement addtocart = driver.findElement(By.xpath(add_to_cart_id));

                actionsMeth(driver).moveToElement(ele).perform();
                System.out.println("Element contains text : "+ele.getText().contains("View Product"));

               // String addtocart_text = addtocart.getText();
               // System.out.println( addtocart_text + " ; count = " + j);

                System.out.println("Add to cart visible : "+explicitwait().until(ExpectedConditions.visibilityOf(addtocart)).isDisplayed());

                javaScriptExec(driver).executeScript("arguments[0].scrollIntoView(true);", addtocart);

                explicitwait().until(ExpectedConditions.elementToBeClickable(addtocart)).click();
                break;
            }
           // else  {  System.out.println("TShirt text Not found"); }
        }
        System.out.println("continue_Shopping : "+ explicitwait().until(ExpectedConditions.visibilityOf(product_Added)).isDisplayed());
        System.out.println("Text : " + explicitwait().until(ExpectedConditions.visibilityOf(continue_Shopping)).getText() + " is Visible");
        System.out.println("Text : " + explicitwait().until(ExpectedConditions.visibilityOf(product_Added)).getText() + " is Visible");

        explicitwait().until(ExpectedConditions.elementToBeClickable(continue_Shopping)).click();
        explicitwait().until(ExpectedConditions.invisibilityOf(continue_Shopping));
    }



}

