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

public class ScreenSettings extends ScreenBase {
    public ScreenSettings(AppiumDriver<RemoteWebElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id="switch_new_notes")
    @iOSFindBy(accessibility="Unlink, to replace your partner you can unlink and ask for your new partner’s code")
    private RemoteWebElement switchNewNotes;

    public void signOut( ) {
        signOut.click();
    }

    @iOSFindBy(accessibility="Sign out")
    private RemoteWebElement signOut;
    @iOSFindBy(accessibility="Sign out")
    private RemoteWebElement confirmSignOut;
    @AndroidFindBy(id="switch_notifications")
    @iOSFindBy(accessibility="Unlink, to replace your partner you can unlink and ask for your new partner’s code")
    private RemoteWebElement switchNotifications;
    @AndroidFindBy(id="switch_streak_expiration")
    @iOSFindBy(accessibility="Unlink, to replace your partner you can unlink and ask for your new partner’s code")
    private RemoteWebElement switchStreakExpiration;
    @AndroidFindBy(id="button_start")
    @iOSFindBy(accessibility="Unlink, to replace your partner you can unlink and ask for your new partner’s code")
    private RemoteWebElement backButton;
    @AndroidFindBy(id="button")
    @iOSFindBy(accessibility="Unlink, to replace your partner you can unlink and ask for your new partner’s code")
    private RemoteWebElement unlink;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
    @iOSFindBy(accessibility="Yes")
    private RemoteWebElement confirm;

    public void switchNewNotesClick() throws InterruptedException {
        switchNewNotes.click();

    }
    public void signOutClick() throws InterruptedException {
        signOut.click();
        confirmSignOut();

    }
    public void confirmSignOut() throws InterruptedException {
        confirm.click();

    }
    public void switchNotificationsClick() throws InterruptedException {
        switchNotifications.click();

    }
    public void switchStreakExpirationClick() throws InterruptedException {
        switchStreakExpiration.click();

    }
    public void backButtonClick() throws InterruptedException {
        backButton.click();
        waitOneSecond();

    }
    public void goToUnLink() throws InterruptedException, MalformedURLException {
        unlink.click();
        longPressByElement(confirm,1000);
    }


    public void validationNotificationOff() {
        Assert.assertFalse(switchNotifications.isEnabled());
    }
    public void validationNotificationOn() {
        Assert.assertTrue(switchNotifications.isEnabled());
    }
}
