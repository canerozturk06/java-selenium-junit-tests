package tests.testng_heroku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_All;

public class konu8_jsAlerts extends TestBase_All {

    @Test
    public void test01() {

        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin

        driver.get("https://testotomasyonu.com/javascriptAlert");


        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin


        WebElement firstalert = driver.findElement(By.xpath("//*[@*='jsAlert()']"));

        firstalert.click();
        ReusableMethods.bekle(1);

        String actualyazi = driver.switchTo().alert().getText();

        String expectedyazi = "I am a JS Alert";

        Assertions.assertEquals(expectedyazi, actualyazi);


        //	-  OK tusuna basip alert'i kapatin

        driver.switchTo().alert().accept();
        ReusableMethods.bekle(1);


    }


    @Test
    public void test02() {


        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin

        driver.get("https://testotomasyonu.com/javascriptAlert");

        WebElement secondalert = driver.findElement(By.xpath("//*[@*='jsConfirm()']"));
        //	- 2.alert'e tiklayalim

        secondalert.click();


        //	- Cancel'a basip,

        driver.switchTo().alert().dismiss();


        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        String expectedSonucYazisi = "You clicked: Cancel";


        WebElement actualsonucyazi = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));

        String act = actualsonucyazi.getText();

        Assertions.assertEquals(expectedSonucYazisi, act);

        ReusableMethods.bekle(1);
    }

    @Test
    public void test03() {
        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin

        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 3.alert'e tiklayalim

        WebElement thirdalert = driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));

        thirdalert.click();

        ReusableMethods.bekle(1);

        //	- Cikan prompt ekranina "Furkan" yazdiralim
        //	- OK tusuna basarak alert'i kapatalim

        driver.switchTo().alert().sendKeys("Furkan");

        ReusableMethods.bekle(1);
        driver.switchTo().alert().accept();

        ReusableMethods.bekle(1);

        //	- Cikan sonuc yazisinin Furkan icerdigini test edelim

         String expectedyazi3 = "Furkan";

         WebElement actyazi3 = driver.findElement(By.xpath("//*[text()='You entered: Furkan']"));

         String act3 =  actyazi3.getText();

         Assertions.assertTrue(act3.contains(expectedyazi3));

    }

}
