package com.viewQwest.app.documents;

import com.viewQwest.app.context.UserLoginContext;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.viewQwest.app.scripts.StartDriver.driver;
import static com.viewQwest.app.scripts.StartDriver.iosDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class UserLoginDocument implements Document {
    private final UserLoginContext context;
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(UserLoginDocument.class);

    public UserLoginDocument(UserLoginContext context) {
        this.context = context;
    }

    public byte[] login() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        WebElement userName = driver.findElementById("email");
        userName.clear();
        userName.sendKeys(context.getUserName());

        WebElement password = driver.findElementById("password");
        password.clear();
        password.sendKeys(context.getPassword());
        WebElement loginButton = driver.findElementById("email_sign_in_button");
        loginButton.click();

        if (!context.getState()) {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            Assert.assertTrue(loginButton.isDisplayed());
            log.info("Error message Displayed...");
            return driver.getScreenshotAs(OutputType.BYTES);
        } else {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            Assert.assertTrue(driver.findElementById("button_setting_menu").isDisplayed());
            log.info("Login succeeded...");
            return driver.getScreenshotAs(OutputType.BYTES);
        }
    }
}
