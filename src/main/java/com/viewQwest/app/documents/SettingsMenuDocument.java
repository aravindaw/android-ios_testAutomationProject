package com.viewQwest.app.documents;

import com.viewQwest.app.context.SettingsMenuContext;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import static com.viewQwest.app.scripts.StartDriver.driver;

public class SettingsMenuDocument {
    private final SettingsMenuContext context;

    public void click() {

        AndroidElement menuList = (AndroidElement) driver.findElement(By.id("SettingList"));
        MobileElement item = menuList.findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"" + context.getSelectFromMenu() + "\"));"));
        item.click();
    }

    public SettingsMenuDocument(SettingsMenuContext menu) {
        this.context = menu;
    }
}
