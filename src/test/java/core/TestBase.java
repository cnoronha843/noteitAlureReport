package core;

import org.junit.After;
import org.junit.AfterClass;

import java.net.MalformedURLException;

public class TestBase {
    @AfterClass
    public static void finishClass() throws MalformedURLException {
        DriverFactory.killDriver();
    }
    @After
    public void closeApp() throws InterruptedException, MalformedURLException {
        DriverFactory.restartDriver();

    }
}
