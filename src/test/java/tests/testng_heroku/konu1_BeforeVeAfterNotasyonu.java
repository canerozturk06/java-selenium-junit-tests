package tests.testng_heroku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class konu1_BeforeVeAfterNotasyonu {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https:www.testotomasyonu.com");




        String expectedtitle = "Test Otomasyonu";

        String actualtitle = driver.getTitle();

        Assertions.assertTrue(actualtitle.contains(expectedtitle));

        WebElement furniture = driver.findElement(By.xpath("(//*[text()='Furniture'])[3]"));

        furniture.click();

        WebElement profound = driver.findElement(By.className("product-count-text"));

        String expectedFurnProdquant = "6 Products Found";
        String actualFurnProdquant = profound.getText();

        Assertions.assertEquals(expectedFurnProdquant,actualFurnProdquant);

        WebElement minKutusu = driver.findElement(By.xpath("//*[@*='form-control minPrice']"));
        minKutusu.clear();
        minKutusu.sendKeys("40");

        WebElement maxKutusu = driver.findElement(By.xpath("//*[@*='form-control maxPrice']"));
        maxKutusu.clear();
        maxKutusu.sendKeys("200");

        Thread.sleep(2000);

        WebElement filtPriBut = driver.findElement(By.xpath("//*[text()='Filter Price']"));

        filtPriBut.click();

        WebElement urunFiyatElementi = driver.findElement(By.xpath("(//*[@*='price'])[1]"));

        System.out.println(urunFiyatElementi.getText());

        String urunfiyatiStr = urunFiyatElementi.getText();

        urunfiyatiStr = urunfiyatiStr.replaceAll("\\D","");

        Double urunFiyatıDbl = Double.parseDouble(urunfiyatiStr) / 100;

        if (urunFiyatıDbl >= 40 && urunFiyatıDbl<= 200) {
            System.out.println("passed");
        }else System.out.println("failed");









        //WebElement aramakutusu = driver.findElement(By.id("global-search"));
        //aramakutusu.sendKeys("shoe");
        //Thread.sleep(2000);
        //aramakutusu.submit();
        //Thread.sleep(2000);
        //driver.quit();




    }
}
