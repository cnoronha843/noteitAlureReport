package screen;

import core.DriverFactory;
import core.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.time.Duration;

public class ScreenDrawing extends ScreenBase {
    private static AppiumDriver<RemoteWebElement> driver;
    private static String justnowAfterSendNote="just now";
    private static String justnowAfterSendNot="Just now";

    public ScreenDrawing(AppiumDriver<RemoteWebElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id="button_start")
    @iOSFindBy(accessibility="back-icon")
    private RemoteWebElement backButton;
    @AndroidFindBy(id="me.bukovitz.noteit.beta:id/btn_new_note")
    @iOSFindBy(xpath="//XCUIElementTypeButton[@name=\"plus-icon\"]")
    private RemoteWebElement newNote;
    @AndroidFindBy(id="drawing")
    @iOSFindBy(className="XCUIElementTypeScrollView")
    private RemoteWebElement halfScreen;
    @AndroidFindBy(id="me.bukovitz.noteit.beta:id/parent_open_camera")
    @iOSFindBy(accessibility="camera_icon")
    private RemoteWebElement camera;
    @iOSFindBy(accessibility = "OK")
    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private RemoteWebElement permissionCamera;
    @AndroidFindBy(id="drawing")
    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"noteit\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2]")
    private RemoteWebElement takePicture;
    @AndroidFindBy(id="btn_trash")
    @iOSFindBy(accessibility="inbox-text")
    private RemoteWebElement trash;
    @AndroidFindBy(id="me.bukovitz.noteit.beta:id/btn_undo")
    @iOSFindBy(accessibility="undo_icon")
    private RemoteWebElement undo;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
    @iOSFindBy(accessibility="trash")
    private RemoteWebElement confirmTrash;
    @AndroidFindBy(id="txt_start_drawing")
    @iOSFindBy(accessibility="(start drawing)")
    private RemoteWebElement startDrawing;
    @AndroidFindBy(id="btn_exit")
    private static RemoteWebElement closeColors;
    @AndroidFindBy(id="txt_noteit_fun")
    @iOSFindBy(xpath="//XCUIElementTypeStaticText[1]")
    private static RemoteWebElement share;
    @AndroidFindBy(id="btn_show_tools")
    @iOSFindBy(accessibility="show tools")
    private static RemoteWebElement showTools;
    @AndroidFindBy(id="android:id/button1")
    @iOSFindBy(accessibility="ok")
    private RemoteWebElement sendNoteOk;
    @AndroidFindBy(id="btn_show_tools")
    @iOSFindBy(accessibility="done_icon")
    private RemoteWebElement done;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    @iOSFindBy(accessibility="plane_icon")
    private RemoteWebElement sendNote;
    @AndroidFindBy(id="fill")
    @iOSFindBy(accessibility="marker_top")
    private RemoteWebElement caneta;

    @iOSFindBy(accessibility="marker_base_selected")
    private RemoteWebElement marker_base_selected;
    @iOSFindBy(accessibility="highlight_base_selected")
    private RemoteWebElement highlight_base_selected;
    @iOSFindBy(accessibility="pencil_base_selected")
    private RemoteWebElement pencil_base_selected;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.ImageView[2]")
    @iOSFindBy(accessibility="highlight_top")
    private RemoteWebElement highlightTop;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.ImageView[2]")
    @iOSFindBy(accessibility="pencil_unselected")
    private RemoteWebElement pencil;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.ImageView[2]")
    @iOSFindBy(accessibility="eraser_unselected")
    private RemoteWebElement borracha;
    @AndroidFindBy(id="fsfsdfdsfs")
    @iOSFindBy(accessibility="lasso_unselected")
    private RemoteWebElement tesoura;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.RelativeLayout/android.widget.ImageView[2]")
    @iOSFindBy(accessibility="ruler_unselected")
    private RemoteWebElement regua;
    @AndroidFindBy(id="image_stroke")
    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"noteit\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton")
    private static RemoteWebElement paletaCoresInicial;
    @AndroidFindBy(id="btn_tools")
    @iOSFindBy(accessibility="plus-circle")
    private static RemoteWebElement toolKit;


    @AndroidFindBy(id="seek_bar")
    @iOSFindBy(className="XCUIElementTypeSlider")
    private static RemoteWebElement sliderBrush;


    @AndroidFindBy(xpath="ripple")
    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"noteit\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton")
    private RemoteWebElement paletaCoresToolKit;


    public RemoteWebElement getPaletaCoresToolKit() {
        return paletaCoresToolKit;
    }
    public void paletaCoresInicial() throws InterruptedException {
         Thread.sleep(2000);
        paletaCoresInicial.click();
         Thread.sleep(2000);

    }
    public void paletaCoresToolKit() throws InterruptedException {
        paletaCoresToolKit.click();
         Thread.sleep(2000);

    }
    public void accessToolKit() throws InterruptedException {
         toolKit.click();
         Thread.sleep(2000);
    }

    public RemoteWebElement getHalfScreen() {
        return halfScreen;
    }
    public void selectHighlightTop(){
        highlightTop.click();
    }
    public void selectPecil(){
        pencil.click();

    }
    public void doneClick(){
        done.click();
    }
    public void sendNote(AppiumDriver driver) throws InterruptedException, MalformedURLException {
        TouchAction obj = new TouchAction(driver);
        obj.press(ElementOption.element(sendNote))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .release()
                .perform();
        Thread.sleep(4000);
        TouchAction obj2    = new TouchAction(driver);
        obj2.press(ElementOption.element(sendNoteOk))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .release()
                .perform();
        Thread.sleep(3000);


    }
    public void drawN() throws MalformedURLException {
        Integer x_topLeftCorner=38;
        Integer y_topLeftCorner=240;
        Integer x_topRightCorner=38;
        Integer y_topRightCorner=206;
        Integer x_bottomLeftCorner=58;
        Integer y_bottomLeftCorner=240;
        Integer x_bottomRightCorner=58;
        Integer y_bottomRightCorner=206;
        TouchAction obj = new TouchAction(DriverFactory.getDriver(""));
        obj.press(PointOption.point(x_topLeftCorner,y_topLeftCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_topRightCorner,y_topRightCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_bottomLeftCorner,y_bottomLeftCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_bottomRightCorner,y_bottomRightCorner))
                .release()
                .perform();
    }
    public void drawO() throws MalformedURLException {
        Integer x_topLeftCorner=78;
        Integer y_topLeftCorner=240;

        Integer x_topRightCorner=78;
        Integer y_topRightCorner=206;

        Integer x_bottomLeftCorner=108;
        Integer y_bottomLeftCorner=206;

        Integer x_bottomRightCorner=108;
        Integer y_bottomRightCorner=240;

        Integer x_bottomRightCorner5=78;
        Integer y_bottomRightCorner5=240;

        TouchAction obj = new TouchAction(DriverFactory.getDriver(""));
        obj.press(PointOption.point(x_topLeftCorner,y_topLeftCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_topRightCorner,y_topRightCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_bottomLeftCorner,y_bottomLeftCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_bottomRightCorner,y_bottomRightCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_bottomRightCorner5,y_bottomRightCorner5))
                .release()
                .perform();
    }
    public void drawT() throws MalformedURLException {
        Integer x_topLeftCorner=128;
        Integer y_topLeftCorner=206;

        Integer x_topRightCorner=178;
        Integer y_topRightCorner=206;

        Integer x_bottomLeftCorner=155;
        Integer y_bottomLeftCorner=206;

        Integer x_bottomRightCorner=148;
        Integer y_bottomRightCorner=245;

//                Integer x_bottomRightCorner5=78;
//                Integer y_bottomRightCorner5=240;

        TouchAction obj = new TouchAction(DriverFactory.getDriver(""));
        obj.press(PointOption.point(x_topLeftCorner,y_topLeftCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x_topRightCorner,y_topRightCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x_bottomLeftCorner,y_bottomLeftCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x_bottomRightCorner,y_bottomRightCorner))
//                        .waitAction (500)
//                        .moveTo(x_bottomRightCorner5,y_bottomRightCorner5)
                .release()
                .perform();
    }
    public void drawE() throws MalformedURLException {
        Integer x_topLeftCorner=195;
        Integer y_topLeftCorner=206;

        Integer x_topRightCorner=245;
        Integer y_topRightCorner=206;

        Integer x_bottomLeftCorner=195;
        Integer y_bottomLeftCorner=206;

        Integer x_bottomRightCorner=195;
        Integer y_bottomRightCorner=220;

        Integer x_bottomRightCorner5=245;
        Integer y_bottomRightCorner5=220;
        Integer x_bottomRightCorner6=195;
        Integer y_bottomRightCorner6=220;
        Integer x_bottomRightCorner7=195;
        Integer y_bottomRightCorner7=245;
        Integer x_bottomRightCorner8=245;
        Integer y_bottomRightCorner8=245;


        TouchAction obj = new TouchAction(DriverFactory.getDriver(""));
        obj.press(PointOption.point(x_topLeftCorner,y_topLeftCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x_topRightCorner,y_topRightCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_bottomLeftCorner,y_bottomLeftCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_bottomRightCorner,y_bottomRightCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_bottomRightCorner5,y_bottomRightCorner5))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_bottomRightCorner6,y_bottomRightCorner6))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_bottomRightCorner7,y_bottomRightCorner7))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_bottomRightCorner8,y_bottomRightCorner8))
                .release()
                .perform();
    }
    public void drawI() throws MalformedURLException {
        Integer x_topLeftCorner=275;
        Integer y_topLeftCorner=206;
        Integer x_bottomRightCorner=275;
        Integer y_bottomRightCorner=245;
        TouchAction obj = new TouchAction(DriverFactory.getDriver(""));
        obj.press(PointOption.point(x_topLeftCorner,y_topLeftCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x_bottomRightCorner,y_bottomRightCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .release()
                .perform();
    }
    public void drawLastT() throws MalformedURLException {
        Integer x_topLeftCorner=295;
        Integer y_topLeftCorner=206;
        Integer x_topRightCorner=345;
        Integer y_topRightCorner=206;
        Integer x_bottomLeftCorner=325;
        Integer y_bottomLeftCorner=206;
        Integer x_bottomRightCorner=325;
        Integer y_bottomRightCorner=245;
        TouchAction obj = new TouchAction(DriverFactory.getDriver(""));
        obj.press(PointOption.point(x_topLeftCorner,y_topLeftCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x_topRightCorner,y_topRightCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_bottomLeftCorner,y_bottomLeftCorner))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x_bottomRightCorner,y_bottomRightCorner))
                .release()
                .perform();
    }
    public void drawLinePencil(int startX,int startY, int endX, int endY) throws MalformedURLException {
        TouchAction obj = new TouchAction(DriverFactory.getDriver(""));
        obj.press(PointOption.point(startX,startY))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX,endY))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .release()
                .perform();
    }
    public static void setColorRed() throws InterruptedException, MalformedURLException {
//        if (driver == DriverFactory.getDriver("ios")){
            setColor(329,576);
//        }if (driver == DriverFactory.getDriver("android")){
//        }
    }
    public static void setColorRedAndroid() throws InterruptedException, MalformedURLException {

        driver = DriverFactory.getDriver("android");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[66]/android.view.View"))
                .click();

    }
    public static void setColorGreenAndroid() throws InterruptedException, MalformedURLException {

        driver = DriverFactory.getDriver("android");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[72]/android.view.View"))
                .click();

    }
    public static void setColorBlueAndroid() throws InterruptedException, MalformedURLException {
        //Put id in favorite colors
        driver = DriverFactory.getDriver("android");
        driver.findElement(By.
                xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView"))
                .click();
    }

    public static void setColor(int x , int y) throws InterruptedException, MalformedURLException {
        TouchAction obj = new TouchAction(DriverFactory.getDriver(""));
        obj.tap(PointOption.point(x,y))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(100)))
                .release()
                .perform();
        Thread.sleep(1000);

    }
    public static void setColorBlack() throws InterruptedException, MalformedURLException {

//        if (driver == DriverFactory.getDriver("ios")){
            setColor(383,331);
//        }if (driver == DriverFactory.getDriver("android")){
//        }

    }
    public static void setColorGreen() throws InterruptedException, MalformedURLException {

//        if (driver == DriverFactory.getDriver("ios")){
            setColor(386,417);
//        }if (driver == DriverFactory.getDriver("android")){
            setColor(1006,707);
//        }

    }
    public static void tap(int x, int y) throws InterruptedException, MalformedURLException {

        TouchAction obj = new TouchAction(DriverFactory.getDriver(""));
        obj.tap(PointOption.point(x,y))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(500)))
                .release()
                .perform();
        Thread.sleep(1000);

    }
    public static void sliderBrushMinimo() throws InterruptedException, MalformedURLException {
        TouchAction obj = new TouchAction(DriverFactory.getDriver(""));
        obj.press(PointOption.point(208,754))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(37,754))
                .release()
                .perform();
        Thread.sleep(1000);

    }
    public static void sliderBrushMaximo() throws InterruptedException, MalformedURLException {

        TouchAction obj = new TouchAction(DriverFactory.getDriver(""));
        obj.press(PointOption.point(37,754))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(380,754))
                .release()
                .perform();
        Thread.sleep(1000);

    }
    public static void sliderBrushMedio() throws InterruptedException, MalformedURLException {
        TouchAction obj = new TouchAction(DriverFactory.getDriver(""));
        obj.press(PointOption.point(380,754))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(208,754))
                .release()
                .perform();
        Thread.sleep(1000);

    }

    public void assertHighlightTop(){
        Assert.assertTrue(highlightTop.isSelected());
    }
    public void assertPencil(){
        Assert.assertTrue(pencil.isSelected());
    }
    public void assertCaneta(){
        Assert.assertTrue(caneta.isSelected());
    }
    public void assertPencilIOS(){
        Assert.assertTrue(pencil_base_selected.isDisplayed());
    }
    public void assertCanetaIOS(){
        Assert.assertTrue(marker_base_selected.isDisplayed());
    }
    public void assertHighlightTopIOS(){
        Assert.assertTrue(highlight_base_selected.isDisplayed());
    }
    public static void assertSendNoteIOS(){
       Assert.assertEquals("share", share.getText());
    }
    public static void verifyShowToolsAndroid() throws InterruptedException {
        Thread.sleep(1000);
//        !paletaCoresInicial.isEnabled() ||
        if (showTools.isDisplayed()){
            showTools.click();
        }
    }
    public static void verifyShowToolsIos() throws InterruptedException {

        try {

        showTools.click();
        } catch (Exception e){}


    }
    public static void closeColors( ) throws MalformedURLException, InterruptedException {

//        if (driver == DriverFactory.getDriver("ios")){
//            tap(200,100);
//        }if (driver == DriverFactory.getDriver("android")){
            closeColors.click();
//        }
    }
    public  void sliderBrushMinimoAndroid() throws MalformedURLException, InterruptedException {
        swipeElement((MobileElement) sliderBrush,0.9,0.1);
    }
    public  void sliderBrushMaximoAndroid() throws MalformedURLException, InterruptedException {
        swipeElement((MobileElement) sliderBrush,0.1,0.9);
    }

    public void trashDrawing() throws InterruptedException, MalformedURLException {
        trash.click();
        Thread.sleep(3000);
        TouchAction obj2    = new TouchAction(DriverFactory.getDriver(""));
        obj2.press(ElementOption.element(confirmTrash))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .release()
                .perform();
        Thread.sleep(5000);
    }
    public void undoDrawing() throws InterruptedException {
        Thread.sleep(1000);
        undo.click();
        Thread.sleep(1000);

    }
    public void permissionCameraClick() throws MalformedURLException, InterruptedException {
        longPressByElement(permissionCamera,500);
        waitOneSecond();
    }
    public void openCamera() throws MalformedURLException, InterruptedException {
        camera.click();
        waitOneSecond();
    }
    public void  takePictureIOS() throws InterruptedException, MalformedURLException {

        longPressByElement(takePicture, 500);
        waitOneSecond();
    }
    public void takePictureAndroid() throws InterruptedException, MalformedURLException {
        Thread.sleep(1000);
        camera.click();
        Thread.sleep(1000);
        if (permissionCamera.isDisplayed()){
            setPermissionCamera();
        }
        Thread.sleep(1000);
        TouchAction obj2    = new TouchAction(DriverFactory.getDriver(""));
        obj2.press(ElementOption.element(takePicture))
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .release()
                .perform();
        Thread.sleep(3000);


    }
    public void setPermissionCamera() throws InterruptedException {
        Thread.sleep(1000);
        permissionCamera.click();
    }
    public void validateCleanScreen() throws InterruptedException {
        Assert.assertEquals("(start drawing)",startDrawing.getText());

    }
    public void returnToCanvas() throws InterruptedException {
        waitOneSecond();
        backButton.click();
        waitFiveSeconds();

        newNote.click();
    }



}
