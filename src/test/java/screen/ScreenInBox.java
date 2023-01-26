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
import java.sql.SQLException;

import static core.SpannerDB.query;


public class ScreenInBox extends ScreenBase {
    public ScreenInBox(AppiumDriver<RemoteWebElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    private static WebDriverWait wait;
    private static AppiumDriver driver;
    @AndroidFindBy(xpath="//android.widget.Button[@text='Allow']")
    private RemoteWebElement permissionContacts;

    public static String getTextInBoxLogo() {
        return inBox.getText();
    }

    @AndroidFindBy(id="textview_inbox")
    @iOSFindBy(accessibility="app-logo")
    private static RemoteWebElement inBox;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.TextView")
    @iOSFindBy(xpath="//XCUIElementTypeStaticText[@name=\"settings\"]")
    private RemoteWebElement settings;
//    @AndroidFindBy(id="image_profile")
    @AndroidFindBy(id="btn_settings")
    @iOSFindBy(accessibility="app-logo")
    private RemoteWebElement menuInbox;
    @AndroidFindBy(id="txt_streak_countdown")
    @iOSFindBy(accessibility="menu-icon")
    private RemoteWebElement streakCountDown;
    @AndroidFindBy(id="txt_streak")
    @iOSFindBy(accessibility="menu-icon")
    private RemoteWebElement quantityStreaks;
    @AndroidFindBy(id="drawable_end")
    @iOSFindBy(accessibility="menu-icon")
    private RemoteWebElement streakHistory;




    public void validationScreenSettings() {
    }
    public void allowPermissionContacts() throws MalformedURLException, InterruptedException {
        waitOneSecond();
        longPressByElement(permissionContacts,1000);
    }


    public void goToSetting() throws MalformedURLException, InterruptedException {

        longPressByElement(settings,500);
        waitOneSecond();
    }
    public void menuInbox() throws MalformedURLException, InterruptedException {

        longPressByElement(menuInbox,500);


    }
    public void goToInbox() throws MalformedURLException, InterruptedException {


        longPressByElement(inBox,500);
    }
    public void goToStreakHistory() throws MalformedURLException, InterruptedException {

        streakHistory.click();
    }
    public void goToRose() throws MalformedURLException, InterruptedException {

        quantityStreaks.click();
    }
    public static  void insertNoteDB() throws SQLException {
        query("insert into notes\n" +
                "        values(scorestreak_id = sha1(''),\n" +
                "                sender_user_id = sha1('ImCv0xp9dVgVNBwG4toESmeS6OD2'),\n" +
                "                conversation_id = sha1(concat('ImCv0xp9dVgVNBwG4toESmeS6OD2',':','iHQ5xw33G2gbhoOuxWgTUUldk9u2')) )\n" +
                "        note_id = sha1('')\n" +
                "        inserted_at = ,\n" +
                "                created_at\n" +
                "        updated_at\n" +
                "                firebase_drawing_id\n" +
                "        target_id\n" +
                "                drawing_url\n" +
                "        widget_url\n" +
                "                tiktok_video_url\n" +
                "        raw_video_url\n" +
                "        where conversation_id = sha1(concat('ImCv0xp9dVgVNBwG4toESmeS6OD2',':','iHQ5xw33G2gbhoOuxWgTUUldk9u2'))\n" +
                "        and scorestreak =");
    }
    public static  void insertDBeaver() throws SQLException {
        query("INSERT INTO notes" +
                "(conversation_id, " +
                "note_id, " +
                "inserted_at, " +
                "created_at, " +
                "updated_at, " +
                "firebase_drawing_id, " +
                "sender_user_id, " +
                "target_id, " +
                "drawing_url, " +
                "widget_url, " +
                "tiktok_video_url, " +
                "thumbnail_url, " +
                "raw_video_url, " +
                "scorestreak_id, " +
                "read_at)" +
                "VALUES(?, ?, '', '', '', '', ?, ?, '', '', '', '', '', ?, '')");
    }
    public  static void streakBroke() throws SQLException {
        String user1 = "Xfm0bBtGjcSKmjVaTLwulPfUFSp2";
        String user2 = "kQdQtu6yuzNvK2F5pxqkO9f6BA72";


        query("" +
                "select s.scorestreak_id, s.breaks_at breaks_at, count(s.scorestreak_id) qtdNotes, " +
                "s.last_note_created_at_user_1, s.last_note_created_at_user_2, s.recovered_at, " +
                "s.recovered_by_user_id from scorestreaks s left join notes n on " +
                "n.scorestreak_id = s.scorestreak_id where s.conversation_id = sha1(concat('"+user1+"',':','"+user2+"')) " +
                "-- leticia@premiersoft + leticiapremiersoft (google) --where n.conversation_id = sha1(concat('VrcebNaax2XjQ7ahhQNOgGEYKxd2',':','tk8ydc8ZEpaElQPoa9QtNZdD5Jm1')) " +
                "-- vinicius.predrini.se + telefoneVini group by s.scorestreak_id, s.breaks_at, s.recovered_at, s.recovered_by_user_id, s.last_note_created_at_user_1, s.last_note_created_at_user_2 order by breaks_at desc");
    }
    public static void sixHoursStreakBreak() throws SQLException {



        query(
                "select s.scorestreak_id, s.breaks_at breaks_at, count(s.scorestreak_id) qtdNotes, s.last_note_created_at_user_1, s.last_note_created_at_user_2, s.recovered_at, " +
                "s.recovered_by_user_id from scorestreaks s left join notes n on n.scorestreak_id = s.scorestreak_id " +
                "where s.conversation_id = sha1(concat('mttcqHqQuLXN9ikZpcMGnPlZvXy1',':','tG9MZIvXtRU8JdosYbl1ppygPRr2'))" +
                " -- leticia@premiersoft + leticiapremiersoft (google) --where n.conversation_id = sha1(concat('VrcebNaax2XjQ7ahhQNOgGEYKxd2',':','tk8ydc8ZEpaElQPoa9QtNZdD5Jm1')) " +
                "-- vinicius.predrini.se + telefoneVini group by s.scorestreak_id, s.breaks_at, s.recovered_at, s.recovered_by_user_id, s.last_note_created_at_user_1, s.last_note_created_at_user_2 order by breaks_at desc");
    }

    public void validationStreakBroke() {
        Assert.assertTrue(quantityStreaks.getText() == "0");

    }

    public void validationsixHoursStreakBreak() {
        Assert.assertTrue(streakCountDown.getText() == "06:00:00");

    }

    public void goToRecoveryStreak() {

    }
}
