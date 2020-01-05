package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements (this.driver, this);
    }
    public String email = "sadiyildizz@yandex.com";
    public String password = "test.1234";
    By signinButton = By.xpath("(//span[@class='nav-action-inner'])[1]");
    By emailBox = By.id("ap_email");
    By passwordBox = By.id("ap_password");
    By continueEmail = By.id("continue");
    By signInSubmit = By.id("signInSubmit");


    public WebElement signIN(){
        return driver.findElement (signinButton);
    }

    public WebElement email(){
        return driver.findElement(emailBox);
    }

    public WebElement continueEmail(){
        return driver.findElement(continueEmail);
    }

    public WebElement password(){
        return driver.findElement(passwordBox);
    }

    public WebElement signInSubmit(){
        return driver.findElement(signInSubmit);
    }


}
