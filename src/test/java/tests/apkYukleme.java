package tests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class apkYukleme {

    AndroidDriver<AndroidElement> driver;// Androidlerde calisan driver.

    @Test
    public void apkYukleme() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();//testi olusturmadan once hangi cihazla yapacaksak onu ve onun ozelliklerini girmemiz lazim
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");// Cep telefonumun adi=>MobileCapabilityType.DEVICE_NAME,"Pixel 2"
        //capabilities.setCapability("deviceName","Pixel 2");yukardaki ile ayni
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");//Android versionum=>11.0
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");//Platform adim=>Android
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/familleyilmaz/IdeaProjects/Appium_127/Apps/all-currency-converter-3-9-0 (1).apk");//uygulamayi cep telefonuna yukleme isini biz burda yapiyoruz.Apk yukleme
        // UiAutomator2, otomasyon ismi(AUTOMATION_NAME) sadece android 6 dan yuksek olan android sistemleri icin calisir
        // UiAutomator,otomasyon ismi(AUTOMATION_NAME) sadece android 6 ve 6 dan dusuk olan android sistemleri icin calisir
        // capabilities'ler cihazin olmazsa olmazlaridir

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);//Bu kisimda URL'imizi kendimiz olusturuyoruz
        //ve burada cep telefonu ile eslesme yapiliyor.Bu kodla intellij ile server arasinda baglanti kurduk.
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }






}
