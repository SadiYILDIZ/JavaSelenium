package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    WebDriver driver;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements (this.driver, this);
    }

    By searchBox = By.id("twotabsearchtextbox");
    By searchButton = By.className("nav-input");
    By searchAssert = By.xpath("//span[@class='a-color-state a-text-bold']");
    By thirdProduct = By.xpath("//img[@data-image-index='2']"); //3. siradaki urunun xpathi
    By secondPage = By.cssSelector("li.a-normal:nth-child(3) > a:nth-child(1)");
    By selectedPage = By.className("a-selected");


    public WebElement searchBox(){ return driver.findElement (searchBox); }

    public WebElement searchButton(){ return driver.findElement(searchButton); }

    public WebElement thirdProduct(){ return driver.findElement(thirdProduct); }

    public WebElement searchAssert(){
        return driver.findElement(searchAssert);
    }

    public WebElement selectedPage(){
        return driver.findElement(selectedPage);
    }

    public WebElement secondPage(){
        return driver.findElement(secondPage);
    }



}
