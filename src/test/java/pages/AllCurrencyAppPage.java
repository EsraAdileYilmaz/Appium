package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AllCurrencyAppPage {
    public AllCurrencyAppPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
        //bunu WebDriver'lar uzerinden yaptigi icin WebDriver'a cast ediyoruz
        //bu kodla elementler WebElemente donusuyor.cunku locate leri gerceklestirmek icin bu castingi yapmamiz gerekiyor
        /* Bizler almis oldugumuz locate'leri testlerimizin icerisinde kullanmak istedigimiz POM a gore bu sayfaya kaydedilen locateleri
        kullaniriz. Bu locateler test esnasinda olusturulan obje uzerinden cagirildiginda eger WebDriver ozelligini kullanamazsa
        o locate'ler islemlerini yerine getirezler. Bunun icin bu sayfadaki tanimlanan driverimizin WebDriver castingi yapilarak alinan locateleri
        bu WebDriver'in api'larini kullanan appium artik islemleri yapabilir hale gelir!!!!!
         */
    }

    @FindBy(xpath = "//*[@text='CURRENCY CONVERTER']")
    public WebElement currentText;

    @FindBy(id="com.smartwho.SmartAllCurrencyConverter:id/b1")
    public WebElement oneButton;//1 numaranin locate'i

    @FindBy(id="com.smartwho.SmartAllCurrencyConverter:id/b0")
    public WebElement zeroButton;//O numaranin locate'i

    @FindBy(id="com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB")
    public WebElement resultBox;


}
