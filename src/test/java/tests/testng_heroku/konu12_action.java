package tests.testng_heroku;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

public class konu12_action extends TestBase_Each {

    @Test
    public void test01() {
        //1- https://testotomasyonu.com/click sitesine gidin

        driver.get("https://testotomasyonu.com/click");

        ReusableMethods.bekle(1);


        //2- “DGI Drones” uzerinde sag click yapin


        // sag click yapabilmek icin actions class'ina ihtiyacimiz var
        // 1.adim actions objesi olustur

        Actions actions = new Actions(driver);

        // 2.adim uzerinde calisacagimiz WebElement'i locate edin

        WebElement dgi = driver.findElement(By.id("pic2_thumb"));


        // 3.adim istenen actions islevini kullanin
        //        sonuna perform() demeyi unutmayin

        actions.contextClick(dgi).perform();

        ReusableMethods.bekle(1);


        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.


        String actualyazi = driver.switchTo().alert().getText();
        String expectedyazi = "Tebrikler!... Sağ click yaptınız.";

        Assertions.assertEquals(expectedyazi, actualyazi);

        //4- Tamam diyerek alert’i kapatin

        driver.switchTo().alert().accept();

        ReusableMethods.bekle(2);

    }

    @Test
    public void test02() {

        //1- https://testotomasyonu.com/droppable adresine gidelim

        driver.get("https://testotomasyonu.com/droppable");
        ReusableMethods.bekle(1);


        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim

        WebElement accept = driver.findElement(By.xpath("//*[@id='draggable2']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable2']"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(accept, drop).perform();

        ReusableMethods.bekle(1);


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement text = driver.findElement(By.xpath("//*[text()='Dropped!']"));

        String acttext = text.getText();

        String exptext = "Dropped!";

        Assertions.assertEquals(exptext, acttext);


        //4- Sayfayi yenileyin

        driver.navigate().refresh();
        ReusableMethods.bekle(1);

    }

    @Test
    public void test03() {

        //1- https://www.testotomasyonu.com/ adresine gidin

        driver.get("https://www.testotomasyonu.com/");

        ReusableMethods.bekle(1);


        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin

        WebElement kids = driver.findElement(By.xpath("(//*[text()='Kids Wear'])[3]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(kids).perform();

        ReusableMethods.bekle(1);

        //3- “Boys” linkine basin

        WebElement boys = driver.findElement(By.xpath(" //*[text()='Boys']"));

        boys.click();

        ReusableMethods.bekle(1);

        //4- Acilan sayfadaki ilk urunu tiklayin

        WebElement ilkurun = driver.findElement(By.xpath("//*[@class='lazy']"));

        ilkurun.click();
        ReusableMethods.bekle(1);


        //4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin

        WebElement urunbir = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String actualilkurunismi = urunbir.getText();

        String expurunismi = "Boys Shirt White Color";

        Assertions.assertEquals(expurunismi, actualilkurunismi);

    }


    @Test
    public void test04() {

        //1- https://www.testotomasyonu.com sayfasina gidelim

        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);

        //2- Arama kutusuna actions method’larini kullanarak
        //   “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin

        WebElement search = driver.findElement(By.id("global-search"));


        ReusableMethods.bekle(2);
        Actions actions = new Actions(driver);

        actions.click(search).
                sendKeys("DELL Core I3").
                sendKeys(Keys.ENTER).perform();

        ReusableMethods.bekle(2);

        //3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin

        WebElement nameproduct = driver.findElement(By.xpath("//*[@*='prod-title mb-3 ']"));

        String actualyazi = nameproduct.getText();

        String expecteyazi = "DELL Core I3";

        Assertions.assertTrue(actualyazi.contains(expecteyazi));

    }

    @Test
    public void test05() {

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);
        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//*[@class='menu-icon-text'])[1]"))
                .click();
        ReusableMethods.bekle(1);

        //3- Sign Up linkine basalim

        driver.findElement(By.xpath("//*[text()=' Sign Up']"))
                .click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim

        WebElement name = driver.findElement(By.xpath("//*[@id='firstName']"));

        Actions actions = new Actions(driver);

        ReusableMethods.bekle(1);

        // signUp butonuna click yapalim


        actions.click(name).
                sendKeys("aki").
                sendKeys(Keys.TAB).
                sendKeys("kaurasmaki").
                sendKeys(Keys.TAB).
                sendKeys("aki@kedi.com").
                sendKeys(Keys.TAB).
                sendKeys("akicaner").
                sendKeys(Keys.TAB).
                sendKeys("akicaner").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        ReusableMethods.bekle(2);


        //5- Kaydin olusturuldugunu test edin
        //  kayit icin alanlari doldurup sign up butonuna basinca bizi sign in ekranina yonlendirdi
        // kaydin olusturuldugunu anlamak icin giris yapabiliriz

        ReusableMethods.bekle(1);
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement signInButonu = driver.findElement(By.id("submitlogin"));

        emailKutusu.sendKeys("aki@kedi.com");
        passwordKutusu.sendKeys("akicaner");
        signInButonu.click();
        ReusableMethods.bekle(1);

        WebElement mypro = driver.findElement(By.xpath("//*[text()='My Profile']"));

        Assertions.assertTrue(mypro.isDisplayed());

    }

    @Test
    public void test06() {

        Faker faker = new Faker();

        System.out.println(faker.hitchhikersGuideToTheGalaxy().marvinQuote());

        System.out.println(faker.name().fullName());
        System.out.println(faker.internet().emailAddress());


    }

    @Test
    public void test07() {


        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);
        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//*[@class='menu-icon-text'])[1]"))
                .click();
        ReusableMethods.bekle(1);

        //3- Sign Up linkine basalim

        driver.findElement(By.xpath("//*[text()=' Sign Up']"))
                .click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim

        WebElement name = driver.findElement(By.xpath("//*[@id='firstName']"));

        Actions actions = new Actions(driver);

        ReusableMethods.bekle(1);

        // signUp butonuna click yapalim

         Faker faker = new Faker();

          String pass = faker.internet().password();
          String email= faker.internet().emailAddress();

        actions.click(name).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(pass).
                sendKeys(Keys.TAB).
                sendKeys(pass).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        ReusableMethods.bekle(2);


        //5- Kaydin olusturuldugunu test edin
        //  kayit icin alanlari doldurup sign up butonuna basinca bizi sign in ekranina yonlendirdi
        // kaydin olusturuldugunu anlamak icin giris yapabiliriz

        ReusableMethods.bekle(1);
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement signInButonu = driver.findElement(By.id("submitlogin"));

        emailKutusu.sendKeys(email);
        passwordKutusu.sendKeys(pass);
        signInButonu.click();
        ReusableMethods.bekle(1);

        WebElement mypro = driver.findElement(By.xpath("//*[text()='My Profile']"));

        Assertions.assertTrue(mypro.isDisplayed());


    }
}