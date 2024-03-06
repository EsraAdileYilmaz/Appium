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
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));

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
        }//1000 yazdirdik.1000 zloty'i tl ye cevirdik

        //5- cevrilen tutar screenShot olarak kaydedilir
        File paraSonucu =driver.getScreenshotAs(OutputType.FILE);//cevirdigimiz para sonucu file'in icine screenShot olarak kaydoldu
        FileUtils.copyFile(paraSonucu,new File("zlotyToTry.jpg"));
        //cekilen ss'in kopya bir file'ini olusturduk.Screen shot olusturup dosya yolu ile projenin icine attik.
        //Ancak uzantisinin .jpg olmasi ZORUNLUDUR.
        // File'in icine kaydolan degerler FileUtils'den alinir.


        //6- Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        String cevrilenParaSonucu=allCurrencyAppPage.resultBox.getText();

        //7- kullaniciya sms olarak bildirilir
        driver.sendSMS("55555555555","Suan icin cevirisini yaptiginiz kur sonucu: "+cevrilenParaSonucu);





    }
}
    git add README.md
        git commit -m "first commit"
        git branch -M main
        git remote add origin git@github.com:EsraAdileYilmaz/Appium.git
        git push -u origin main