package mobile_automation;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {

    public AndroidDriver driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc= new DesiredCapabilities();
        dc.setCapability("platformName","Android");
        dc.setCapability("udid","v8kjwoqgmjbu85y5");
        dc.setCapability("deviceName","Redmi Note 8 pro");
        dc.setCapability("platformVersion","11.0");
        dc.setCapability("appPackage","com.miui.calculator");
        dc.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        System.out.println("It is Starting");
    }

    @Test
    public void addition() throws InterruptedException {
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(PointOption.point(443,860)).perform();
        WebElement nine = driver.findElement(By.id("com.miui.calculator:id/btn_6_s"));
        nine.click();
        WebElement plus=driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
        plus.click();
        WebElement one=driver.findElement(By.id("com.miui.calculator:id/btn_1_s"));
        one.click();
        WebElement equal=driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
        equal.click();
    }
}
