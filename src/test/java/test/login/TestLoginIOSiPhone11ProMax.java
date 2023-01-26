package test.login;


import core.DriverFactory;
import core.TestBase;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebElement;
import screen.ScreenLogin;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class TestLoginIOSiPhone11ProMax extends TestBase {
        private static ScreenLogin screenLoginIos;

        private static AppiumDriver<RemoteWebElement> driver;

        @Before
        public  void caps() throws MalformedURLException {
                driver = DriverFactory.getDriver("browserstackiOS");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                screenLoginIos = new ScreenLogin(driver);
        }

        @Test
        @DisplayName("Login successful")
        public void testLoginPasswordCorrect() throws InterruptedException, MalformedURLException {
                screenLoginIos.loginCorrectIOS();
                screenLoginIos.validationLoginPasswordCorrect();
        }
        @Test
        @DisplayName("Login Incorrect")
        public void testLoginLoginPasswordIncorrect() throws InterruptedException, MalformedURLException {
                screenLoginIos.loginIncorrectIOS();
                screenLoginIos.validationLoginPasswordIncorrect();
        }

}

