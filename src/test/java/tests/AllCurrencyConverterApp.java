package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyAppPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class AllCurrencyConverterApp {


    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    AllCurrencyAppPage allCurrencyAppPage=new AllCurrencyAppPage();
    @Test
    public void allCurrencyTest() throws InterruptedException, IOException {

        //AllCurrency=>"appPackage","com.smartwho.SmartAllCurrencyConverter"
        //"appActivity","com.smartwho.SmartAllCurrencyConverter.CurrencyConverter"


        //1- all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));//appPackage'ye sahip uygulama yuklendi mi?

        //2- uygulamanin acildigi dogrulanir
        Assert.assertTrue(allCurrencyAppPage.currentText.isDisplayed());

        //3- cevirmek istedigimiz para birimi zloty olarak secilir
        //oncelikle ilk bayragin koordinatlari ile ustune tiklayarak menuyu acmamiz gerekiyor
        ReusableMethods.tiklamaMethodu(363,323,500);//ilk bayraga tikladik
        //PLN'yi bulmak icin sayfa kaydirma isini yapiyoruz
        ReusableMethods.scrollWithUiScrollable("PLN");//PLN=Polish zloty para birimi
        //bu methodun icine ilgili String bir deger girilmesi yeterlidir.


        //4- cevirelecek olan para birimi Tl olarak secilir
        //Oncelikle alttaki bayragin koordinatlari ile ustune tiklayarak menuyu acmamiz gerekiyor
        ReusableMethods.tiklamaMethodu(363,472,500);//alttaki bayraga tikladik
        //Sonra aranan para biriminin(TRY'nin) text'ini yazip scrollWithUiScrollable() methodu ile aratip tiklaticaz
        ReusableMethods.scrollWithUiScrollable("TRY");

        allCurrencyAppPage.oneButton.click();
        for (int i = 0; i <3 ; i++) {
           allCurrencyAppPage.zeroButton.click();
        }//cevirmek istedigimiz miktari=1000 yazdirdik.1000 zloty'i tl ye cevirdik

        /*
        ReusableMethods.scrollWithUiScrollable("1");
        ReusableMethods.scrollWithUiScrollable("5");
        ReusableMethods.scrollWithUiScrollable("3");
        ReusableMethods.scrollWithUiScrollable("8");//1538
        */


        //5- cevrilen tutar screenShot olarak kaydedilir
       /* Screen Shot almanin 1.yolu=>
          File paraSonucu =driver.getScreenshotAs(OutputType.FILE);//cevirdigimiz para sonucu file'in icine screenShot olarak kaydoldu
          FileUtils.copyFile(paraSonucu,new File("ExchangeZlotyToTry.jpg"));//burda kopyasini olusturduk
           */
        //cekilen ss'in kopya bir file'ini olusturduk.Screen shot olusturup dosya yolu ile projenin icine attik.
        //Ancak uzantisinin .jpg olmasi ZORUNLUDUR.
        // File'in icine kaydolan degerler FileUtils'den alinir.FileUtils tum file dosyalarini icinde barindirir

        ReusableMethods.getScreenshot("Exchange");//Screen Shot almanin 2.yolu
       // driver.startRecordingScreen();//buda video'ya almak icin kullanilabilir.

        //6- Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
         String cevrilenParaSonucu=allCurrencyAppPage.resultBox.getText();
        /*
        AndroidElement exchangeResult= driver.findElementById("com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB");
        String sonucText=exchangeResult.getText();
         */


        //7- kullaniciya sms olarak bildirilir
          driver.sendSMS("55555555555","Suan icin cevirisini yaptiginiz kur sonucu: "+cevrilenParaSonucu);//sadece sanal cihazlarda calisir





    }
}
    



