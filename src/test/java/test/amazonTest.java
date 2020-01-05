package test;

import base.Base;
import component.HomePage;
import component.LoginPage;
import component.ProductPage;
import component.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class amazonTest extends Base {
    @BeforeTest
    public void beforetest() { //test oncesi calisir

        super.beforetest ( ); //driveri baslatir
        driver.get ("https://www.amazon.com/"); //amazona gider

    }

    @Test
    public void checkAmazonHomePage() {

        System.out.println("Test checkAmazonHomePage");
        HomePage test = new HomePage(driver);
        Assert.assertEquals(driver.getTitle(), test.title,"Amazon anasayfasina ulasilamadi"); //Amazon.com'a gittikten sonra title'i kontrol et

    }

    @Test (dependsOnMethods={"checkAmazonHomePage"})
    public void signIN() {

        System.out.println("Test signIN");
        LoginPage test = new LoginPage(driver);
        executor.executeScript("arguments[0].click()", test.signIN()); //butona javascript ile tiklar
        test.email().sendKeys(test.email); // email bilginisi girer
        test.continueEmail().click();
        test.password().sendKeys(test.password); // parolayi girer
        test.signInSubmit().click();

    }

    @Test (dependsOnMethods = {"signIN"})
    public void search() {

        SearchPage test = new SearchPage(driver);
        System.out.println("Test search");
        test.searchBox().sendKeys("samsung"); // arama alanina samsung yazar
        executor.executeScript("arguments[0].click()", test.searchButton()); //butona javascript ile tiklar
        Assert.assertEquals(test.searchAssert().getText(),"\"samsung\"", "Arama sonucu yanlis"); // gelen sonuclarin samsung ile ilgili oldugunu dogrular
        test.secondPage().click(); //ikinci sayfaya gider
        Assert.assertEquals(test.selectedPage().getText(),"2", "2. sayfa secili degil!"); //2. sayfada oldugunu dogrular
        test.thirdProduct().click(); //3. urune tiklar

    }

    @Test (dependsOnMethods = {"search"})
    public void whisList(){

        ProductPage test = new ProductPage(driver);
        System.out.println("Test whislist");
        test.setProductName(test.productTitle().getText()); //urunun fiyat bilgisini alip saklar
        test.addToList().click(); // urunu wishliste ekler
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(test.popUpClass))); //pencerenin acilmasini bekler
        test.viewList().click(); // wish liste gider
        Assert.assertEquals(test.itemInList().getText(),test.getProductName(),"Eklenen urun ile listedeki urun uyusmuyor"); //listeki urun ile secilen urunun dogru oldugunu karsilastirir
        test.deleteFromList().click(); // urunu listeden siler
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(test.deleteCSS))); // silinmesi bekler
        Assert.assertEquals(test.deletedAlert().getText(),"Deleted","Urun silinemedi"); // urunun silindigini dogrular

    }

    @AfterTest
    public void aftertest() { // her test sonrasi calisir
        super.aftertest ( ); //driveri kapatir
    }
}
