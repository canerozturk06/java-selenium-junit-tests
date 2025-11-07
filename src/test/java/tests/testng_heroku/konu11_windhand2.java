package tests.testng_heroku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class konu11_windhand2 extends TestBase_Each {

  @Test
    public void test(){

    //● https://the-internet.herokuapp.com/windows adresine gidin.

    driver.get("https://the-internet.herokuapp.com/windows");


    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.


     WebElement text1=  driver.findElement(By.xpath("//*[text()='Opening a new window']"));


      System.out.println(text1.getText());

      String acttext1 = text1.getText();


      String expectedtext = "Opening a new window";

      Assertions.assertEquals(expectedtext,acttext1);


      //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

      String expectedtitle = "The Internet";

      String actualtitle = driver.getTitle();

      Assertions.assertEquals(expectedtitle,actualtitle);


    //● Click Here butonuna basın.

      driver.findElement(By.xpath("//*[@*='_blank']")).click();

      ReusableMethods.bekle(2);


    //● Acilan yeni window'un sayfa başlığının (title) “New Window” oldugunu test edin
      // Yeni window'da test yapabilmek icin, once driver'i yeni window'a gecirelim


      ReusableMethods.switchToWindowByTitle(driver,"New Window");

      String expectedYeniSayfaTitle = "New Window";

      String actualYeniSayfaTitle = driver.getTitle();

      Assertions.assertEquals(expectedYeniSayfaTitle,actualYeniSayfaTitle);



    //● Sayfadaki textin “New Window” olduğunu doğrulayın.

      String actualYeniSayfaYazi = driver.findElement(By.tagName("h3")).getText();

     String expectedtext2 = "New Window";

     Assertions.assertEquals(expectedtext2,actualYeniSayfaYazi);



    //● Bir önceki pencereye geri döndükten sonra
    //  sayfa başlığının “The Internet” olduğunu test edin

       ReusableMethods.switchToWindowByTitle(driver, "The Internet");

       String actualbaslik = driver.getTitle();
       String expectedbaslik = "The Internet";
       Assertions.assertEquals(expectedbaslik,actualbaslik);


}
}