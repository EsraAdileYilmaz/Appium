package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class KiwiApp {

    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    //Driver.getAndroidDriver() WebElement donduruyor,biz orayi AndroidDriver<AndroidElement> atayinca elementler AndroidElement'e donusuyor
    //Driver class'indaki capabilities'leri buradaki AndroidDriver<AndroidElement> driver'a atadik.Android'in tum methodlarini rahat kullanmak icin yaptik
    //Ayrica URL baglantisi ile rahatlikla server'a baglaniyor
     /* Hali hazirda testlerimizde kullanacak oldugumuz driver i Driver clasinda olsuturdugumuz icin,
     olusturulan driveri bu scope icerisinde Android Element olarak dondurulmesini istedigimizden,
     driver clasindaki static methodumuzu buradaki bos driver'a atama yaparak
     bu sayfada kullanacak oldugumuz driver'a bir tanimlama atamasi yapmis oluruz.
    */
    //AppiumDriver<MobileElement> driver=Driver.getAndroidDriver();//IOS ve Android icin
    KiwiPage page=new KiwiPage();//bu obje sayesinde tum locate'lere ulasabiliriz



    @Test
    public void kiwiAppTest() throws InterruptedException {

        //kiwi'nin=>appPackage","com.skypicker.main"
        //"appActivity","com.kiwi.android.feature.splash.impl.ui.SplashActivity"

        //1- uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
        //"com.skypicker.main" appPackage'i bu olan uygulama yuklendimi?

        //2- uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(page.misafirButonu.isDisplayed());//page objesinden gelen misafirButonu gorunuyor mu?

        //3- misafir olarak devam et'e tiklanir
        page.misafirButonu.click();
        Thread.sleep(1000);


        //4- ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        //(Continue,Continue,Explore the app) butonlari ayni yerde oldugu icin ayni koordinatlari 3'u icinde kullanabiliriz
        //toplamda 3 kez tiklama islemi yapacagiz
        for (int i = 0; i <3 ; i++) {
            ReusableMethods.tiklamaMethodu(531,1692,1000);
        }
        Thread.sleep(3000);


        //5- Trip type,one way olarak secilir
        ReusableMethods.tiklamaMethodu(195,617,1000);//return icin koordinatlarla calismadi
        //page.returnYaziElementi.click();
        page.oneWayButton.click();


        //6- kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        //ReusableMethods.tiklamaMethodu(340,653,500);//sehire tikladik
        page.fromYazisiElementi.click();
        //ReusableMethods.tiklamaMethodu(1023,135,500);// x isaretine tikladik
        page.carpiIsaretiElementi.click();



        //7- kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        if (!driver.isKeyboardShown()){//klavyem gorunmuyorsa arama kutusuna istanbul gonder
            page.aramaKutusuElementi.sendKeys("istanbul");
        }else{//klavyem gorunuyorsa klavyem ile arama kutusuna istanbul yaz
            driver.getKeyboard().pressKey("istanbul");//suan acilan sayfaya klavye ile yazmis oluyoruz
        }//her halukarda istanbul gondermek icin bunu yaptik
        Thread.sleep(2000);
        //page.aramaKutusundaIlkBulunanElement.click();
        ReusableMethods.tiklamaMethodu(369,292,500);//gelen ilk element olan istanbul'a tikladik
        page.chooseButton.click();//choose butona tiklayip ana sayfaya geri gelicek


        //8- varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        Thread.sleep(1000);
        page.anywhereButton.click();
        driver.getKeyboard().pressKey("Antalya");//klavye ile yaziyoruz
        //ReusableMethods.tiklamaMethodu(482,292,500);//nice ilk element istanbul ile ayni koordinatlara sahip
        Thread.sleep(1000);
        page.aramaKutusundaIlkBulunanElement.click();//koordinatlarla calismadigi icin aramakutusuna yazilan ilk element locate'i ile calisti
        page.chooseButton.click();
        Thread.sleep(2000);


        //9- gidis tarihi mart ayinin 20 si olarak secilir ve set date e tiklanir
        page.anyTimeButton.click();
        Thread.sleep(2000);
        ReusableMethods.tiklamaMethodu(560,1140,500);//20 mart tarihinin x ve y koordinatlarini alarak tiklama yaptik
        page.setDateElementi.click();
        /*
         Yukardaki islemler koordinat tiklama ile yapilirsa=
         ResuableMethods.koordinatTiklamaMethodu(537,1048,1000);
         ResuableMethods.koordinatTiklamaMethodu(541,1140,1000);
         ResuableMethods.koordinatTiklamaMethodu(716,1721,1000);

         */
        
        //10- search butonuna tiklanir
        page.searchButton.click();
        Thread.sleep(2000);
        // ResuableMethods.koordinatTiklamaMethodu(541,1205,3000); search butonuna tiklama

        //11- en  ucuz ve aktarmasiz filtrelemeleri yapilir
        //En ucuzu bulmak icin=> once best tiklanir,altindan Cheapest tiklanir
        //Aktarmasiz olani bulmak icin=> hemen yanindaki Stops butonuna tiklanir,cikan ekrandan Nonstop tiklanir

        ReusableMethods.tiklamaMethodu(251,251,2000);//Best'in koordinatlari ile tikladik
        page.cheapestYaziElementi.click();//cheapest a tikladik
        Thread.sleep(2000);
        page.stopsButton.click();//stops'a tikladik
        page.nonstopButton.click();//nonstop'a tikladik.boylece aktarmasiz secmis olduk
        Thread.sleep(3000);
        /*
        Yukardaki islemler koordinat tiklama ile yapilirsa=
        ResuableMethods.koordinatTiklamaMethodu(252,252,1000);
        ResuableMethods.koordinatTiklamaMethodu(563,584,2000);
        ResuableMethods.koordinatTiklamaMethodu(519,256,1000);
        ResuableMethods.koordinatTiklamaMethodu(511,1458,3000);
         */


        //12- gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String biletFiyati=page.sonucFiyatElementi.getText();//burda bulunan en ucuz ve aktarmasiz bilet fiyatinin yazisini kaydettik
        driver.sendSMS("76543219","Kiwi app uygulamasindaki aramis oldugunuz biletin fiyati= "+biletFiyati);



    }
}
