package Automation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.net.MalformedURLException;
import java.net.URL;

public class Facebook {
    public AndroidDriver driver;

    Logger log = Logger.getLogger(Calculator.class);

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("platformVersion", "9.0");
        dc.setCapability("appPackage", "com.facebook.katana");
        dc.setCapability("appActivity", "com.facebook.katana.LoginActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        System.out.println("It is Starting");
        log.info("Starting the driver");
    }


    @Test
    public void login() throws InterruptedException {
        Thread.sleep(400000);
        WebElement email = driver.findElement(AppiumBy.accessibilityId("Mobile number or email"));
        email.click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")).sendKeys("unique.swapnilpatil639@gmail.com");

        Thread.sleep(3000);
        WebElement password = driver.findElement(AppiumBy.accessibilityId("Password"));
        password.click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")).sendKeys("Swapnil@987");
        Thread.sleep(3000);
        WebElement loginBTN = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Log in\"]"));
        loginBTN.click();
    }

}



