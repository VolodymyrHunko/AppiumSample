package com.example.hunko.appiumapplication;
import android.widget.GridLayout;

import java.net.MalformedURLException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;

public class ExampleUnitTest {

    WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
// Created object of DesiredCapabilities class.

        capabilities.setCapability("deviceName", "emulator-5554");
// Set android deviceName desired capability. Set your device name.

        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
// Set BROWSER_NAME desired capability. As we are running on Android Emulator, It's Android.

        capabilities.setCapability(CapabilityType.VERSION, "7.0");
// Set Android's OS VERSION @ desired capability.

        capabilities.setCapability("platformName", "Android");
// Set platformName desired capability to Android.

        capabilities.setCapability("appPackage", "com.android.calculator2");
// Set your application's package.

        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
// Set your application's MainActivity.

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
// Create driver, set the Appium Server details.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void Sum() {
        driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'del')]")).click();
        driver.findElement(By.xpath("//android.widget.Button[@text='5']")).click();
        String result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id, 'formula')]")).getText();
        Assert.assertEquals("5" , result);
    }

    @After
    public void End() {
        driver.quit();
    }
}