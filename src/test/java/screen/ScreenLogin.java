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

public class ScreenLogin extends ScreenBase {
    public ScreenLogin(AppiumDriver<RemoteWebElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="et_email")
    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"noteit\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    private RemoteWebElement campoEmail;
    @iOSFindBy(accessibility="Oh no!")
    private RemoteWebElement passwordIncorrect;
    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"noteit\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    private RemoteWebElement contactAccess;
    @AndroidFindBy(id="et_password")
    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"noteit\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
    private RemoteWebElement campoSenha;
    @AndroidFindBy(id="txt_other_options")
    @iOSFindBy(accessibility="more options")
    private RemoteWebElement botaoMaisOpcoes;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView")
    @iOSFindBy(xpath="//XCUIElementTypeButton[3]")
    private RemoteWebElement botaoEntrar;
    @iOSFindBy(accessibility="Sign up")
    private RemoteWebElement botaoSignUp;
    @iOSFindBy(accessibility="not-checked-square")
    private RemoteWebElement botaoTerms;
    @AndroidFindBy(id="dadasdasd")
    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"noteit\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    private RemoteWebElement campoParceiro;
    @AndroidFindBy(id="dadasdasd")
    @iOSFindBy(xpath="//XCUIElementTypeStaticText[@name=\"inbox\"]")
    private RemoteWebElement loginValidation;
    @iOSFindBy(accessibility="ok")
    private RemoteWebElement ok;




    public void linkPartner() throws InterruptedException {
        campoParceiro.sendKeys("4905943");
        Thread.sleep(2000);
    }
    public void loginCorrectIOS() throws InterruptedException {
        botaoMaisOpcoes.click();
        campoEmail.sendKeys("carlos.automation.ios.noteit@gmail.com");
        campoSenha.sendKeys("Mudar123");
        botaoEntrar.click();

    }
    public void loginIncorrectIOS() {
                botaoMaisOpcoes.click();
                campoEmail.sendKeys("carlos.automation.ios.noteit@gmail.com");
                campoSenha.sendKeys("Mudar");
                botaoEntrar.click();
    }
    public void loginAndroid() throws MalformedURLException, InterruptedException {
        botaoMaisOpcoes.click();
        Thread.sleep(1000);
        campoEmail.sendKeys("catns.and.noteit@gmail.com");
        campoSenha.sendKeys("teste123");
        botaoEntrar.click();
        Thread.sleep(8000);
        contactAccess.click();
    }
    public void SignUpIos() throws InterruptedException {
        botaoMaisOpcoes.click();
        botaoSignUp.click();
        campoEmail.sendKeys("catns.ios.noteit@gmail.com");
        campoSenha.sendKeys("Mudar123");
        botaoTerms.click();
        Thread.sleep(1000);
        campoEmail.click();
        Thread.sleep(1000);
        botaoSignUp.click();
        Thread.sleep(1000);
    }
    public void validationLoginPasswordCorrect() throws InterruptedException {
        System.out.println(loginValidation.getText());
        Assert.assertEquals("inbox" , loginValidation.getText());



    }
    public void inboxClick() throws InterruptedException {
       loginValidation.click();



    }
    public void validationLoginPasswordIncorrect() throws MalformedURLException, InterruptedException {
        Assert.assertEquals("Oh no!" , passwordIncorrect.getText());
    }
    public void okClick() throws MalformedURLException, InterruptedException {
        longPressByElement(ok,1000);
        waitOneSecond();

    }
    public void cleanField() throws MalformedURLException {
        campoEmail.clear();
        campoSenha.clear();
    }
}
