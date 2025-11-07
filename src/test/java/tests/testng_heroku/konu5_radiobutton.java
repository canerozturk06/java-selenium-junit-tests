package tests.testng_heroku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_All;

public class konu5_radiobutton extends TestBase_All {

    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //	a. Verilen web sayfasına gidin.
    //	      https://testotomasyonu.com/form
    //	b. Cinsiyet Radio button elementlerini locate edin
    //	c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
    //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin


    @Test
    public void test() throws InterruptedException {

        driver.get("https://testotomasyonu.com/form");

        WebElement kadin = driver.findElement(By.xpath("//*[@id='inlineRadio1']"));

        WebElement erkek = driver.findElement(By.xpath("//*[@id='inlineRadio2']"));

        WebElement diger = driver.findElement(By.xpath("//*[text()='Diğer']"));

        kadin.click();


        Thread.sleep(3000);

        Assertions.assertTrue(kadin.isSelected());
        Assertions.assertFalse(erkek.isSelected());
        Assertions.assertFalse(diger.isSelected());



    }
}