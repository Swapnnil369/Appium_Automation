package Automation;

import com.google.common.collect.ImmutableMultimap;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Amazon1 {

    public AndroidDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        dc.setCapability("chromedriverExecutable", "C:\\Users\\shiva\\OneDrive\\Desktop\\AI\\chromedriver_win32\\chromedriver.exe");
        dc.setCapability("chromeOptions", ImmutableMultimap.of("w3c", false));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        Thread.sleep(8000);
        System.out.println("It is Starting");
    }

    @Test
    public void search() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("https://www.amazon.in");
        WebElement search = driver.findElement(By.name("k"));
        search.sendKeys("Redmi note 13 Pro");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        JavascriptExecutor javascriptExecutor = driver;
        javascriptExecutor.executeScript("window.scrollTo(0,600)");
        Thread.sleep(4000);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        javascriptExecutor.executeScript("window.scrollTo(0,1500)");
        Thread.sleep(3000);
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(2000);
        TouchAction action=new TouchAction(driver);
        action.tap(PointOption.point(1277, 743)).perform();
        Thread.sleep(3000);
        javascriptExecutor.executeScript("window.scrollTo(0,-1500)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='cart-size']")).click();

    }


}
