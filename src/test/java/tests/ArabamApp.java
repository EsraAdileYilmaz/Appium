package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ArabamApp {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void arabamSetUp() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();//testi olusturmadan once hangi cihazla yapacaksak onu ve onun ozelliklerini girmemiz lazim
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");// Cep telefonumun adi=>MobileCapabilityType.DEVICE_NAME,"Pixel 2"
        //capabilities.setCapability("deviceName","Pixel 2");yukardaki ile ayni
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");//Android versionum=>11.0
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");//Platform adim=>Android
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.dogan.arabam");//bu satirda uygulamayi baslatiyoruz,aciyoruz ve bunu uygulamayi telefona id'si ile tanimliyarak yapiyoruz.
        //Hangi uygulama uzerinde calismak istiyorsak o uygulamaya ait appPackage degeri yani uygulamanin kimlik bilgisi(bundleId'si)
        //Bunuda apkinfo icinden uygulamayi bulup tikliyoruz ve logonun hemen altindaki bundleId'den aliyoruz
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");//bu satir yuklenen uygulamanin hangi sayfasinin acilmasi gerektigini belirliyor
        //AppPackagede belirlenen uygulamanin hangi sayfasindan baslanacak oldugunu belirlemek icin girilen activity degeri.
        // Bunuda yine Apk info icinden uygulamayi bulup tikliyoruz,sayfayi asagi kaydiriyoruz
        // ve altta Activities basligina tikliyoruz.Cikan listede hangi sayfadan baslamak istiyorsak
        // onun com. ile baslayan linkini kopyaliyoruz.koplayalamak icin uzerine tiklamak yetiyor.
        // Ana sayfa icin genellikle HomeActivity veya MainActivity aranir.

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);//Bu kisimda URL'imizi kendimiz olusturuyoruz
        //ve burada cep telefonu ile eslesme yapiliyor.Bu kodla intellij ile server arasinda baglanti kurduk.
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void arabamAppTest() throws InterruptedException {

        //driver.activateApp("com.dogan.arabam");//uygulamayi baslatmak icin kullanilabilir.ancak appPackage ve appActivity ikilisi tercih edilir

        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));//ilgili uygulama cihaza yuklendi mi?

        // uygulaminin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed());
        //Acilan sayfa uzerinden Inspector'la alinan bir locate'le sayfanin acildigi dogrulanir.burada ana sayfadaki arabamcom logosunun locate'ini aldik

        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();

        // kategori olarak otomobil secilir
        //driver.findElementByXPath("//*[@text='Otomobil']").click();//tiklama yapmak icin 1.yol
        TouchAction action=new TouchAction<>(driver);//hangi cihaz uzerinde calisacaksak o cihaza ait driver
        action.press(PointOption.point(508,505)).release().perform();//tiklama yapmak icin 2.yol

        // arac olarak Volkswagen secilir
        Thread.sleep(1000);

        //ASAGIDAN YUKARIYA DOGRU KAYDIRMAK ICIN=>X sabit y degisken 1.yol
        /*action
                .press(PointOption.point(508,1538))//press kismi ekranda kaydirma islemi icin, tiklama yapacagimiz ilk noktanin koordinatlarini icerir
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(75)))//baslangic noktasi ile bitis noktasi arasindaki gecen suredir
                //Eger wait suresi UZUN olursa gidilen yol mesafesi daha AZ olacaktir
                //Eger wait suresi KISA olursa gidilen yol mesafesi daha FAZLA olacaktir.
                .moveTo(PointOption.point(508,398))//baslangic noktasindan baslayarak gidilecek bitis noktasinin koordinatlarini ifade eder
                .release()//parmagimizi tipki gunluk kullanimdaki gibi ekrandan kaldirma ,serbest birakma eylemidir.tiklama islemi yaptiktan sonra ekrendan parmagimizi kaldirma islemi
                .perform();//verilen action gorevlerini yerine getirmesi icin actiona verilen emirdir!
        */
        for (int i = 0; i <5 ; i++) {//ASAGIDAN YUKARIYA DOGRU KAYDIRMAK ICIN=>X sabit y degisken 2.yol
            action
                    .press(PointOption.point(508,1538))//press kismi ekranda kaydirma islemi icin, tiklama yapacagimiz ilk noktanin koordinatlarini icerir
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(750)))//baslangic noktasi ile bitis noktasi arasindaki gecen suredir
                    //Eger wait suresi UZUN olursa gidilen yol mesafesi daha AZ olacaktir
                    //Eger wait suresi KISA olursa gidilen yol mesafesi daha FAZLA olacaktir.
                    .moveTo(PointOption.point(508,398))//baslangic noktasindan baslayarak gidilecek bitis noktasinin koordinatlarini ifade eder
                    .release()//parmagimizi tipki gunluk kullanimdaki gibi ekrandan kaldirma ,serbest birakma eylemidir.tiklama islemi yaptiktan sonra ekrendan parmagimizi kaldirma islemi
                    .perform();
            Thread.sleep(500);
        }//bu yontem yavas yavas insin diye.yani 5 defada en alta insin diye

        Thread.sleep(1500);
        //YUKARDAN ASAGIYA DOGRU KADIRMAK ICIN=>X degisken y sabit
        /*
        action.press(PointOption.point(508,398))//press kismi ekranda kaydirma islemi icin, tiklama yapacagimiz ilk noktanin koordinatlarini icerir
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(75)))//baslangic noktasi ile bitis noktasi arasindaki gecen suredir
                //Eger wait suresi UZUN olursa gidilen yol mesafesi daha AZ olacaktir
                //Eger wait suresi KISA olursa gidilen yol mesafesi daha FAZLA olacaktir.
                .moveTo(PointOption.point(508,1538))//baslangic noktasindan baslayarak gidilecek bitis noktasinin koordinatlarini ifade eder
                .release()//parmagimizi tipki gunluk kullanimdaki gibi ekrandan kaldirma ,serbest birakma eylemidir
                .perform();//verilen action gorevlerini yerine getirmesi icin actiona verilen emirdir!
        */


        action.press(PointOption.point(288,1153))
                .release()
                .perform();//Inspector uzerinden x ve y koordinatlari ile Volkswagen'in locate aldik
        //driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // arac markasi olarak passat secilir
        driver.findElementByXPath("//*[@text='Passat']").click();

        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        // Paket secimi yapilir
        driver.findElementByXPath("//*[@text='Highline']").click();
        /*
        action
                    .press(PointOption.point(500,700))
                    .release()
                    .perform();//2.yol locate alma
         */
        Thread.sleep(1000);

        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        driver.findElementByXPath("//*[@text='Sıralama']").click();
        Thread.sleep(500);
        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();


        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
        Thread.sleep(1000);
        String aracFiyati=driver.findElementByXPath("(//*[@resource-id='com.dogan.arabam:id/tvPrice'])[1]").getText();//fiyat bilgisini almak istiyorum
        System.out.println(aracFiyati);//730.000 TL
        aracFiyati=aracFiyati.replaceAll("\\D","");//"730000" string yani digit olmayan herseyi sil
        Assert.assertTrue(Integer.parseInt(aracFiyati)>500000);


        /* 2.Cozum yolu
          AndroidElement enUcuzAracFiyatiElementi=driver.findElementByXPath("(//*[@resource-id='com.dogan.arabam:id/tvPrice'])[1]");
          String aracinSonFiyati=enUcuzAracFiyatiElementi.getText();
          System.out.println(aracinSonFiyati); // 670.000 TL
          aracinSonFiyati=aracinSonFiyati.replaceAll("\\D","");
          System.out.println(aracinSonFiyati);
           Assert.assertTrue(Integer.parseInt(aracinSonFiyati)>500000);
         */


    }
}


