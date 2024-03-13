package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPage {

    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
        //bunu WebDriver'lar uzerinden yaptigi icin WebDriver'a cast ediyoruz
        //bu kodla elementler WebElemente donusuyor.cunku locate leri gerceklestirmek icin bu castingi yapmamiz gerekiyor
        /* Bizler almis oldugumuz locate'leri testlerimizin icerisinde kullanmak istedigimiz POM a gore bu sayfaya kaydedilen locateleri
        kullaniriz. Bu locateler test esnasinda olusturulan obje uzerinden cagirildiginda eger WebDriver ozelligini kullanamazsa
        o locate'ler islemlerini yerine getirezler. Bunun icin bu sayfadaki tanimlanan driverimizin WebDriver castingi yapilarak alinan locateleri
        bu WebDriver'in api'larini kullanan appium artik islemleri yapabilir hale gelir!!!!!
         */
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement misafirButonu;

    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWayButton;

    @FindBy(xpath = "//*[@text='Return']")
    public WebElement returnYaziElementi;

    @FindBy(xpath = "//*[@text='From:']")
    public WebElement fromYazisiElementi;

    @FindBy(xpath = "//*[@content-desc='Clear All']")
    public WebElement carpiIsaretiElementi;

    @FindBy(xpath = "(//*[@class='android.view.View'])[4]")
    public WebElement aramaKutusuElementi;

    @FindBy(xpath = "(//*[@class='android.view.View'])[8]")
    public WebElement aramaKutusundaIlkBulunanElement;

    @FindBy(xpath = "(//*[@class='android.widget.Button'])[8]")
    public WebElement chooseButton;
    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButton2;

    @FindBy(xpath = "(//*[@text='Anywhere'])[2]")
    public WebElement anywhereButton;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[31]")
    public WebElement anyTimeButton;

    @FindBy(xpath = "//*[@text='Set date']")
    public WebElement setDateElementi;

    @FindBy(xpath = "(//*[@text='Search'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@text='Cheapest']")
    public WebElement cheapestYaziElementi;

    @FindBy(xpath = "//*[@text='Stops']")
    public WebElement stopsButton;

    @FindBy(xpath = "//*[@text='Nonstop']")
    public WebElement nonstopButton;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement sonucFiyatElementi;

    /* Hocanin locate'i
    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement sonucFiyat;

     */


}
