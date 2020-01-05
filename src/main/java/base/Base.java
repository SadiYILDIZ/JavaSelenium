package base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor executor; //javascript kodu calistirabilmek icin

    public void beforetest(){ //test baslamadan once driveri olusturur
        System.setProperty ("webdriver.chrome.driver",".//.//.//chromedriver.exe"); //projenin icinde Chrome v79'a ait driver mevcuttur
        driver = new ChromeDriver();
        wait = new WebDriverWait (driver,20);
        driver.manage ().window ().maximize ();
        executor = (JavascriptExecutor)driver;
    }

    public void aftertest(){ // test bittikten sonra driveri kapatir
        driver.quit ();
    }
}
