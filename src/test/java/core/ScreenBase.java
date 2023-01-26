package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class ScreenBase {

    public void waitFiveSeconds() throws InterruptedException {

        Thread.sleep(5000);

    }
    public void waitOneSecond() throws InterruptedException {

        Thread.sleep(1000);

    }
    public void waitUntilText(RemoteWebElement element, String text) throws MalformedURLException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(""),60);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));

    }


    public void longPressByElement(RemoteWebElement element, int duration) throws MalformedURLException {
        new TouchAction (DriverFactory.getDriver (""))
                .longPress(ElementOption.element(element))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                .release()
                .perform();
    }

    public void scroll(double inicio, double fim) throws MalformedURLException {
        //pegar o tamanho da tela
        Dimension size =  DriverFactory.getDriver("").manage ().window ().getSize ();
        //Denifinir x
        int x = size.width / 2;
        //Definir Y inicial
        int start_y = (int) (size.height * inicio);
        //Definir Y final
        int end_y = (int) (size.height * fim);
        //pressionar um ponto da tela
        new TouchAction (DriverFactory.getDriver (""))
                .press (PointOption.point(x,start_y))//segura neste ponto da tela
                .waitAction (WaitOptions.waitOptions(Duration.ofMillis(1000)))// espera por 500 milisegundos
                .moveTo (PointOption.point(x,end_y))//arrasta até este ponto
                .release ()//solta a tela
                .perform ();


    }
    public void swipeElement(MobileElement element , double inicio, double fim) throws MalformedURLException, InterruptedException {
        //pegar o tamanho da tela
        //Denifinir y
        int y = element.getLocation ().y + (element.getSize ().height/2);
        //Definir x inicial
        int start_x = (int) (element.getSize ().width * inicio);
        //Definir x final
        int end_x = (int) (element.getSize ().width * fim);
        //pressionar um ponto da tela
        new TouchAction (DriverFactory.getDriver (""))
                .press (PointOption.point (start_x,y))//segura neste ponto da tela
                .waitAction (WaitOptions.waitOptions (Duration.ofMillis (500)))// espera por 500 milisegundos
                .moveTo (PointOption.point (end_x,y))//arrasta até este ponto
                .release ()//solta a tela
                .perform ();

    }
    public void scrollDown() throws MalformedURLException, InterruptedException {scroll (0.5,0.1);}
    public void scrollUp() throws MalformedURLException, InterruptedException {scroll (0.1,0.5);}
}
