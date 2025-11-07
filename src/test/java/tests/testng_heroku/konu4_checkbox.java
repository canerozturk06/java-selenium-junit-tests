package tests.testng_heroku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;

public class konu4_checkbox extends TestBase_All {


    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
    //	a. Verilen web sayfasına gidin.
    //	     https://testotomasyonu.com/form
    //	b. Sirt Agrisi ve Carpinti checkbox’larini secin

        /*
            checkbox secimini checkbox'in kendisinden yapabildigimiz gibi
            yanindaki yazidan da secmek veya secimi kaldirmak mumkun
            biz ikisini de test etmek icin
            Sirt agrisi checkbox'ini checkbox'in kendisinden
            Carpinti checkbox'ini ise yazidan secelim
         */


    @Test

    public void checkboxTesti() throws InterruptedException {
            driver.get("https://testotomasyonu.com/form");

        WebElement sirtagricheck = driver.findElement(By.id("gridCheck5"));
        WebElement carpinYaz= driver.findElement(By.xpath("(//*[@*='gridCheck4'])[2]"));

        sirtagricheck.click();
        carpinYaz.click();

        Assertions.assertTrue(sirtagricheck.isSelected());

        Thread.sleep(4000);

        Assertions.assertTrue(carpinYaz.isSelected());

        WebElement sheker = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsi = driver.findElement(By.id("hastalikCheck7"));



        Assertions.assertFalse(sheker.isSelected());
        Assertions.assertFalse(epilepsi.isSelected());






    }

}










