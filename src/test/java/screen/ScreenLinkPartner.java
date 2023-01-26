package screen;

import core.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class ScreenLinkPartner extends ScreenBase {
    public ScreenLinkPartner(AppiumDriver<RemoteWebElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="chooser_header")
    @iOSFindBy(accessibility="Close")
    private RemoteWebElement sheetShare;
    @AndroidFindBy(id="txt_phone_label")
    @iOSFindBy(accessibility="ask your partner for their code")
    private RemoteWebElement menssageScreenLinkPartner;
    @AndroidFindBy(id="txt_share_code")
    @iOSFindBy(xpath="//XCUIElementTypeButton[3]")
    private RemoteWebElement buttonShareCode;
    @iOSFindBy(accessibility="copied to clipboard!")
    private RemoteWebElement copiedToClipboard;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.TabHost/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
    private RemoteWebElement linkTextAndroid;
    @AndroidFindBy(id="et_partner_code")
    @iOSFindBy(className="XCUIElementTypeTextField")
    private RemoteWebElement fildPartner;
    @AndroidFindBy(id="txt_need_help")
    @iOSFindBy(accessibility="need help")
    private RemoteWebElement needHelp;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
    @iOSFindBy(accessibility="what is a partner?")
    private RemoteWebElement whatIsAPartner;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[3]/android.view.ViewGroup")
    @iOSFindBy(accessibility="refresh code")
    private RemoteWebElement refreshCode;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[4]/android.view.ViewGroup")
    @iOSFindBy(accessibility="get help from team noteit")
    private RemoteWebElement getHelpTeamNoteIt;
    @AndroidFindBy(id="com.google.android.gm:id/subject")
    @iOSFindBy(accessibility="subjectField")
    private RemoteWebElement subjectEmail;
    @AndroidFindBy(id="com.google.android.gm:id/peoplekit_chip")
    @iOSFindBy(accessibility="toField")
    private RemoteWebElement fildEmailTo;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[5]/android.view.ViewGroup")
    @iOSFindBy(accessibility="cancel")
    private RemoteWebElement cancelHelp;
    @AndroidFindBy(id="btn_what_is_partner")
    @iOSFindBy(accessibility="question-button-icon")
    private RemoteWebElement buttonQuestionMark;
    @AndroidFindBy(id="txt_add_modal_info")
    @iOSFindBy(xpath="//XCUIElementTypeStaticText[2]")
    private RemoteWebElement titleOnboarding;
    @AndroidFindBy(id="parent")
    @iOSFindBy(className="XCUIElementTypeButton")
    private RemoteWebElement buttonNext;

    public void connectWithAPartner(String partnerCode) throws MalformedURLException, InterruptedException {
        Thread.sleep(3000);
//        longPressByElement(fildPartner,1000);
//       HasClipboard clipboard = ((HasClipboard) DriverFactory.getDriver(""));
//        clipboard.setClipboardText(partnerCode);
//        fildPartner.sendKeys(clipboard.getClipboardText());
//        longPressByElement(fildPartner,1000);
//        Thread.sleep(3000);
                fildPartner.sendKeys(partnerCode);
    }

public void openWhatIsAPartner() throws MalformedURLException, InterruptedException {

        longPressByElement(whatIsAPartner,500);
    }

    public String getTitleLinkPartner() throws MalformedURLException, InterruptedException {

       return menssageScreenLinkPartner.getText();
    }
    public String getTitleOnboarding() throws MalformedURLException, InterruptedException {

       return titleOnboarding.getText();
    }
    public void buttonNextClick() throws MalformedURLException, InterruptedException {

        buttonNext.click();
    }
    public void openOnboardingByQuestionMark() throws MalformedURLException, InterruptedException {

        longPressByElement(buttonQuestionMark,2000);
    }
    public void closeKeyboard() throws MalformedURLException, InterruptedException {
        menuHelp();
        titleOnboarding.click();
//        longPressByElement(titleOnboarding);
    }

    public void copyCode() throws InterruptedException, MalformedURLException {
        Thread.sleep(2000);
        System.out.println( buttonShareCode.getText());
        buttonShareCode.click();

    }

    public void refreshCodePartner() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println( buttonShareCodeGetText());
        Thread.sleep(2000);
        menuHelp();
        Thread.sleep(2000);
        refreshCode.click();
        Thread.sleep(2000);
        System.out.println( buttonShareCodeGetText());
    }

    public String buttonShareCodeGetText( ) throws InterruptedException {
        return buttonShareCode.getText();
    }
    public void menuHelp( ) throws InterruptedException {
         needHelp.click();
    }
    public void helpTeamNoteIt( ) throws InterruptedException {

         getHelpTeamNoteIt.click();
    }

    public void  validationEmailScreeen() throws InterruptedException, MalformedURLException {
        Thread.sleep(5000);
        System.out.println(subjectEmail.getText());
        System.out.println(fildEmailTo.getText());
        if ( subjectEmail.getText().equals("I'm not able to connect to my partner")){
       Assert.assertEquals("I'm not able to connect to my partner",subjectEmail.getText());
       Assert.assertEquals("support@drawnoteit.com",fildEmailTo.getText().substring(4));
        }
        else {
       Assert.assertEquals("I’m not able to connect to my partner",subjectEmail.getText());
       Assert.assertEquals("support@drawnoteit.com",fildEmailTo.getText());
        }
    }
    public void validationScreenPartner() throws InterruptedException {
        Thread.sleep(3000);

        Assert.assertTrue(menssageScreenLinkPartner.isDisplayed());
    }
    public void validationCopyCode(String clipboard) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals("https://app.noteit.fun add me to your noteit widget:" ,
                clipboard.substring(0,52));
//        System.out.printf(clipboard);
//        if ("copied to clipboard!"== copiedToClipboard.getText()){
//            Assert.assertTrue(true);
//        }else {
//            Assert.assertEquals("https://app.noteit.fun add me to your noteit widget:" ,
//                    clipboard.substring(0,52));
//        }
    }
    public void  validationRefreshCodePartner(String valueStart, String valueEnd ) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertNotEquals(valueStart,valueEnd);
    }
    public void validationWhatIsAPartner(String page1,String page2,String page3,String page4,String page5 ) throws MalformedURLException, InterruptedException {

        Assert.assertEquals("your partner is your closest friend, gf, or bf", page1);
        Assert.assertEquals("they will put notes on your home screen", page2);
        Assert.assertEquals("your partner can text you their code", page3);
        Assert.assertEquals("or you can share your code now!", page4);
        Assert.assertEquals("ask your partner for their code", page5);
    }










}
