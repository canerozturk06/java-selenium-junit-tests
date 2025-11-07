package tests.testng_heroku;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class konu6_dropdown extends TestBase_Each {
    //● https://testotomasyonu.com/form adresine gidin.

    @Test
    public void test1() throws InterruptedException {

      driver.get("https://testotomasyonu.com/form");

    //1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        // dropdown menuyu kullanmak icin 3 adim atmamiz gerekir
        // 1.adim kullanmak istedigimiz dropdown menuyu locate edip, bir webelement'e kaydedelim

        // 2.adim Select class'indaki hazir method'lari kullanmak icin obje olusturalim

        // 3.adim, istenen gorev icin uygun hazir method'u kullanin


        WebElement tarih = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));

        Select selectgun = new Select(tarih);

        selectgun.selectByIndex(5);

      Thread.sleep(2000);


    //2. Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin


        WebElement ay = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));

        Select selectay = new Select(ay);

        selectay.selectByValue("nisan");

      Thread.sleep(2000);


    //3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin

        WebElement yil = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));

        Select selectyil = new Select(yil);

        selectyil.selectByVisibleText("1990");

      Thread.sleep(2000);


    //4. Secilen değerleri konsolda yazdirin
      System.out.println(selectgun.getFirstSelectedOption().getText());
      System.out.println(selectay.getFirstSelectedOption().getText());
      System.out.println(selectyil.getFirstSelectedOption().getText());

      Thread.sleep(2000);

    //5. Ay dropdown menüdeki tum değerleri(value) yazdırın

         List <WebElement> aydrpdwn = selectay.getOptions();

        System.out.println(ReusableMethods.stringListeyeCevir(aydrpdwn));

      //6. Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedsize = 13;

        int actualdsize =  aydrpdwn.size();

        Assertions.assertEquals(expectedsize,actualdsize);


}

}