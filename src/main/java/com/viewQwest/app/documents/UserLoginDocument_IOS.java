package com.viewQwest.app.documents;

import com.viewQwest.app.context.UserLoginContext;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.viewQwest.app.scripts.StartDriver.driver;
import static com.viewQwest.app.scripts.StartDriver.iosDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class UserLoginDocument_IOS {
    private final UserLoginContext context;
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(UserLoginDocument.class);

    public UserLoginDocument_IOS(UserLoginContext context) {
        this.context = context;
    }

    public byte[] login() throws Exception {
        WebDriverWait wait = new WebDriverWait(iosDriver, 2);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            iosDriver.switchTo().alert().accept();
            iosDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.err.println("No alert visible after 1 sec.");
        }
        MobileElement userName = (MobileElement) iosDriver.findElementByAccessibilityId("username");
        userName.clear();
        userName.sendKeys(context.getUserName());

        MobileElement password = (MobileElement) iosDriver.findElementByAccessibilityId("password");
        password.clear();
        password.sendKeys(context.getPassword());

        MobileElement loginButton = (MobileElement) iosDriver.findElementByAccessibilityId("LOGIN");
        loginButton.click();

        if (!context.getState()) {
            wait.until(ExpectedConditions.alertIsPresent());
            iosDriver.switchTo().alert().accept();
            iosDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            Assert.assertTrue(loginButton.isDisplayed());
            return driver.getScreenshotAs(OutputType.BYTES);
        } else {
            iosDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            Assert.assertTrue(iosDriver.findElementByAccessibilityId("menuAll").isDisplayed());
            return driver.getScreenshotAs(OutputType.BYTES);
        }
    }
}
