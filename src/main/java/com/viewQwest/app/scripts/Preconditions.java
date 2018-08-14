package com.viewQwest.app.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.yandex.qatools.allure.annotations.Attachment;

public class Preconditions extends StartDriver{
    @BeforeClass
    public void login() throws Exception {
        new LoginFunction().loginWithValidUsernameAndPassword();
    }
    @AfterClass
    public void exitApp() throws Exception {
        driver.resetApp();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
