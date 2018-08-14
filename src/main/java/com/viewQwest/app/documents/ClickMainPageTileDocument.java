package com.viewQwest.app.documents;

import com.viewQwest.app.context.ClickMainPageTileContext;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.viewQwest.app.scripts.StartDriver.driver;
import static org.testng.Assert.assertNotNull;

public class ClickMainPageTileDocument implements Document {
    private final ClickMainPageTileContext context;
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ClickMainPageTileDocument.class);

    public ClickMainPageTileDocument(ClickMainPageTileContext context) {
        this.context = context;
    }

    public byte[] click() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Door sensor']")));

        AndroidElement tileList = (AndroidElement) driver.findElement(By.className("android.view.ViewGroup"));
        MobileElement tile = tileList.findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"" + context.getTileName().trim() + "\"));"));
        assertNotNull(tile.getLocation());
        tile.click();
        log.info("Clicked tile...");
        return driver.getScreenshotAs(OutputType.BYTES);
    }
}
