package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class ReusableMethods {

    static TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
    public static void tiklamaMethodu(int xKoordinati,int yKoordinati,int beklemeSuresi) throws InterruptedException {

        //cep telefonunda herhangi bir yere tiklamak istedigimizde bu methodu kullanacagiz
        action.press(PointOption.point(xKoordinati,yKoordinati))
                .release()
                .perform();
        Thread.sleep(beklemeSuresi);//sayfalar arasinda rahat tiklama yapabilmek icin her tiklama arasinda beklettik.

    }

    public static void screenScrollMethod(int pressXkoordinati,int pressYkoordinati,int wait,
                                          int moveXkoordinati,int moveYkoordinati,int bekleme) throws InterruptedException {
        //Ekrani bir ekran boyutu kadar kaydirma methodu

        action.press(PointOption.point(pressXkoordinati,pressYkoordinati))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait))) //kaydirma isleminin hizini belirler
                .moveTo(PointOption.point(moveXkoordinati,moveYkoordinati))
                .release()
                .perform();
        Thread.sleep(bekleme);

    }

    public static void ekranAssagiKaydirma(int waitAction){

        action.press(PointOption.point(500,1500))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitAction)))
                .moveTo(PointOption.point(500,285))
                .release()
                .perform();
    }

    public static void ekranYukariKaydirma(int waitAction){

        action.press(PointOption.point(500,285))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitAction)))
                .moveTo(PointOption.point(500,1500))
                .release()
                .perform();
    }

    public static void scrollWithUiScrollable(String elementText){
        AndroidDriver driver=(AndroidDriver)Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"))");//bu satirda aranan element bulunur
        driver.findElementByXPath("//*[@text='"+elementText+"']").click();//bu satirda bulunan elemente tiklanir
        //bu methodla bir elementin text'i varsa bulup tiklama islemi yapilir.

    }


}
