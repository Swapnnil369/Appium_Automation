package Automation;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class AmazonApp {

    public AndroidDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("platformVersion", "9.0");
        dc.setCapability("appPackage", "com.amazon.mShop.android.shopping");
        dc.setCapability("appActivity", "com.amazon.windowshop.home.HomeLauncherActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        System.out.println("It is Starting");
    }


    @Test
    public void searchBook() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();
        Thread.sleep(20000);
        driver.findElement(By.id("com.amazon.mShop.android.shopping:id/chrome_search_hint_view")).click();
        Thread.sleep(5000);
        WebElement searchbox = driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text"));
        searchbox.sendKeys("power of subconscious mind joseph murphy");
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(60000);
        WebElement book = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[4]/android.view.View[4]"));
        Thread.sleep(3000);
        book.click();
    }
}
