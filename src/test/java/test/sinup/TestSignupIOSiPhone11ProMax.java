//package test.sinup;
//
//import core.DriverFactory;
//import core.TestBase;
//import io.appium.java_client.AppiumDriver;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.remote.RemoteWebElement;
//import screen.ScreenLinkPartner;
//import screen.ScreenSinup;
//
//import java.net.MalformedURLException;
//import java.util.concurrent.TimeUnit;
//
//public class TestSignupIOSiPhone11ProMax extends TestBase {
//        private static ScreenLinkPartner screenLinkPartner;
//        private static AppiumDriver<RemoteWebElement> driver;
//        private static ScreenSinup screenSinup;
//
//
//        @Before
//        public  void caps() throws MalformedURLException, InterruptedException {
//                driver = DriverFactory.getDriver("iPhone11ProMax");
//                driver.resetApp();
//                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                screenSinup = new ScreenSinup(driver);
//                screenLinkPartner = new ScreenLinkPartner(driver);
//
//        }
//
////        @Test
////        public void helpTeamNoteItTest() throws InterruptedException, MalformedURLException {
////                screenSinup.phoneNumberClick();
////                screenSinup.selectedCountryClick();
////                screenSinup.searchCountryBrazil();
////                screenSinup.setPhoneNumber();
////                screenLinkPartner.menuHelp();
////                screenSinup.notGettingMyCodeClick();
////                screenSinup.getHelpFromTeamNoteitClick();
////                screenSinup.validationEmailScreeen();
////        }
//        @Test
//        public void agreeToOurTermsPrivacyPolicy() throws InterruptedException, MalformedURLException {
//                screenSinup.phoneNumberClick();
//                screenSinup.byPressingNextTermsPrivacyPolicyClick();
//                screenSinup.validationPagePrivacyPolicyIOS();
//
//
//        }
//
//
//
//}

