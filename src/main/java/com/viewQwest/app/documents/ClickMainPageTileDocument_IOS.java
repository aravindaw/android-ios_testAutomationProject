package com.viewQwest.app.documents;

import com.viewQwest.app.context.ClickMainPageTileContext;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import java.util.HashMap;

import static com.viewQwest.app.scripts.StartDriver.driver;
import static com.viewQwest.app.scripts.StartDriver.iosDriver;

public class ClickMainPageTileDocument_IOS {
    private final ClickMainPageTileContext context;
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ClickMainPageTileDocument_IOS.class);

    public ClickMainPageTileDocument_IOS(ClickMainPageTileContext context) {
        this.context = context;
    }

    public byte[] click() {
        try {
            iosDriver.findElementByAccessibilityId(context.getTileName().trim()).click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("direction", "down");
            js.executeScript("mobile: scroll", scrollObject);
            iosDriver.findElementByAccessibilityId(context.getTileName().trim()).click();
        }
        return iosDriver.getScreenshotAs(OutputType.BYTES);
    }
}