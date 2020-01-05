package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;

    private String productName = null;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements (this.driver, this);
    }

    public void setProductName(String product)
    {
        this.productName = product;
    }

    public String getProductName()
    {
        return this.productName;
    }

    By addToList = By.id("add-to-wishlist-button-submit");
    By productTitle = By.id("productTitle");
    By viewList = By.id("WLHUC_viewlist");
    By itemInList = By.cssSelector("div.g-span12when-narrow:nth-child(1)");
    By itemInList2 = By.className("a-link-normal");
    By deleteFromList = By.xpath("(//input[@name='submit.deleteItem'])[1]");
    By deletedAlert = By.cssSelector("div.a-alert-inline:nth-child(1)");
    public String popUpClass = "w-popover-body";
    public String deleteCSS = "div.a-alert-inline:nth-child(1)";


    public WebElement addToList(){
        return driver.findElement (addToList);
    }

    public WebElement deletedAlert(){ return driver.findElement (deletedAlert); }

    public WebElement deleteFromList(){
        return driver.findElement (deleteFromList);
    }

    public WebElement itemInList(){
        return driver.findElement (itemInList).findElement(itemInList2);
    }

    public WebElement viewList(){
        return driver.findElement (viewList);
    }

    public WebElement productTitle(){ return driver.findElement (productTitle); }

}
