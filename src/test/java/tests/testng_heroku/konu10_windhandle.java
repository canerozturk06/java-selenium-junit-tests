package tests.testng_heroku;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class konu10_windhandle extends TestBase_Each {



     @Test
    public void test1(){
    // testotomasyonu anasayfaya gidin ve window handle degerini yazdirin

       driver.get("https://www.testotomasyonu.com");

         System.out.println("test otomasyonu sayfasinda WHD :" + driver.getWindowHandle());

         String firsttab = driver.getWindowHandle();


         // wisequarter sayfasina gidin

         driver.get("https://www.wisequarter.com");

    // WHD'nin degismedigini test edin
         System.out.println("Wisequarter sayfasinda WHD : " + driver.getWindowHandle());


         driver.switchTo().newWindow(WindowType.TAB);

         driver.get("https://www.testotomasyonu.com");

         System.out.println("ikinci sayfa gethandle :  " +driver.getWindowHandle());

         ReusableMethods.bekle(1);

         driver.switchTo().window(firsttab);

         ReusableMethods.bekle(1);




     }
}
