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

public class ScreenSinup extends ScreenBase {
    public ScreenSinup(AppiumDriver<RemoteWebElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="textview")
    @iOSFindBy(accessibility="plus-icon")
    private RemoteWebElement sinupPhoneNumber;
    @AndroidFindBy(id="et_phone")
    @iOSFindBy(className="XCUIElementTypeTextField")
    private RemoteWebElement phoneNumberField;

    @AndroidFindBy(id="textview")
    @iOSFindBy(accessibility="next")
    private RemoteWebElement nextButton;
    @AndroidFindBy(id="me.bukovitz.noteit:id/textView_selectedCountry")
    @iOSFindBy(xpath="//XCUIElementTypeButton[@name=\"+1\"]/XCUIElementTypeImage")
    private RemoteWebElement selectedCountry;
    @AndroidFindBy(id="editText_search")
    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"noteit\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    private RemoteWebElement searchCountry;
    @AndroidFindBy(id="textView_countryName")
    @iOSFindBy(accessibility="Brazil")
    private RemoteWebElement brazilCountry;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView")
    @iOSFindBy(accessibility="i'm not getting my code")
    private RemoteWebElement notGettingMyCode;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView")
    @iOSFindBy(accessibility="get help from team noteit")
    private RemoteWebElement getHelpFromTeamNoteit;
    @AndroidFindBy(id="com.google.android.gm:id/subject")
    @iOSFindBy(accessibility="subjectField")
    private RemoteWebElement subjectEmail;
    @AndroidFindBy(id="com.google.android.gm:id/peoplekit_chip")
    @iOSFindBy(accessibility="toField")
    private RemoteWebElement fildEmailTo;
    @AndroidFindBy(id="txt_terms")
    @iOSFindBy(accessibility="by pressing next, you agree to our terms & privacy policy")
    private RemoteWebElement byPressingNextTermsPrivacyPolicy;
    @AndroidFindBy(id="com.google.android.gm:id/peoplekit_chip")
    @iOSFindBy(accessibility="privacy policy")
    private RemoteWebElement pagePrivacyPolicy;
    @AndroidFindBy(id="android:id/button2")
    private RemoteWebElement openWithDrive;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='terms-of-service.pdf']")
    private RemoteWebElement pdfReader;
    public void openWithDriveClick() throws InterruptedException {

        openWithDrive.click();

    }
    public String pdfReaderGetText() throws InterruptedException {

        return pdfReader.getText();

    }
    public void validationPagePrivacyPolicyAndroid() throws InterruptedException {

        Assert.assertEquals("terms-of-service.pdf",pdfReaderGetText());
    }
    public void validationPagePrivacyPolicyIOS() throws InterruptedException {
        Assert.assertEquals("privacy policy",pagePrivacyPolicyGetText());
    }

    public String pagePrivacyPolicyGetText() throws InterruptedException {

        return pagePrivacyPolicy.getText();

    }
    public void byPressingNextTermsPrivacyPolicyClick() throws InterruptedException {
        byPressingNextTermsPrivacyPolicy.click();

    }


    public void phoneNumberClick() throws InterruptedException {
        sinupPhoneNumber.click();

    }
    public void phoneNumberGetText(){
        phoneNumberField.click();
    }
    public void setPhoneNumber() throws InterruptedException {

        phoneNumberField.sendKeys("21972136937");
        nextButton.click();

    }
    public void selectedCountryClick() throws MalformedURLException {
        selectedCountry.click();
        //         longPressByElement(selectedCountry,1000);
    }
    public void searchCountryBrazil(){
        searchCountry.sendKeys("Bra");
        brazilCountry.click();
    }
    public void notGettingMyCodeClick() throws InterruptedException, MalformedURLException {
        notGettingMyCode.click();

//        longPressByElement(notGettingMyCode, 1000);1000

    }
    public void getHelpFromTeamNoteitClick() throws MalformedURLException {
getHelpFromTeamNoteit.click();
//        longPressByElement(getHelpFromTeamNoteit, 1000);

    }
    public void validationEmailScreeen() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(subjectEmail.getText());
        System.out.println(fildEmailTo.getText());
        if (fildEmailTo.getText().equals("To:￼support@drawnoteit.com")){
            Assert.assertEquals("I can't register myself",subjectEmail.getText());
            Assert.assertEquals("To:￼support@drawnoteit.com"  ,fildEmailTo.getText());
        }
        else {
            Assert.assertEquals("I can't register myself",subjectEmail.getText());
            Assert.assertEquals("support@drawnoteit.com",fildEmailTo.getText());
        }    }
}
