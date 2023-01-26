package screen;

import core.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class ScreenMenuSettings extends ScreenBase {
    public ScreenMenuSettings(AppiumDriver<RemoteWebElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    private static WebDriverWait wait;
    private static AppiumDriver driver;

    @AndroidFindBy(id="com.google.android.gm:id/subject")
    @iOSFindBy(accessibility="subjectField")
    private RemoteWebElement subjectEmail;
    @AndroidFindBy(id="com.google.android.gm:id/peoplekit_chip")
    @iOSFindBy(accessibility="toField")
    private RemoteWebElement fildEmailTo;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='I love noteit']")
    @iOSFindBy(xpath="//XCUIElementTypeStaticText[@name=\"I love noteit\"]")
    private RemoteWebElement iLoveNoteIt;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='⭑⭑⭑⭑⭑']")
    @iOSFindBy(accessibility="⭑⭑⭑⭑⭑")
    private RemoteWebElement fiveStars;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='cancel']")
    @iOSFindBy(accessibility="Cancel")
    private RemoteWebElement cancelRate;
    @AndroidFindBy(id="me.bukovitz.noteit:id/message")
    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"noteit\"]/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    private RemoteWebElement notNow;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='follow the IG']")
    @iOSFindBy(accessibility="icon_instagram")
    private RemoteWebElement followIG;

    @iOSFindBy(accessibility="Instagram Instagram")
    private RemoteWebElement noteitProfileInstagram;
    @AndroidFindBy(id="com.sec.android.app.sbrowser:id/location_bar_edit_text")
    private RemoteWebElement androidInstagram;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
    @iOSFindBy(accessibility="icon_settings")
    private RemoteWebElement settings;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='I need help']")
    @iOSFindBy(accessibility="I need help")
    private RemoteWebElement iNeedHelp;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
    @iOSFindBy(accessibility="icon_lock")
    private RemoteWebElement privacyPolicy;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
    @iOSFindBy(accessibility="icon_add_circle")
    private RemoteWebElement howToAddNoteitAsAWidget;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='what should i draw?']")
    private RemoteWebElement whatShouldIDraw;
    @AndroidFindBy(id="me.bukovitz.noteit:id/txt_title")
    private RemoteWebElement whatShouldIDrawTitleTiktokPage;


    public void notNowClick() throws InterruptedException, MalformedURLException {
        scroll(0.8,0.9);
    }
    public void cancelRateClick() throws InterruptedException {
        cancelRate.click();

    }
    public void iLoveNoteItClick() throws InterruptedException {
        iLoveNoteIt.click();
        System.out.println("Cliquei no I love noteit");
    }

    public String getTextILoveNoteIt(){
        return iLoveNoteIt.getText();
    }
    public void fiveStarsClick() throws InterruptedException {
        fiveStars.click();
    }
    public void iNeedHelpClick() throws InterruptedException {
        iNeedHelp.click();

    }
    public String whatShouldIDrawGetText(){
        return whatShouldIDrawTitleTiktokPage.getText();
    }
    public void whatShouldIDrawClick() throws InterruptedException {
        whatShouldIDraw.click();

    }

    public void followIGClick() throws InterruptedException, MalformedURLException {

        followIG.click();
    }
    public String noteitProfileInstagramGetText() throws InterruptedException, MalformedURLException {
        return noteitProfileInstagram.getText();

    }
    public String instagramAndroidGetText() throws InterruptedException, MalformedURLException {
        return androidInstagram.getText();

    }
    //Validations
    public void validationNoteitProfileInstagramGetText() throws InterruptedException, MalformedURLException {
//        waitUntilText(noteitProfileInstagram, noteitProfileInstagramGetText());
       try {
           Assert.assertFalse("Passed", followIG.isDisplayed());
       }catch (Exception e){}

    }
    public void validationNoteitProfileInstagramGetTextAndroid() throws InterruptedException, MalformedURLException {
        waitFiveSeconds();

        Assert.assertEquals("\u200Ewww.instagram.com",instagramAndroidGetText());

    }


    public void validationWhatShouldIDrawClickAndroid() throws InterruptedException {


        Assert.assertEquals("what should i draw?",whatShouldIDrawGetText());

    }

    public void validationCancelILoveNoteitClick() throws InterruptedException {

        Assert.assertEquals("I love noteit",getTextILoveNoteIt());
    }

    public void validationILoveNoteitClick() {
        Assert.assertTrue(!iLoveNoteIt.isDisplayed());

    }

    public void validationEmailScreeen() throws InterruptedException {


            System.out.println(subjectEmail.getText());
            System.out.println(fildEmailTo.getText());
            if ( fildEmailTo.getText().equals("support@drawnoteit.com")){
                Assert.assertEquals("I need help with noteit",subjectEmail.getText());
                Assert.assertEquals("support@drawnoteit.com",fildEmailTo.getText());


            }
            else {
                Assert.assertEquals("I need help with noteit",subjectEmail.getText());
                Assert.assertEquals("support@drawnoteit.com",fildEmailTo.getText().substring(4));

        }

    }
}
