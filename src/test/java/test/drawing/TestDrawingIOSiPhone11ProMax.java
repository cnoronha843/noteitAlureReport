package test.drawing;

import core.DriverFactory;
import core.TestBase;
import io.appium.java_client.AppiumDriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebElement;
import screen.ScreenDrawing;
import screen.ScreenLogin;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class TestDrawingIOSiPhone11ProMax extends TestBase {
        private static ScreenDrawing screenDrawing;
        private static AppiumDriver<RemoteWebElement> driver;
        private static ScreenLogin screenLoginIos;


        @Before
        public void caps() throws MalformedURLException, InterruptedException {
                driver = DriverFactory.getDriver("browserstackiOS");
                driver.resetApp();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                screenDrawing = new ScreenDrawing(driver);
                screenLoginIos = new ScreenLogin(driver);
                screenLoginIos.loginCorrectIOS();
        }
//        @Test
//        public  void fullTestOfAdvancedToolKit() throws InterruptedException, MalformedURLException {
////                screenDrawing.fullTestOfAdvancedToolKit();
//                Thread.sleep(2000);
////                screenDrawing.verifyShowToolsIos();
//                Thread.sleep(2000);
////                screenDrawing.paletaCoresInicial();
////                setColorRed();
//                screenDrawing.tap(344,69);
//                screenDrawing.accessToolKit();
//                screenDrawing.assertCanetaIOS();
//                screenDrawing.sliderBrushMinimo();
//                screenDrawing.drawN();
//                screenDrawing.sliderBrushMaximo();
//                screenDrawing.drawO();
//                screenDrawing.sliderBrushMedio();
//                screenDrawing.drawT();
////                screenDrawing.paletaCoresInicial();
////                setColorBlack();
//                screenDrawing.tap(344,69);
//                screenDrawing.selectPecil();
//                screenDrawing.assertPencilIOS();
//
//                screenDrawing.sliderBrushMinimo();
//                screenDrawing.drawE();
//                screenDrawing.sliderBrushMaximo();
//                screenDrawing.drawI();
//                screenDrawing.sliderBrushMedio();
//                screenDrawing.drawLastT();
//                screenDrawing.selectHighlightTop();
//                screenDrawing.assertHighlightTopIOS();
////                screenDrawing.paletaCoresInicial();
////                setColorGreen();
//                screenDrawing.tap(344,69);
//                screenDrawing.sliderBrushMinimo();
//                screenDrawing.drawLinePencil(50,275,320,275);
//                screenDrawing.sliderBrushMaximo();
//                screenDrawing.drawLinePencil(50,310,320,310);
//                screenDrawing.sliderBrushMedio();
//                screenDrawing.drawLinePencil(50,370,320,370);
//                Thread.sleep(5000);
//                screenDrawing.doneClick();
//                Thread.sleep(5000);
//                screenDrawing.sendNote(driver);
//                Thread.sleep(5000);
//                screenDrawing.assertSendNoteIOS();
//        }

        @Test
        public void trashDrawing() throws InterruptedException, MalformedURLException {
                Thread.sleep(2000);
                screenDrawing.verifyShowToolsIos();
                Thread.sleep(2000);
                screenDrawing.accessToolKit();
                screenDrawing.sliderBrushMinimo();
                screenDrawing.drawN();
                screenDrawing.trashDrawing();
                screenDrawing.validateCleanScreen();
                screenDrawing.drawN();
                screenDrawing.undoDrawing();
                screenDrawing.validateCleanScreen();
        }
        @Test
        public void sendNoteAfterTrashingADrawing() throws InterruptedException, MalformedURLException {

                screenDrawing.verifyShowToolsIos();
                screenDrawing.accessToolKit();
                screenDrawing.sliderBrushMinimo();
                screenDrawing.drawN();
                screenDrawing.trashDrawing();
                screenDrawing.validateCleanScreen();
                screenDrawing.drawN();

                screenDrawing.sendNote(driver);

                screenDrawing.assertSendNoteIOS();
        }
        @Test
        public void sendNoteAfterTrashingAPicture() throws MalformedURLException, InterruptedException {
                Thread.sleep(2000);
                screenDrawing.verifyShowToolsIos();
                screenDrawing.openCamera();
                screenDrawing.permissionCameraClick();
                screenDrawing.takePictureIOS();
                Thread.sleep(2000);
                screenDrawing.trashDrawing();
                screenDrawing.validateCleanScreen();
                screenDrawing.openCamera();
                screenDrawing.takePictureIOS();
                screenDrawing.sendNote(driver);
                Thread.sleep(5000);
                screenDrawing.assertSendNoteIOS();

        }
//        @Test
//        public void sendThreeNotesInARow() throws InterruptedException, MalformedURLException {
//                Thread.sleep(2000);
//                screenDrawing.verifyShowToolsIos();
//                Thread.sleep(2000);
//                screenDrawing.accessToolKit();
//                screenDrawing.assertCanetaIOS();;
//                screenDrawing.drawN();
//                screenDrawing.doneClick();
//                Thread.sleep(5000);
//                screenDrawing.sendNote(driver);
//                Thread.sleep(8000);
//                screenDrawing.assertSendNoteIOS();
//                screenDrawing.returnToCanvas();
//                screenDrawing.accessToolKit();
//                screenDrawing.selectPecil();
//                screenDrawing.assertPencilIOS();
//                Thread.sleep(1000);
//                screenDrawing.drawO();
//                screenDrawing.doneClick();
//                Thread.sleep(5000);
//                screenDrawing.sendNote(driver);
//                Thread.sleep(8000);
//                screenDrawing.assertSendNoteIOS();
//                screenDrawing.returnToCanvas();
//                screenDrawing.accessToolKit();
//                screenDrawing.selectHighlightTop();
//                screenDrawing.assertHighlightTopIOS();
//                Thread.sleep(1000);
//                screenDrawing.drawT();
//                screenDrawing.doneClick();
//                Thread.sleep(5000);
//                screenDrawing.sendNote(driver);
//                Thread.sleep(8000);
//                screenDrawing.assertSendNoteIOS();
//
//        }


        @Test
        public void sendNote() throws MalformedURLException, InterruptedException {
                Thread.sleep(2000);
                screenDrawing.verifyShowToolsIos();
                Thread.sleep(2000);
                screenDrawing.accessToolKit();
                screenDrawing.assertCanetaIOS();;
                screenDrawing.drawN();
                screenDrawing.doneClick();
                Thread.sleep(5000);
                screenDrawing.sendNote(driver);
                Thread.sleep(5000);
                screenDrawing.assertSendNoteIOS();
        }


}