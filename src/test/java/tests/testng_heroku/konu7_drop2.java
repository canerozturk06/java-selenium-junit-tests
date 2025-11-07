package tests.testng_heroku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.List;

public class konu7_drop2 extends TestBase_Each {



    //https://the-internet.herokuapp.com/dropdown adresine gidin.

    @Test
    public void test1(){

        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement droplist = driver.findElement(By.xpath("//*[@*='dropdown']"));
        Select selectdrop = new Select(droplist);

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        selectdrop.selectByIndex(1);

        System.out.println(selectdrop.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        selectdrop.selectByValue("2");

        System.out.println(selectdrop.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        selectdrop.selectByVisibleText("Option 1");


        System.out.println(selectdrop.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın

      List<WebElement> allopt = selectdrop.getOptions();

        System.out.println(ReusableMethods.stringListeyeCevir(allopt));



        //5. Dropdown’un boyutunun 4 olduğunu test edin


          int actualsize = allopt.size();

          int expesize = 3;

        Assertions.assertEquals(expesize,actualsize);

    }















}

