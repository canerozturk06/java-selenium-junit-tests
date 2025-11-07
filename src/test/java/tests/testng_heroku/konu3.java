package tests.testng_heroku;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class konu3  {

    static WebDriver driver;
    @BeforeAll

    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach

    public void setupEach(){
        driver.get("https://www.bestbuy.com");
    }

    @AfterAll
    public static void teardown(){
            driver.quit();
    }


    @Test

    public void urlTest() {
        String actualUrl = driver.getCurrentUrl();
        String expectUrl = "https://www.bestbuy.com/";

        Assertions.assertEquals(expectUrl,actualUrl);

    }

    @Test
                public void titleTest(){

              String actualTitle = driver.getTitle();

              String unexp = "Rest";

              Assertions.assertFalse(actualTitle.contains(unexp));
        }

     @Test

    public void logotest(){
         //estBuy logosunun görüntülendigini test edin

      WebElement logo = driver.findElement(By.xpath("(//*[@*='Best Buy Logo'])[1]"));

      Assertions.assertTrue(logo.isDisplayed());


    }

    //	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    @Test
    public void frans(){

         WebElement link  =  driver.findElement(By.xpath(" //*[text()='Français']"));

         Assertions.assertTrue(link.isDisplayed());

    }




}



