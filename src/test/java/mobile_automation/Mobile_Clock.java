package mobile_automation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Mobile_Clock {
    AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", "ac84a8ee");
        capabilities.setCapability("deviceName", "Redmi Y2");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("appPackage", "com.android.deskclock");
        capabilities.setCapability("appActivity", "com.android.deskclock.DeskClockTabActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        WebElement agree = driver.findElement(By.id("android:id/button1"));
        agree.click();
        System.out.println("It is Starting");
    }

    @Test(priority = 1)
    public void setAlarm() throws InterruptedException {
        TouchAction touch = new TouchAction(driver);

        Thread.sleep(3000);

        touch.tap(PointOption.point(352, 1183)).perform();

        Thread.sleep(3000);

        WebElement hourElement = driver.findElement(By.id("com.android.deskclock:id/hour"));
        hourElement.click();

        int startX = hourElement.getLocation().getX() + hourElement.getSize().getWidth() / 2;
        int startY = hourElement.getLocation().getY() + hourElement.getSize().getHeight() / 2;
        int endY = startY - 600;

        touch.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY)).release().perform();

        WebElement minute = driver.findElement(By.id("com.android.deskclock:id/minute"));
        hourElement.click();

        int startXMin = minute.getLocation().getX() + minute.getSize().getWidth() / 2;
        int startYMin = minute.getLocation().getY() + minute.getSize().getHeight() / 2;
        int endYMin = startYMin - 530;

        touch.press(PointOption.point(startXMin, startYMin)).waitAction((WaitOptions.waitOptions(Duration.ofMillis(500))))
                .moveTo(PointOption.point(startXMin, endYMin)).release().perform();

        WebElement amPM = driver.findElement(By.id("com.android.deskclock:id/amPm"));
        hourElement.click();

        int startXAMPM = amPM.getLocation().getX() + amPM.getSize().getWidth() / 2;
        int startYAMPM = amPM.getLocation().getY() + amPM.getSize().getHeight() / 2;
        int endYAMPM = startYAMPM - 530;

        touch.press(PointOption.point(startXAMPM, startYAMPM)).waitAction((WaitOptions.waitOptions(Duration.ofMillis(500))))
                .moveTo(PointOption.point(startXAMPM, endYAMPM)).release().perform();

        WebElement confirm = driver.findElement(AppiumBy.accessibilityId("Confirm"));
        confirm.click();
    }
}